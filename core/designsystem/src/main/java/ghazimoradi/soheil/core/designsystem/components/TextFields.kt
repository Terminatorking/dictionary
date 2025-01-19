package ghazimoradi.soheil.core.designsystem.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import ghazimoradi.soheil.core.designsystem.ui.Black

@Composable
fun DictionaryTextFieldLabelMedium(
    enable: Boolean = true,
    modifier: Modifier,
    value: String,
    hint: String,
    hintColor: Color = Black,
    color: Color = Black,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.Start,
    onValueChange: (String) -> Unit
) {
    BasicTextField(
        textStyle = MaterialTheme.typography.labelMedium.copy(
            textAlign = textAlign,
            textDirection = textDirection,
            color = color,
        ),
        modifier = modifier,
        value = value,
        decorationBox = {
            if (value.isEmpty()) {
                DictionaryTextLabelMedium(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    text = hint,
                    color = hintColor
                )
            }
            it()
        },
        enabled = enable,
        onValueChange = onValueChange,
    )
}
