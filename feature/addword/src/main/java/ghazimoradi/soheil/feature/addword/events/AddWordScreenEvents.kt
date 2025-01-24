package ghazimoradi.soheil.feature.addword.events

import ghazimoradi.soheil.model.Dictionary

sealed class AddWordScreenUiEvents {
    data class AddNewWord(val dictionary: Dictionary) : AddWordScreenUiEvents()
}