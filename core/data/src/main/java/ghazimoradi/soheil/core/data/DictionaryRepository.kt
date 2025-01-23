package ghazimoradi.soheil.core.data

import ghazimoradi.soheil.model.Dictionary
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {
    suspend fun getWords(limit: Int, offset: Int):List<Dictionary>
    suspend fun updateWord(dictionary: Dictionary)
    suspend fun getBookMarkedWords(): Flow<List<Dictionary>>
}