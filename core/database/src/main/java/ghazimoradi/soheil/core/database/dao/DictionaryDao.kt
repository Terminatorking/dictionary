package ghazimoradi.soheil.core.database.dao

import androidx.room.*
import ghazimoradi.soheil.core.database.entities.DictionaryEntity
import ghazimoradi.soheil.core.database.entities.DictionaryEntity.Companion.DICTIONARY_TABLE

@Dao
interface DictionaryDao {
    @Insert
    suspend fun insertWord(entity: DictionaryEntity)

    @Update
    suspend fun updateWord(entity: DictionaryEntity)

    @Query("select * from $DICTIONARY_TABLE")
    suspend fun getAllWords(): List<DictionaryEntity>

}