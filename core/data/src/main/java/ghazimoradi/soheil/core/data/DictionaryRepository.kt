package ghazimoradi.soheil.core.data

import ghazimoradi.soheil.model.Dictionary
import ghazimoradi.soheil.model.SearchType

interface DictionaryRepository {
    suspend fun getWords(limit: Int, offset: Int): List<Dictionary>
    suspend fun updateWord(dictionary: Dictionary)
    suspend fun getBookMarkedWords(): List<Dictionary>
    suspend fun searchWord(query: String?, searchType: SearchType): List<Dictionary>

}