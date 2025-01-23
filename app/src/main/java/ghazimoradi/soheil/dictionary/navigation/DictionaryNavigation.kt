package ghazimoradi.soheil.dictionary.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ghazimoradi.soheil.feature.addword.navigation.addWordScreen
import ghazimoradi.soheil.feature.search.navigation.searchScreen
import ghazimoradi.soheil.home.navigation.homeScreen


@Composable
fun DictionaryNavigation(
    context: Context,
    paddingValues: PaddingValues,
    modifier: Modifier,
    navHostController: NavHostController,
    startDestination: String
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        addWordScreen(context = context, paddingValues = paddingValues)
        homeScreen(context = context, paddingValues = paddingValues)
        searchScreen(context = context, paddingValues = paddingValues)
    }
}