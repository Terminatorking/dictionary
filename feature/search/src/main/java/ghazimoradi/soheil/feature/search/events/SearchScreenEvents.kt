package ghazimoradi.soheil.feature.search.events

import ghazimoradi.soheil.model.Dictionary
import ghazimoradi.soheil.model.SearchType

sealed class SearchScreenEvents {
    data class Search(val query: String, val searchType: SearchType) : SearchScreenEvents()
    data class UpdateBookMark(val dictionary: Dictionary) : SearchScreenEvents()
}