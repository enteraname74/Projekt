package dao

import asFlow
import flowTransactionOn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import mapResultRow
import model.Project
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.upsert
import table.ProjectTable
import table.toProject
import java.util.*

class ProjectDao {
    suspend fun upsert(project: Project) {
        flowTransactionOn(ProjectTable) {
            ProjectTable.upsert {
                it[id] = project.id
                it[title] = project.title
                it[description] = project.description
                it[creationDate] = project.creationDate
                it[modifiedDate] = project.modifiedDate
            }
        }
    }
    suspend fun deleteById(id: UUID) {
        flowTransactionOn(ProjectTable) {
            ProjectTable.deleteWhere { ProjectTable.id eq id }
        }
    }
    fun getById(id: UUID): Flow<Project?> =
        ProjectTable
            .selectAll()
            .where { ProjectTable.id eq id }
            .asFlow()
            .mapResultRow { it.toProject() }
            .map { it.firstOrNull() }

    fun getAll(): Flow<List<Project>> =
        transaction {
            ProjectTable
                .selectAll()
                .asFlow()
                .mapResultRow { it.toProject() }
        }
}