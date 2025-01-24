package ghazimoradi.soheil.feature.addword

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ghazimoradi.soheil.core.domain.usecases.AddNewWordUseCase
import ghazimoradi.soheil.feature.addword.events.AddWordScreenUiEvents
import ghazimoradi.soheil.model.Dictionary
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddWordScreenViewModel @Inject constructor(
    private val addNewWordUseCase: AddNewWordUseCase
) :
    ViewModel() {

    fun onEvent(event : AddWordScreenUiEvents) {
        when(event) {
            is AddWordScreenUiEvents.AddNewWord -> addNewWord(event.dictionary)
        }
    }

    private fun addNewWord(dictionaryWord: Dictionary) {
        viewModelScope.launch {
            addNewWordUseCase.invoke(dictionaryWord)
        }
    }

}