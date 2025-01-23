package ghazimoradi.soheil.core.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ghazimoradi.soheil.core.database.dao.DictionaryDao
import ghazimoradi.soheil.core.database.entities.DictionaryEntity
import ghazimoradi.soheil.core.database.migration.Migration1To2
import ghazimoradi.soheil.core.database.utils.MigrationManager

@Database([DictionaryEntity::class], version = 2)
abstract class DictionaryDataBase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "dictionary"
        fun createMigrations(): MigrationManager {
            val migrations = listOf(Migration1To2())
            return MigrationManager(migrations = migrations)
        }
    }

    abstract fun getDictionaryDao(): DictionaryDao
}