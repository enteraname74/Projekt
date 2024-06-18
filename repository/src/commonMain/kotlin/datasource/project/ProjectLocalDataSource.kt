package datasource.project

import kotlinx.coroutines.flow.Flow
import model.Project
import java.util.UUID

interface ProjectLocalDataSource {
    fun getById(id: UUID): Flow<Project?>
    suspend fun upsert(project: Project)
    suspend fun deleteById(id: UUID)
    fun getAll(): Flow<List<Project>>
}