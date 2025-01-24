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

    @Query("select * from $DICTIONARY_TABLE order by enWord asc limit :limit offset :offset")
    suspend fun getWords(limit: Int, offset: Int): List<DictionaryEntity>

    @Query("select * from $DICTIONARY_TABLE where isBookMarked = 1")
    suspend fun getBookMarkedWords(): List<DictionaryEntity>

    @Query("select * from $DICTIONARY_TABLE where enWord like '%' || :query || '%'")
    suspend fun englishSearch(query: String?): List<DictionaryEntity>

    @Query("select * from $DICTIONARY_TABLE where faWord like '%' || :query || '%'")
    suspend fun persianSearch(query: String?): List<DictionaryEntity>
}