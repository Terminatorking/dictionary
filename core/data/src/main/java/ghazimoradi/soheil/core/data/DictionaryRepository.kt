package ghazimoradi.soheil.core.data

import ghazimoradi.soheil.model.Dictionary

interface DictionaryRepository {
    suspend fun getWords(limit: Int, offset: Int):List<Dictionary>
    suspend fun updateWord(dictionary: Dictionary)
}