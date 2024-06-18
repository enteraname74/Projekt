package dao

import dbQuery
import flowTransactionOn
import model.TaskCollection
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.batchUpsert
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.upsert
import table.ProjectTable
import table.TaskCollectionTable
import table.toTaskCollection
import java.util.*

class TaskCollectionDao {
    suspend fun upsertAll(collections: List<TaskCollection>) {
        flowTransactionOn(TaskCollectionTable, ProjectTable) {
            TaskCollectionTable.batchUpsert(collections) { collection ->
                this[TaskCollectionTable.id] = collection.id
                this[TaskCollectionTable.title] = collection.title
            }
        }
    }

    suspend fun upsert(collection: TaskCollection) {
        flowTransactionOn(TaskCollectionTable, ProjectTable) {
            TaskCollectionTable.upsert {
                it[id] = collection.id
                it[title] = collection.title
            }
        }
    }

    suspend fun deleteById(id: UUID) {
        flowTransactionOn(TaskCollectionTable, ProjectTable) {
            TaskCollectionTable
                .deleteWhere { TaskCollectionTable.id eq id }
        }
    }

    suspend fun getAllFromProjectId(projectId: UUID): List<TaskCollection> =
        dbQuery {
            TaskCollectionTable
                .selectAll()
                .where { TaskCollectionTable.projectId eq projectId}
                .map { it.toTaskCollection() }
        }
}