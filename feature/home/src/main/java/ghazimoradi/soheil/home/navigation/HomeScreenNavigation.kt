package ghazimoradi.soheil.home.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ghazimoradi.soheil.home.HomeScreen

const val HomeScreen = "HomeScreenNavigation"

fun NavGraphBuilder.homeScreen(
    context: Context,
    paddingValues: PaddingValues,
    navigateToSearchScreen: () -> Unit,
    navigateToAddWordScreen: () -> Unit,
) {
    composable(route = HomeScreen) {
        HomeScreen(
            context = context,
            paddingValues = paddingValues,
            navigateToSearchScreen = navigateToSearchScreen,
            navigateToAddWordScreen = navigateToAddWordScreen
        )
    }
}

fun NavController.navigateToHomeScreen() {
    navigate(route = HomeScreen)
}