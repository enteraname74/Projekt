package repositoryimpl

import datasource.task.TaskLocalDataSource
import model.Task
import repository.TaskRepository
import java.util.*

class TaskRepositoryImpl(
    private val taskLocalDataSource: TaskLocalDataSource,
): TaskRepository {
    override suspend fun upsert(task: Task) {
        taskLocalDataSource.upsert(task)
    }

    override suspend fun deleteById(id: UUID) {
        taskLocalDataSource.deleteById(id)
    }
}