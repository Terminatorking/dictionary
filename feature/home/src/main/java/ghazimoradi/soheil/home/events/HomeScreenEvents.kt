package ghazimoradi.soheil.home.events

import ghazimoradi.soheil.model.Dictionary

sealed class HomeScreenEvents {
    data class UpdateBookMark(val dictionary: Dictionary) : HomeScreenEvents()
    data object LoadNextPage : HomeScreenEvents()
}