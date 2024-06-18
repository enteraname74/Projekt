package table

import model.Task
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.javatime.datetime

internal object TaskTable: UUIDTable() {
    val title = varchar("title", 128)
    val description = text("description")
    val weight = varchar("weight", 64)
    val creationDate = datetime("creationDate")
    val modifiedDate = datetime("modifiedDate")
    val collectionId = reference("taskCollectionId", TaskCollectionTable, onDelete = ReferenceOption.CASCADE)
}

internal fun ResultRow.toTask(): Task =
    Task(
        id = this[TaskTable.id].value,
        title = this[TaskTable.title],
        description = this[TaskTable.description],
        weight = this[TaskTable.weight],
        creationDate = this[TaskTable.creationDate],
        modifiedDate = this[TaskTable.modifiedDate],
    )