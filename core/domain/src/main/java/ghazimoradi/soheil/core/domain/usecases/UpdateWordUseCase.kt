package ghazimoradi.soheil.core.domain.usecases

import ghazimoradi.soheil.core.data.DictionaryRepository
import ghazimoradi.soheil.model.Dictionary
import javax.inject.Inject

class UpdateWordUseCase @Inject constructor(
    private val dictionaryRepository: DictionaryRepository
) {
    suspend operator fun invoke(dictionary: Dictionary) {
        dictionaryRepository.updateWord(dictionary = dictionary)
    }
}