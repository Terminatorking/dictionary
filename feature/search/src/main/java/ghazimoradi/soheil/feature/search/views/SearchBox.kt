package ghazimoradi.soheil.feature.search.views

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextFieldLabelMedium
import ghazimoradi.soheil.core.designsystem.icon.Search
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.Platinum
import ghazimoradi.soheil.feature.search.R


@Composable
fun SearchBox(
    modifier: Modifier,
    context: Context,
    value: String,
    onValueChange: (String) -> Unit,
) {
    Row(
        modifier = modifier
            .background(color = Platinum, shape = Shapes().small)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        DictionaryTextFieldLabelMedium(
            modifier = modifier,
            hint = context.getString(R.string.searchWord),
            value = value,
            onValueChange = onValueChange
        )
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            tint = Black,
            imageVector = Search,
            contentDescription = "",
            modifier = Modifier.size(20.dp)
        )
    }
}