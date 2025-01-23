package ghazimoradi.soheil.core.database.dao

import androidx.room.*
import ghazimoradi.soheil.core.database.entities.DictionaryEntity
import ghazimoradi.soheil.core.database.entities.DictionaryEntity.Companion.DICTIONARY_TABLE
import kotlinx.coroutines.flow.Flow

@Dao
interface DictionaryDao {
    @Insert
    suspend fun insertWord(entity: DictionaryEntity)

    @Update
    suspend fun updateWord(entity: DictionaryEntity)

    @Query("select * from $DICTIONARY_TABLE order by id asc limit :limit offset :offset")
    suspend fun getWords(limit: Int, offset: Int): List<DictionaryEntity>

    @Query("select * from $DICTIONARY_TABLE where isBookMarked = 1")
    suspend fun getBookMarkedWords(): Flow<List<DictionaryEntity>>
}