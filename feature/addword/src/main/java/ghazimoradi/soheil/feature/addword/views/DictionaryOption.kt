package ghazimoradi.soheil.feature.addword.views

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextBodyMedium
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.Gray
import ghazimoradi.soheil.core.designsystem.ui.Platinum
import ghazimoradi.soheil.core.designsystem.ui.White
import ghazimoradi.soheil.feature.addword.R

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
