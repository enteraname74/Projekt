package datasource.taskcollection

import model.TaskCollection
import java.util.*

interface TaskCollectionLocalDataSource {
    suspend fun upsert(taskCollection: TaskCollection)
    suspend fun deleteById(id: UUID)
}