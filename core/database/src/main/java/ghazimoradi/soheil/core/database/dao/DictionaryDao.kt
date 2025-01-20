package ghazimoradi.soheil.core.database.dao

import androidx.room.*
import ghazimoradi.soheil.core.database.entities.DictionaryEntity

@Dao
interface DictionaryDao {
    @Insert
    suspend fun insertWord(entity: DictionaryEntity)

    @Update
    suspend fun updateWord(entity: DictionaryEntity)


}