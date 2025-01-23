package ghazimoradi.soheil.core.data

import ghazimoradi.soheil.core.database.dao.DictionaryDao
import ghazimoradi.soheil.core.database.entities.toDictionary
import ghazimoradi.soheil.core.database.entities.toDictionaryEntity
import ghazimoradi.soheil.model.Dictionary
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(private val dictionaryDao: DictionaryDao) :
    DictionaryRepository {
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
}