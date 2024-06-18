package dao

import asFlow
import dbQuery
import flowTransactionOn
import kotlinx.coroutines.flow.Flow
import mapResultRow
import model.Task
import model.TaskCollection
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.batchUpsert
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.upsert
import table.ProjectTable
import table.TaskCollectionTable
import table.TaskTable
import table.toTask
import java.util.*

class TaskDao {
    suspend fun upsertAll(tasks: List<Task>) {
        flowTransactionOn(TaskCollectionTable, ProjectTable) {
            TaskCollectionTable.batchUpsert(tasks) { task ->
                this[TaskTable.id] = task.id
                this[TaskTable.title] = task.title
                this[TaskTable.description] = task.description
                this[TaskTable.weight] = task.weight
                this[TaskTable.creationDate] = task.creationDate
                this[TaskTable.modifiedDate] = task.modifiedDate
            }
        }
    }

    suspend fun upsert(task: Task) {
        flowTransactionOn(TaskCollectionTable, ProjectTable) {
            TaskTable.upsert {
                it[id] = task.id
                it[title] = task.title
                it[description] = task.description
                it[weight] = task.weight
                it[creationDate] = task.creationDate
                it[modifiedDate] = task.modifiedDate
            }
        }
    }

    suspend fun deleteById(id: UUID) {
        flowTransactionOn(TaskCollectionTable, ProjectTable) {
            TaskTable
                .deleteWhere { TaskCollectionTable.id eq id }
        }
    }

    suspend fun getAllFromCollectionId(collectionId: UUID): List<Task> =
        dbQuery {
            TaskTable
                .selectAll()
                .where { TaskTable.collectionId eq collectionId}
                .map { it.toTask() }
        }
}