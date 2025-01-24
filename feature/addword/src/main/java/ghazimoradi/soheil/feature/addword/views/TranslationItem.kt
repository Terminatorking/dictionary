package ghazimoradi.soheil.feature.addword.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextLabelLarge
import ghazimoradi.soheil.core.designsystem.icon.Close
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.Gray
import ghazimoradi.soheil.core.designsystem.ui.White

@Composable
fun TranslationItem(text: String) {
    Row(
        modifier = Modifier
            .background(Gray, shape = CircleShape)
            .padding(2.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(20.dp)
                .background(color = White, shape = CircleShape),
        ) {
            Icon(
                imageVector = Close,
                contentDescription = "",
                modifier = Modifier.size(18.dp),
                tint = Black
            )
        }
        DictionaryTextLabelLarge(text = text, color = White)
    }
}