package table

import model.TaskCollection
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ReferenceOption
import org.jetbrains.exposed.sql.ResultRow

internal object TaskCollectionTable: UUIDTable() {
    val title = varchar("title", 128)
    val projectId = reference("projectId", ProjectTable, onDelete = ReferenceOption.CASCADE)
}

internal fun ResultRow.toTaskCollection(): TaskCollection =
    TaskCollection(
        id = this[TaskCollectionTable.id].value,
        title = this[TaskCollectionTable.title],
        tasks = emptyList(),
        projectId = this[TaskCollectionTable.projectId].value
    )