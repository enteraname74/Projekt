package repository

import model.Task
import java.util.UUID

interface TaskRepository {
    suspend fun upsert(task: Task)
    suspend fun deleteById(id: UUID)
}