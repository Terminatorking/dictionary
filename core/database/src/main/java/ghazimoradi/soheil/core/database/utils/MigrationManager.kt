package ghazimoradi.soheil.core.database.utils

import androidx.room.migration.Migration

class MigrationManager(private val migrations: List<Migration>) {
    fun getMigrations(): List<Migration> {
        return migrations
    }
}