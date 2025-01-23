package ghazimoradi.soheil.dictionary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ghazimoradi.soheil.core.designsystem.ui.DictionaryTheme
import ghazimoradi.soheil.dictionary.navigation.DictionaryNavigation
import ghazimoradi.soheil.home.navigation.HomeScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DictionaryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navHostController = rememberNavController()
                    DictionaryNavigation(
                        context = this@MainActivity,
                        paddingValues = innerPadding,
                        modifier = Modifier,
                        navHostController = navHostController,
                        startDestination = HomeScreen
                    )
                }
            }
        }
    }
}
