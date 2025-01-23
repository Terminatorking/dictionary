package ghazimoradi.soheil.core.domain.usecases

import ghazimoradi.soheil.core.data.DictionaryRepository
import ghazimoradi.soheil.model.Dictionary
import javax.inject.Inject

class GetDictionaryWordsUseCase @Inject constructor(
    private val dictionaryRepository: DictionaryRepository
) {
    suspend operator fun invoke(limit: Int, offset: Int): List<Dictionary> {
        return dictionaryRepository.getWords(limit = limit, offset = offset)
    }
}