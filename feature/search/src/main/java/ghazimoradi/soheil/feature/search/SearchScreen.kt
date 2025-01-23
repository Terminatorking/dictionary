package ghazimoradi.soheil.feature.search

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.*
import ghazimoradi.soheil.core.designsystem.icon.*
import ghazimoradi.soheil.core.designsystem.ui.*
import ghazimoradi.soheil.core.ui.WordItems

@Composable
fun SearchScreen(context: Context, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Anti_Flash_White)
            .padding(paddingValues),
    ) {
        SearchSection(context = context)
        WordList()
    }
}

@Composable
private fun SearchSection(context: Context) {
    var searchStateValue by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SearchFilter(context = context, modifier = Modifier.weight(0.4f))
        Spacer(modifier = Modifier.width(15.dp))
        SearchBox(
            modifier = Modifier.weight(1f),
            context = context,
            value = searchStateValue,
            onValueChange = { searchStateValue = it },
        )

    }
}

@Composable
fun WordList() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(20) {
//           WordItems()
        }
    }
}

@Composable
private fun SearchFilter(context: Context, modifier: Modifier) {
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
        DictionaryTextLabelMedium(text = context.getString(R.string.toPersian), color = Black)
    }
}

@Composable
private fun SearchBox(
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