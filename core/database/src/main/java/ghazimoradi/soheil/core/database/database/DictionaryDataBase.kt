package ghazimoradi.soheil.core.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ghazimoradi.soheil.core.database.dao.DictionaryDao
import ghazimoradi.soheil.core.database.entities.DictionaryEntity

@Database([DictionaryEntity::class], version = 1)
abstract class DictionaryDataBase : RoomDatabase() {
    abstract fun getDictionaryDao(): DictionaryDao
}