package datasourceimpl

import dao.ProjectDao
import dao.TaskCollectionDao
import dao.TaskDao
import datasource.project.ProjectLocalDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import model.Project
import model.TaskCollection
import java.util.*
import kotlin.collections.ArrayList

@OptIn(ExperimentalCoroutinesApi::class)
class ProjectLocalDataSourceImpl(
    private val projectDao: ProjectDao,
    private val taskCollectionDao: TaskCollectionDao,
    private val taskDao: TaskDao,
): ProjectLocalDataSource {

    override fun getById(id: UUID): Flow<Project?> =
        projectDao.getById(id = id).flatMapLatest { project ->
            if (project == null) {
                flowOf(null)
            } else {
                val collections = taskCollectionDao.getAllFromProjectId(projectId = project.id)
                val finalConnections: ArrayList<TaskCollection> = arrayListOf()
                collections.forEach { collection ->
                    val tasks = taskDao.getAllFromCollectionId(collectionId = collection.id)
                    finalConnections.add(
                        collection.copy(
                            tasks = tasks
                        )
                    )
                }
                flowOf(project.copy(collections = finalConnections))
            }
        }

    override suspend fun upsert(project: Project) {
        projectDao.upsert(project = project)
        taskCollectionDao.upsertAll(collections = project.collections)
        project.collections.forEach { collection ->
            taskDao.upsertAll(tasks = collection.tasks)
        }
    }

    override suspend fun deleteById(id: UUID) {
        projectDao.deleteById(id = id)
    }

    override fun getAll(): Flow<List<Project>> =
        projectDao.getAll()
}