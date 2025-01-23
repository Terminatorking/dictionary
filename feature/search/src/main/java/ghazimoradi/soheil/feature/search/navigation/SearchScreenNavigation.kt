package ghazimoradi.soheil.feature.search.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ghazimoradi.soheil.feature.search.SearchScreen


const val searchScreenNavigation = "searchScreenNavigation"

fun NavGraphBuilder.searchScreen(context: Context, paddingValues: PaddingValues) {
    composable(route = searchScreenNavigation) {
        SearchScreen(context = context, paddingValues = paddingValues)
    }
}

fun NavController.navigateToSearchScreen(){
    navigate(route = searchScreenNavigation)
}