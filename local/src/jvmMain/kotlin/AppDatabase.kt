import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import table.ProjectTable
import table.TaskCollectionTable
import table.TaskTable

object AppDatabase {
    fun connectToDatabase() {
        Database.connect("jdbc:sqlite:projektDatabase.db?foreign_keys=on", "org.sqlite.JDBC")
        transaction {
            SchemaUtils.create(
                ProjectTable,
                TaskCollectionTable,
                TaskTable,
            )
        }
    }
}