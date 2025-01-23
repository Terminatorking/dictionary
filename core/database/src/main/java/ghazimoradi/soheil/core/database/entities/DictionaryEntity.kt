package ghazimoradi.soheil.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import ghazimoradi.soheil.core.database.entities.DictionaryEntity.Companion.DICTIONARY_TABLE


@Entity(tableName = DICTIONARY_TABLE)
data class DictionaryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val enWord: String,
    val faWord: String,
//    val isBookmarked: Boolean,
){
    companion object{
        const val DICTIONARY_TABLE = "dictionaryTable"
    }
}