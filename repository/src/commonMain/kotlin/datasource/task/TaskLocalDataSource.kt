package datasource.task

import model.Task
import java.util.*

interface TaskLocalDataSource {
    suspend fun upsert(task: Task)
    suspend fun deleteById(id: UUID)
}