package datasourceimpl

import dao.TaskDao
import datasource.task.TaskLocalDataSource
import model.Task
import java.util.*

class TaskLocalDataSourceImpl(
    private val taskDao: TaskDao,
): TaskLocalDataSource {
    override suspend fun upsert(task: Task) {
        taskDao.upsert(task)
    }

    override suspend fun deleteById(id: UUID) {
        taskDao.deleteById(id)
    }
}