package repository

import kotlinx.coroutines.flow.Flow
import model.Project
import java.util.UUID

interface ProjectRepository {
    fun getById(id: UUID): Flow<Project?>
    suspend fun upsert(project: Project)
    suspend fun deleteById(id: UUID)
    fun getAll(): Flow<List<Project>>
}