package ghazimoradi.soheil.core.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import ghazimoradi.soheil.core.database.entities.DictionaryEntity.Companion.DICTIONARY_TABLE
import ghazimoradi.soheil.model.Dictionary

@Entity(tableName = DICTIONARY_TABLE)
data class DictionaryEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val enWord: String,
    val faWord: String,
    val isBookMarked: Boolean,
) {
    companion object {
        const val DICTIONARY_TABLE = "words"
    }
}

fun DictionaryEntity.toDictionary(): Dictionary {
    return Dictionary(
        id = this.id,
        enWord = this.enWord,
        faWord = this.faWord,
        isBookMarked = this.isBookMarked
    )
}

fun Dictionary.toDictionaryEntity(): DictionaryEntity {
    return DictionaryEntity(
        id = this.id,
        enWord = this.enWord,
        faWord = this.faWord,
        isBookMarked = this.isBookMarked
    )
}