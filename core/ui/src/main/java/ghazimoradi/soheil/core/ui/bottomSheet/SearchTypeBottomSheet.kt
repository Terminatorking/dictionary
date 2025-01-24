package ghazimoradi.soheil.core.ui.bottomSheet

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextBodySmall
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextLabelLarge
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextLabelMedium
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.Gray
import ghazimoradi.soheil.core.ui.R
import ghazimoradi.soheil.model.SearchType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTypeBottomSheet(
    context: Context,
    selectedType: SearchType,
    onSelectedType: (SearchType) -> Unit,
    onDismissRequest: () -> Unit
) {
    ModalBottomSheet(
        modifier = Modifier.fillMaxWidth(),
        onDismissRequest = onDismissRequest
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                DictionaryTextBodySmall(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = context.getString(R.string.searchType),
                    color = Black
                )
            }
            items(SearchType.entries.toTypedArray()) {
                SearchTypeItem(searchType = it, context = context)
            }
        }
    }
}

@Composable
private fun SearchTypeItem(searchType: SearchType, context: Context) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(width = 1.dp, color = Gray, shape = CircleShape)
            .padding(vertical = 4.dp, horizontal = 6.dp)
    ) {
        DictionaryTextLabelLarge(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = if (searchType == SearchType.En) context.getString(R.string.english)
            else context.getString(
                R.string.persian
            ),
            color = Black
        )
    }
}
