package repository

import model.TaskCollection
import java.util.UUID

interface TaskCollectionRepository {
    suspend fun upsert(taskCollection: TaskCollection)
    suspend fun deleteById(id: UUID)
}