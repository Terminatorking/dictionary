package ghazimoradi.soheil.home

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ghazimoradi.soheil.core.designsystem.ui.Anti_Flash_White
import ghazimoradi.soheil.home.views.BookMarkedWordList
import ghazimoradi.soheil.home.views.DictionaryTabLayOut
import ghazimoradi.soheil.home.views.ToolBar
import ghazimoradi.soheil.home.views.WordList

enum class HomeScreenTabs {
    WORDS,
    BOOKMARKED
}

@Composable
fun HomeScreen(
    navigateToAddWordScreen: () -> Unit,
    navigateToSearchScreen: () -> Unit,
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
        ToolBar(
            context = context,
            navigateToSearchScreen = navigateToSearchScreen,
            navigateToAddWordScreen = navigateToAddWordScreen
        )
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
