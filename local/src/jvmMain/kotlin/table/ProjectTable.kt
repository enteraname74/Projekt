package table

import model.Project
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.javatime.datetime

internal object ProjectTable: UUIDTable() {
    val title = varchar("title", 128)
    val description = text("description")
    val creationDate = datetime("creationDate")
    val modifiedDate = datetime("modifiedDate")
}

internal fun ResultRow.toProject(): Project =
    Project(
        id = this[ProjectTable.id].value,
        title = this[ProjectTable.title],
        description = this[ProjectTable.description],
        creationDate = this[ProjectTable.creationDate],
        modifiedDate = this[ProjectTable.modifiedDate],
        collections = emptyList()
    )