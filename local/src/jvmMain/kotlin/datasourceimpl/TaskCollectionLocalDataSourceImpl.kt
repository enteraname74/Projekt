package datasourceimpl

import dao.TaskCollectionDao
import datasource.taskcollection.TaskCollectionLocalDataSource
import model.TaskCollection
import java.util.*

class TaskCollectionLocalDataSourceImpl(
    private val taskCollectionDao: TaskCollectionDao,
) : TaskCollectionLocalDataSource {
    override suspend fun upsert(taskCollection: TaskCollection) {
        taskCollectionDao.upsert(taskCollection)
    }

    override suspend fun deleteById(id: UUID) {
        taskCollectionDao.deleteById(id)
    }
}