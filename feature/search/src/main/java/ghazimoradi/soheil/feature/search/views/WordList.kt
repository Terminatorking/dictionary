package ghazimoradi.soheil.feature.search.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ghazimoradi.soheil.core.ui.WordItems
import ghazimoradi.soheil.feature.search.SearchScreenViewModel
import ghazimoradi.soheil.feature.search.events.SearchScreenEvents
import ghazimoradi.soheil.model.Dictionary

@Composable
fun WordList(searchWords: List<Dictionary>, viewModel: SearchScreenViewModel) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(searchWords) {
            WordItems(
                dictionary = it,
                onBookMarkClicked = { dictionary ->
                    viewModel.onEvent(
                        SearchScreenEvents.UpdateBookMark(
                            dictionary = dictionary.copy(
                                isBookMarked = true
                            )
                        )
                    )
                }
            )
        }
    }
}

