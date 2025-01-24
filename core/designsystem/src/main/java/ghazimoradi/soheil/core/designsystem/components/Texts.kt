package ghazimoradi.soheil.core.designsystem.components

import android.annotation.SuppressLint
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection

@SuppressLint("ModifierParameter")
@Composable
fun DictionaryTextLabelLarge(
    singleLine: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        maxLines = singleLine,
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelLarge.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@SuppressLint("ModifierParameter")
@Composable
fun DictionaryTextLabelSmall(
    singleLine: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        maxLines = singleLine,
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelSmall.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}
@SuppressLint("ModifierParameter")
@Composable
fun DictionaryTextLabelMedium(
    singleLine: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        maxLines = singleLine,
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.labelMedium.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}

@SuppressLint("ModifierParameter")
@Composable
fun DictionaryTextBodyMedium(
    singleLine: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    text: String,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        maxLines = singleLine,
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}
@SuppressLint("ModifierParameter")
@Composable
fun DictionaryTextBodySmall(
    singleLine: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight = FontWeight.Normal,
    textDirection: TextDirection = TextDirection.Rtl,
    textAlign: TextAlign = TextAlign.End,
    color: Color
) {
    Text(
        maxLines = singleLine,
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodySmall.copy(
            fontWeight = fontWeight,
            textDirection = textDirection,
            color = color
        ),
        textAlign = textAlign,
    )
}