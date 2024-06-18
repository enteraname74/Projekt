package repositoryimpl

import datasource.project.ProjectLocalDataSource
import kotlinx.coroutines.flow.Flow
import model.Project
import repository.ProjectRepository
import java.util.UUID

class ProjectRepositoryImpl(
    private val projectLocalDataSource: ProjectLocalDataSource
): ProjectRepository {
    override fun getById(id: UUID): Flow<Project?> =
        projectLocalDataSource.getById(id = id)

    override suspend fun upsert(project: Project) {
        projectLocalDataSource.upsert(
            project = project,
        )
    }

    override suspend fun deleteById(id: UUID) {
        projectLocalDataSource.deleteById(id = id)
    }

    override fun getAll(): Flow<List<Project>> =
        projectLocalDataSource.getAll()
}