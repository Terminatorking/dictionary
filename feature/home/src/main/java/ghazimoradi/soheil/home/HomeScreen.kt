package ghazimoradi.soheil.home

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextBodyMedium
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextBodySmall
import ghazimoradi.soheil.core.designsystem.icon.Add
import ghazimoradi.soheil.core.designsystem.icon.Search
import ghazimoradi.soheil.core.designsystem.ui.Anti_Flash_White
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.Bright_Gray
import ghazimoradi.soheil.core.designsystem.ui.Platinum
import ghazimoradi.soheil.core.designsystem.ui.White
import ghazimoradi.soheil.core.ui.WordItems
import ghazimoradi.soheil.home.events.HomeScreenEvents

enum class HomeScreenTabs {
    WORDS,
    BOOKMARKED
}

@Composable
fun HomeScreen(
    context: Context,
    paddingValues: PaddingValues,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    var selectedTab = remember {
        mutableStateOf(HomeScreenTabs.WORDS)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = Anti_Flash_White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ToolBar(context = context)
        DictionaryTabLayOut(
            context = context,
            selectedTab = selectedTab.value,
            onTabChange = {
                selectedTab.value = it
            },
        )
        when (selectedTab.value) {
            HomeScreenTabs.WORDS -> WordList(viewModel = viewModel)
            HomeScreenTabs.BOOKMARKED -> BookMarkedWordList(viewModel = viewModel)
        }
    }
}

@Composable
fun WordList(viewModel: HomeScreenViewModel) {
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

@Composable
fun DictionaryTabLayOut(
    context: Context,
    selectedTab: HomeScreenTabs,
    onTabChange: (HomeScreenTabs) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 12.dp)
            .background(color = Bright_Gray, shape = Shapes().small)
    ) {
        Box(
            modifier = Modifier
                .clickable { onTabChange.invoke(HomeScreenTabs.WORDS) }
                .weight(1f)
                .background(
                    color = if (selectedTab == HomeScreenTabs.WORDS) White else Platinum,
                    shape = Shapes().small
                )
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            DictionaryTextBodySmall(
                text = context.getString(R.string.totalWords),
                color = Black
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .clickable { onTabChange.invoke(HomeScreenTabs.BOOKMARKED) }
                .background(
                    color = if (selectedTab == HomeScreenTabs.BOOKMARKED) White else Platinum,
                    shape = Shapes().small
                )
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            DictionaryTextBodySmall(
                text = context.getString(R.string.bookMarks),
                color = Black
            )
        }
    }
}

@Composable
fun ToolBar(context: Context) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Add,
            contentDescription = "",
            tint = Black
        )
        DictionaryTextBodyMedium(text = context.getString(R.string.dictionary), color = Black)
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Search,
            contentDescription = "",
            tint = Black
        )
    }
}