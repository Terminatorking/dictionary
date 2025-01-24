package ghazimoradi.soheil.feature.addword.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextLabelMedium
import ghazimoradi.soheil.core.designsystem.icon.Close
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.Gray
import ghazimoradi.soheil.core.designsystem.ui.White

@Composable
fun TranslationItem(
    text: String,
    onDeleteClick: (String) -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(start = 10.dp)
            .background(Gray, shape = CircleShape)
            .padding(2.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        DictionaryTextLabelMedium(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = text,
            color = White
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clickable {
                    onDeleteClick.invoke(text)
                }
                .size(16.dp)
                .background(color = White, shape = CircleShape),
        ) {
            Icon(
                imageVector = Close,
                contentDescription = "",
                modifier = Modifier
                    .size(14.dp),
                tint = Black
            )
        }
        Spacer(modifier = Modifier.size(6.dp))
    }
}