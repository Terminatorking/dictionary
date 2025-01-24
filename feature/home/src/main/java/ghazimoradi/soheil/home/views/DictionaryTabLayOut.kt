package ghazimoradi.soheil.home.views

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextBodySmall
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.Bright_Gray
import ghazimoradi.soheil.core.designsystem.ui.Platinum
import ghazimoradi.soheil.core.designsystem.ui.White
import ghazimoradi.soheil.home.HomeScreenTabs
import ghazimoradi.soheil.home.R

@Composable
fun DictionaryTabLayOut(
    context: Context,
    selectedTab: HomeScreenTabs,
    onTabChange: (HomeScreenTabs) -> Unit
) {
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
                .clickable { onTabChange.invoke(HomeScreenTabs.WORDS) }
                .weight(1f)
                .background(
                    color = if (selectedTab == HomeScreenTabs.WORDS) White else Platinum,
                    shape = Shapes().small
                )
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
                .clickable { onTabChange.invoke(HomeScreenTabs.BOOKMARKED) }
                .background(
                    color = if (selectedTab == HomeScreenTabs.BOOKMARKED) White else Platinum,
                    shape = Shapes().small
                )
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
