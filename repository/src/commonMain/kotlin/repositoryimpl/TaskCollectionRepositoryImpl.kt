package repositoryimpl

import datasource.taskcollection.TaskCollectionLocalDataSource
import model.TaskCollection
import repository.TaskCollectionRepository
import java.util.*

class TaskCollectionRepositoryImpl(
    private val taskCollectionLocalDataSource: TaskCollectionLocalDataSource,
) : TaskCollectionRepository {
    override suspend fun upsert(taskCollection: TaskCollection) {
        taskCollectionLocalDataSource.upsert(taskCollection)
    }

    override suspend fun deleteById(id: UUID) {
        taskCollectionLocalDataSource.deleteById(id)
    }
}