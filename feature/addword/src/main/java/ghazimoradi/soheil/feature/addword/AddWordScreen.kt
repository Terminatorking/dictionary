package ghazimoradi.soheil.feature.addword

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Shapes
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.*
import ghazimoradi.soheil.core.designsystem.ui.*

enum class AddWordScreenTabs {
    FA, EN
}

@Composable
fun AddWordScreen(context: Context, paddingValues: PaddingValues) {
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
                title = context.getString(R.string.wordTranslate),
                hint = context.getString(R.string.enterWordTranslate),
                value = wordTranslateTextFieldValue,
                onValueChange = {
                    wordTranslateTextFieldValue = it
                }
            )
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


@Composable
fun DictionaryOption(
    context: Context,
    isChecked: Boolean,
    onValueChange: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(
            colors = SwitchDefaults.colors(
                checkedThumbColor = White,
                checkedTrackColor = Black,
                uncheckedTrackColor = Platinum,
                uncheckedThumbColor = Gray
            ),
            modifier = Modifier.scale(0.7f),
            checked = isChecked,
            onCheckedChange = onValueChange
        )
        DictionaryTextBodyMedium(
            text = context.getString(R.string.addToBookmarks),
            color = Black,
        )
    }
}

@Composable
fun DictionaryFiled(
    onclick: (() -> Unit)? = null,
    enable: Boolean = true,
    title: String,
    value: String,
    hint: String,
    onValueChange: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        DictionaryTextBodySmall(
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            text = title,
            color = Black
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onclick?.invoke()
                }
                .background(color = Platinum, shape = Shapes().extraSmall)
                .padding(horizontal = 14.dp, vertical = 4.dp)
        ) {
            DictionaryTextFieldLabelMedium(
                enable = enable,
                modifier = Modifier.fillMaxWidth(),
                value = value,
                hint = hint,
                hintColor = BlackAlpha4f,
                color = Black,
                onValueChange = onValueChange
            )
        }
    }
}

@Composable
fun DictionaryTabLayOut(
    context: Context,
    selectedTab: AddWordScreenTabs,
    onTabChanged: (AddWordScreenTabs) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .background(color = Bright_Gray, shape = Shapes().small)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = if (selectedTab == AddWordScreenTabs.FA) White else Platinum,
                        shape = Shapes().small
                    )
                    .clickable {
                        onTabChanged.invoke(AddWordScreenTabs.FA)
                    }
                    .padding(2.dp),
                contentAlignment = Alignment.Center
            ) {
                DictionaryTextLabelLarge(
                    text = context.getString(R.string.persian),
                    color = Black
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = if (selectedTab == AddWordScreenTabs.EN) White else Platinum,
                        shape = Shapes().small
                    )
                    .clickable {
                        onTabChanged.invoke(AddWordScreenTabs.EN)
                    }
                    .padding(2.dp),
                contentAlignment = Alignment.Center
            ) {
                DictionaryTextLabelLarge(
                    text = context.getString(R.string.english),
                    color = Black
                )
            }
        }
    }
}
