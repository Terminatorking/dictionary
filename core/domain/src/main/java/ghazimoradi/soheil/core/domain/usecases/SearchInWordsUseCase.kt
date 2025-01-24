package ghazimoradi.soheil.core.domain.usecases

import ghazimoradi.soheil.core.data.DictionaryRepository
import ghazimoradi.soheil.model.Dictionary
import ghazimoradi.soheil.model.SearchType
import javax.inject.Inject

class SearchInWordsUseCase @Inject constructor(
    private val dictionaryRepository: DictionaryRepository
) {
    suspend operator fun invoke(query: String?, searchType: SearchType): List<Dictionary> {
        return dictionaryRepository.searchWord(query = query, searchType = searchType)
    }
}