package ghazimoradi.soheil.home.views

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextBodyMedium
import ghazimoradi.soheil.core.designsystem.icon.Add
import ghazimoradi.soheil.core.designsystem.icon.Search
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.home.R


@Composable
fun ToolBar(
    context: Context,
    navigateToSearchScreen: () -> Unit,
    navigateToAddWordScreen: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable { navigateToAddWordScreen.invoke() },
            imageVector = Add,
            contentDescription = "",
            tint = Black
        )
        DictionaryTextBodyMedium(text = context.getString(R.string.dictionary), color = Black)
        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable { navigateToSearchScreen.invoke() },
            imageVector = Search,
            contentDescription = "",
            tint = Black
        )
    }
}