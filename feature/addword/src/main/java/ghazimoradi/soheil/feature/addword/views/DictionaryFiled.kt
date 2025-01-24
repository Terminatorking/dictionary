package ghazimoradi.soheil.feature.addword.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextBodySmall
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextFieldLabelMedium
import ghazimoradi.soheil.core.designsystem.icon.Add
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.BlackAlpha4f
import ghazimoradi.soheil.core.designsystem.ui.Platinum

@Composable
fun DictionaryFiled(
    onIconClicked: (() -> Unit)? = null,
    showIcon: Boolean = false,
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
                modifier = Modifier
                    .fillMaxWidth(if (showIcon) 0.8f else 1.0f)
                    .align(Alignment.CenterEnd),
                value = value,
                hint = hint,
                hintColor = BlackAlpha4f,
                color = Black,
                onValueChange = onValueChange
            )
            if (showIcon) {
                Icon(
                    modifier = Modifier
                        .clickable {
                            onIconClicked?.invoke()
                        }
                        .size(24.dp)
                        .align(Alignment.CenterStart),
                    imageVector = Add,
                    contentDescription = "",
                    tint = Black
                )
            }
        }
    }
}
