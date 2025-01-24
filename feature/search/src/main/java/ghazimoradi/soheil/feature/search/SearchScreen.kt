package ghazimoradi.soheil.feature.search

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ghazimoradi.soheil.core.designsystem.ui.Anti_Flash_White
import ghazimoradi.soheil.core.ui.bottomSheet.SearchTypeBottomSheet
import ghazimoradi.soheil.feature.search.events.SearchScreenEvents
import ghazimoradi.soheil.feature.search.views.SearchSection
import ghazimoradi.soheil.feature.search.views.WordList
import ghazimoradi.soheil.model.SearchType

@Composable
fun SearchScreen(
    context: Context,
    paddingValues: PaddingValues,
    viewModel: SearchScreenViewModel = hiltViewModel()
) {
    val searchWords = viewModel.searchWords.collectAsState()
    val showBottomSheet = remember {
        mutableStateOf(false)
    }
    val selectedType = remember {
        mutableStateOf(SearchType.En)
    }

    if (showBottomSheet.value) {
        SearchTypeBottomSheet(
            context = context,
            onSelectedType = {
                selectedType.value = it
                showBottomSheet.value = false
            },
            onDismissRequest = {
                showBottomSheet.value = false
            },
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Anti_Flash_White)
            .padding(paddingValues),
    ) {
        SearchSection(
            selectedType = selectedType,
            showBottomSheet = showBottomSheet,
            context = context,
            onSearch = { search ->
                viewModel.onEvent(
                    event = SearchScreenEvents.Search(
                        query = search,
                        searchType = selectedType.value
                    )
                )
            },
        )
        WordList(searchWords = searchWords.value)
    }
}
