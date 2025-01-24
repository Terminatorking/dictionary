package ghazimoradi.soheil.feature.search.views

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextLabelSmall
import ghazimoradi.soheil.core.designsystem.icon.KeyboardArrowDown
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.Bright_Gray
import ghazimoradi.soheil.core.designsystem.ui.Gray
import ghazimoradi.soheil.feature.search.R
import ghazimoradi.soheil.model.SearchType

@Composable
fun SearchFilter(
    context: Context,
    modifier: Modifier,
    selectedType: MutableState<SearchType>,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .background(color = Bright_Gray, shape = Shapes().small)
            .border(width = 1.dp, color = Gray, shape = Shapes().small)
            .padding(6.dp)
    ) {
        Icon(
            tint = Black,
            imageVector = KeyboardArrowDown,
            contentDescription = "",
            modifier = Modifier.size(24.dp)
        )
        DictionaryTextLabelSmall(
            text = if (selectedType.value == SearchType.En)
                context.getString(R.string.toEnglish)
            else context.getString(R.string.toPersian),
            color = Black,
        )
    }
}
