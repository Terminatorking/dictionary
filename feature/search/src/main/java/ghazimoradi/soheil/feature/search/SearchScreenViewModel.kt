package ghazimoradi.soheil.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ghazimoradi.soheil.core.domain.usecases.SearchInWordsUseCase
import ghazimoradi.soheil.feature.search.events.SearchScreenEvents
import ghazimoradi.soheil.model.Dictionary
import ghazimoradi.soheil.model.SearchType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val searchInWordsUseCase: SearchInWordsUseCase
) : ViewModel() {

    private val _searchWords: MutableStateFlow<List<Dictionary>> =
        MutableStateFlow(emptyList())
    val searchWords: StateFlow<List<Dictionary>> get() = _searchWords

    fun onEvent(event: SearchScreenEvents) {
        when (event) {
            is SearchScreenEvents.Search -> doSearch(
                query = event.query,
                searchType = event.searchType
            )
        }
    }

    private fun doSearch(query: String, searchType: SearchType) {
        viewModelScope.launch {
            searchInWordsUseCase.invoke(query = query, searchType = searchType).let {
                _searchWords.value = it
            }
        }
    }
}