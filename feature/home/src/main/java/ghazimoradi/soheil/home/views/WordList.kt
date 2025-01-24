package ghazimoradi.soheil.home.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ghazimoradi.soheil.core.ui.WordItems
import ghazimoradi.soheil.home.HomeScreenViewModel
import ghazimoradi.soheil.home.events.HomeScreenEvents

@Composable
fun WordList(viewModel: HomeScreenViewModel) {
    viewModel.loadNextPage(shouldRestart = true)
    val dictionaryWords = viewModel.words.collectAsState()
    val listState = rememberLazyListState()
    LazyColumn(modifier = Modifier.fillMaxSize(), state = listState) {
        items(dictionaryWords.value) {
            WordItems(
                dictionary = it,
                onBookMarkClicked = { word ->
                    viewModel.onEvents(HomeScreenEvents.UpdateBookMark(word))
                },
            )
        }
    }
    val shouldLoadMore = remember {
        derivedStateOf {
            // Give the last index of the visible item returned by LazyColumn
            val lastVisibleItem = listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
            val totalItems = listState.layoutInfo.totalItemsCount
            lastVisibleItem != null && lastVisibleItem >= totalItems - 2
        }
    }
    //if value of shouldLoadMore change LaunchedEffect will run
    LaunchedEffect(shouldLoadMore.value) {
        if (shouldLoadMore.value) {
            viewModel.onEvents(event = HomeScreenEvents.LoadNextPage)
        }
    }
}
