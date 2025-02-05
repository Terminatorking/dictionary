package ghazimoradi.soheil.feature.addword

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextBodySmall
import ghazimoradi.soheil.core.designsystem.ui.Anti_Flash_White
import ghazimoradi.soheil.core.designsystem.ui.Axolotl
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.Davys_Grey
import ghazimoradi.soheil.core.designsystem.ui.White
import ghazimoradi.soheil.feature.addword.events.AddWordScreenUiEvents
import ghazimoradi.soheil.feature.addword.views.DictionaryFiled
import ghazimoradi.soheil.feature.addword.views.DictionaryOption
import ghazimoradi.soheil.feature.addword.views.DictionaryTabLayOut
import ghazimoradi.soheil.feature.addword.views.TranslationItem
import ghazimoradi.soheil.model.Dictionary

enum class AddWordScreenTabs {
    FA, EN
}

@Composable
fun AddWordScreen(
    navigateToHomeScreen: () -> Unit,
    context: Context,
    paddingValues: PaddingValues,
    viewModel: AddWordScreenViewModel = hiltViewModel()
) {
    var translationWords = remember {
        mutableStateListOf<String>()
    }
    var selectedTab by remember {
        mutableStateOf(AddWordScreenTabs.EN)
    }
    var wordTextFieldValue by remember {
        mutableStateOf("")
    }
    var wordTranslateTextFieldValue by remember {
        mutableStateOf("")
    }
    var addToBookmarksValue by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Anti_Flash_White)
            .padding(paddingValues)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            DictionaryTextBodySmall(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = context.getString(
                    R.string.addNewWords
                ), color = Black
            )
            DictionaryTabLayOut(
                context = context,
                selectedTab = selectedTab,
                onTabChanged = {
                    selectedTab = it
                },
            )
            DictionaryFiled(
                title = context.getString(R.string.word),
                hint = context.getString(R.string.enterWord),
                value = wordTextFieldValue,
                onValueChange = {
                    wordTextFieldValue = it
                }
            )
            DictionaryFiled(
                onIconClicked = {
                    translationWords.add(wordTranslateTextFieldValue)
                    wordTranslateTextFieldValue = ""
                },
                showIcon = true,
                title = context.getString(R.string.wordTranslate),
                hint = context.getString(R.string.enterWordTranslate),
                value = wordTranslateTextFieldValue,
                onValueChange = {
                    wordTranslateTextFieldValue = it
                }
            )
            LazyRow(
                reverseLayout = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(translationWords) {
                    TranslationItem(
                        text = it,
                        onDeleteClick = { translation ->
                            if (translation in translationWords) {
                                translationWords.remove(translation)
                            }
                        },
                    )
                }
            }
            DictionaryOption(
                context = context,
                isChecked = addToBookmarksValue,
                onValueChange = {
                    addToBookmarksValue = addToBookmarksValue.not()
                },
            )
        }
        Box(
            modifier = Modifier
                .clickable {
                    translationWords.forEach { translation ->
                        viewModel.onEvent(
                            AddWordScreenUiEvents.AddNewWord(
                                Dictionary(
                                    enWord = wordTextFieldValue,
                                    faWord = translation,
                                    isBookMarked = addToBookmarksValue
                                )
                            )
                        )
                    }
                    navigateToHomeScreen.invoke()
                }
                .fillMaxWidth()
                .padding(14.dp)
                .background(color = Axolotl, shape = Shapes().small)
                .border(width = 2.dp, color = Davys_Grey, shape = Shapes().small)
                .align(Alignment.BottomEnd),
        ) {
            DictionaryTextBodySmall(
                text = context.getString(R.string.add),
                color = White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}
