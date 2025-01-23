package ghazimoradi.soheil.feature.addword.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ghazimoradi.soheil.feature.addword.AddWordScreen

const val addWordScreenNavigation = "addWordScreenNavigation"

fun NavGraphBuilder.addWordScreen(context: Context, paddingValues: PaddingValues) {
    composable(route = addWordScreenNavigation) {
        AddWordScreen(context = context, paddingValues = paddingValues)
    }
}

fun NavController.navigateToAddWordScreen(){
    navigate(route = addWordScreenNavigation)
}