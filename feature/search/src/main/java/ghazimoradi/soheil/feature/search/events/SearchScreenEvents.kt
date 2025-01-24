package ghazimoradi.soheil.feature.search.events

import ghazimoradi.soheil.model.SearchType

sealed class SearchScreenEvents {
    data class Search(val query: String, val searchType: SearchType) : SearchScreenEvents()
}