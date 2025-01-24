package ghazimoradi.soheil.core.domain.usecases

import ghazimoradi.soheil.core.data.DictionaryRepository
import ghazimoradi.soheil.model.Dictionary
import javax.inject.Inject

class AddNewWordUseCase @Inject constructor(
    private val dictionaryRepository: DictionaryRepository
) {
    suspend operator fun invoke(dictionary: Dictionary) {
        dictionaryRepository.addNewWord(dictionary = dictionary)
    }
}