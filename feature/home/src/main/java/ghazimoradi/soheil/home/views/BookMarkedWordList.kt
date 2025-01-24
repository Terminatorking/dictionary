package ghazimoradi.soheil.home.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import ghazimoradi.soheil.core.ui.WordItems
import ghazimoradi.soheil.home.HomeScreenViewModel
import ghazimoradi.soheil.home.events.HomeScreenEvents


@Composable
fun BookMarkedWordList(viewModel: HomeScreenViewModel) {
    viewModel.getBookMarkedWords()
    val dictionaryBookMarkedWords = viewModel.bookMarkedWords.collectAsState()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(dictionaryBookMarkedWords.value) {
            WordItems(
                dictionary = it,
                onBookMarkClicked = { word ->
                    viewModel.onEvents(HomeScreenEvents.UpdateBookMark(word))
                },
            )
        }
    }
}
