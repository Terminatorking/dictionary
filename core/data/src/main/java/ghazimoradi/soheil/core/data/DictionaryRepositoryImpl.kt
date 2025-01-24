package ghazimoradi.soheil.core.data

import ghazimoradi.soheil.core.database.dao.DictionaryDao
import ghazimoradi.soheil.core.database.entities.toDictionary
import ghazimoradi.soheil.core.database.entities.toDictionaryEntity
import ghazimoradi.soheil.model.Dictionary
import ghazimoradi.soheil.model.SearchType
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(private val dictionaryDao: DictionaryDao) :
    DictionaryRepository {
    override suspend fun addNewWord(dictionary: Dictionary) {
        dictionaryDao.insertWord(entity = dictionary.toDictionaryEntity())
    }

    override suspend fun getWords(limit: Int, offset: Int): List<Dictionary> {
        return dictionaryDao.getWords(limit = limit, offset = offset).map { dictionaryEntity ->
            dictionaryEntity.toDictionary()
        }
    }

    override suspend fun updateWord(dictionary: Dictionary) {
        dictionaryDao.updateWord(entity = dictionary.toDictionaryEntity())
    }

    override suspend fun getBookMarkedWords(): List<Dictionary> {
        return dictionaryDao.getBookMarkedWords().map {
            it.toDictionary()
        }
    }

    override suspend fun searchWord(query: String?, searchType: SearchType): List<Dictionary> {
        return when (searchType) {
            SearchType.FA -> dictionaryDao.persianSearch(query = query).map { it.toDictionary() }
            SearchType.En -> dictionaryDao.englishSearch(query = query).map { it.toDictionary() }
        }
    }
}