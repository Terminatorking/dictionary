package ghazimoradi.soheil.core.database.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import ghazimoradi.soheil.core.database.entities.DictionaryEntity.Companion.DICTIONARY_TABLE

class Migration1To2 : Migration(startVersion = 1, endVersion = 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.addIsBookMarkedColumnToWordsTable()
    }

    private fun SupportSQLiteDatabase.addIsBookMarkedColumnToWordsTable() {
        this.execSQL("ALTER TABLE $DICTIONARY_TABLE ADD COLUMN isBookMarked INTEGER NOT NULL DEFAULT 0")
    }
}