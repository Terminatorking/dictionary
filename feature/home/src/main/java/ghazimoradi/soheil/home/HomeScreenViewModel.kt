package ghazimoradi.soheil.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ghazimoradi.soheil.core.domain.usecases.GetBookMarkedWordsUseCase
import ghazimoradi.soheil.core.domain.usecases.GetDictionaryWordsUseCase
import ghazimoradi.soheil.core.domain.usecases.UpdateWordUseCase
import ghazimoradi.soheil.home.events.HomeScreenEvents
import ghazimoradi.soheil.model.Dictionary
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getDictionaryWordsUseCase: GetDictionaryWordsUseCase,
    private val updateWordUseCase: UpdateWordUseCase,
    private val getBookMarkedWordsUseCase: GetBookMarkedWordsUseCase
) : ViewModel() {

    private var currentPage = 0
    private var pageSize = 20

    private val _words = mutableStateOf<List<Dictionary>>(emptyList())
    val words: MutableState<List<Dictionary>> get() = _words

    private val _bookMarkedWords = mutableStateOf<List<Dictionary>>(emptyList())
    val bookMarkedWords: MutableState<List<Dictionary>> get() = _bookMarkedWords

    init {
        loadNextPage()
        getBookMarkedWords()
    }

    private fun loadNextPage() {
        viewModelScope.launch {
            val collectedWords =
                getDictionaryWordsUseCase.invoke(limit = pageSize, offset = currentPage * pageSize)
            _words.value += collectedWords
            currentPage++
        }
    }

    fun onEvents(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.UpdateBookMark -> updateBookMarked(event.dictionary)
            is HomeScreenEvents.LoadNextPage -> loadNextPage()
        }
    }

    private fun updateBookMarked(dictionary: Dictionary) {
        viewModelScope.launch {
            updateWordUseCase.invoke(dictionary = dictionary)
        }
    }

    private fun getBookMarkedWords() {
        viewModelScope.launch {
            getBookMarkedWordsUseCase.invoke().collect {
                _bookMarkedWords.value = it
            }
        }
    }
}