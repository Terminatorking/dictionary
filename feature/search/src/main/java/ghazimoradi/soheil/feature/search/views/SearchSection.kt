package ghazimoradi.soheil.feature.search.views

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.model.SearchType


@Composable
 fun SearchSection(
    selectedType: MutableState<SearchType>,
    context: Context,
    onSearch: (String) -> Unit,
    showBottomSheet: MutableState<Boolean>
) {
    var searchStateValue by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SearchFilter(
            selectedType = selectedType,
            context = context,
            modifier = Modifier
                .weight(0.4f)
                .clickable { showBottomSheet.value = true },
        )
        Spacer(modifier = Modifier.width(15.dp))
        SearchBox(
            modifier = Modifier.weight(1f),
            context = context,
            value = searchStateValue,
            onValueChange = {
                searchStateValue = it
                onSearch.invoke(searchStateValue)
            },
        )

    }
}

