package ghazimoradi.soheil.home

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.*
import ghazimoradi.soheil.core.designsystem.icon.*
import ghazimoradi.soheil.core.designsystem.ui.*


@Composable
fun HomeScreen(context: Context, paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(color = Anti_Flash_White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ToolBar(context = context)
        DictionaryTabLayOut(context = context)
        WordList()
    }
}

@Composable
fun WordList() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(20) {
            WordItems()
        }
    }
}

@Composable
fun WordItems() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(
                color = White,
                shape = RoundedCornerShape(5.dp),
            ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column {
                DictionaryTextBodySmall(text = "Hello", color = Black)
                DictionaryTextLabelLarge(text = "سلام", color = BlackHalfAlpha)
            }
            Icon(
                tint = Deep_Champagne,
                modifier = Modifier.size(24.dp),
                imageVector = Star,
                contentDescription = ""
            )
        }
    }
}

@Composable
fun DictionaryTabLayOut(context: Context) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 12.dp)
            .background(color = Bright_Gray, shape = Shapes().small)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(color = White, shape = Shapes().small)
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            DictionaryTextBodySmall(
                text = context.getString(R.string.totalWords),
                color = Black
            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .background(color = Platinum, shape = Shapes().small)
                .padding(2.dp),
            contentAlignment = Alignment.Center
        ) {
            DictionaryTextBodySmall(
                text = context.getString(R.string.bookMarks),
                color = Black
            )
        }
    }
}

@Composable
fun ToolBar(context: Context) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Add,
            contentDescription = "",
            tint = Black
        )
        DictionaryTextBodyMedium(text = context.getString(R.string.dictionary), color = Black)
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = Search,
            contentDescription = "",
            tint = Black
        )
    }
}