package ghazimoradi.soheil.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextBodySmall
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextLabelLarge
import ghazimoradi.soheil.core.designsystem.icon.Star
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.BlackHalfAlpha
import ghazimoradi.soheil.core.designsystem.ui.Deep_Champagne
import ghazimoradi.soheil.core.designsystem.ui.Gray
import ghazimoradi.soheil.model.Dictionary

@Composable
fun WordItems(dictionary: Dictionary, onBookMarkClicked: (Dictionary) -> Unit) {
    val isBookMarked = remember {
        mutableStateOf(dictionary.isBookMarked)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(
                color = White,
                shape = RoundedCornerShape(5.dp),
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column {
                DictionaryTextBodySmall(text = dictionary.enWord, color = Black)
                DictionaryTextLabelLarge(text = dictionary.faWord, color = BlackHalfAlpha)
            }
            Icon(
                tint = if (isBookMarked.value) Deep_Champagne else Gray,
                modifier = Modifier
                    .clickable {
                        isBookMarked.value = ! isBookMarked.value
                        onBookMarkClicked.invoke(dictionary.copy(isBookMarked = isBookMarked.value))
                    }.size(24.dp),
                imageVector = Star,
                contentDescription = ""
            )
        }
    }
}
