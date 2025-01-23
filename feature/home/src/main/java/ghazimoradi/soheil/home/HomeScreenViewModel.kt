package ghazimoradi.soheil.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ghazimoradi.soheil.core.domain.usecases.GetBookMarkedWordsUseCase
import ghazimoradi.soheil.core.domain.usecases.GetDictionaryWordsUseCase
import ghazimoradi.soheil.core.domain.usecases.UpdateWordUseCase
import ghazimoradi.soheil.home.events.HomeScreenEvents
import ghazimoradi.soheil.model.Dictionary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
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

    private val _words = MutableStateFlow<List<Dictionary>>(emptyList())
    val words: StateFlow<List<Dictionary>> get() = _words

    private val _bookMarkedWords = MutableStateFlow<List<Dictionary>>(emptyList())
    val bookMarkedWords: StateFlow<List<Dictionary>> get() = _bookMarkedWords

    init {
        loadNextPage()
        getBookMarkedWords()
    }

    fun loadNextPage() {
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

    fun getBookMarkedWords() {
        viewModelScope.launch {
            _bookMarkedWords.update {
                getBookMarkedWordsUseCase.invoke()
            }
        }
    }
}