actual class LocalDatabaseInitializer {
    actual fun initDatabase() {
        AppDatabase.connectToDatabase()
    }
}