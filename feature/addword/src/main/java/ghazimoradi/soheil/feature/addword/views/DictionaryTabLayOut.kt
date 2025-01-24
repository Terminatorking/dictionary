package ghazimoradi.soheil.feature.addword.views

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
import ghazimoradi.soheil.core.designsystem.components.DictionaryTextLabelLarge
import ghazimoradi.soheil.core.designsystem.ui.Black
import ghazimoradi.soheil.core.designsystem.ui.Bright_Gray
import ghazimoradi.soheil.core.designsystem.ui.Platinum
import ghazimoradi.soheil.core.designsystem.ui.White
import ghazimoradi.soheil.feature.addword.AddWordScreenTabs
import ghazimoradi.soheil.feature.addword.R


@Composable
fun DictionaryTabLayOut(
    context: Context,
    selectedTab: AddWordScreenTabs,
    onTabChanged: (AddWordScreenTabs) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .background(color = Bright_Gray, shape = Shapes().small)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = if (selectedTab == AddWordScreenTabs.FA) White else Platinum,
                        shape = Shapes().small
                    )
                    .clickable {
                        onTabChanged.invoke(AddWordScreenTabs.FA)
                    }
                    .padding(2.dp),
                contentAlignment = Alignment.Center
            ) {
                DictionaryTextLabelLarge(
                    text = context.getString(R.string.persian),
                    color = Black
                )
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = if (selectedTab == AddWordScreenTabs.EN) White else Platinum,
                        shape = Shapes().small
                    )
                    .clickable {
                        onTabChanged.invoke(AddWordScreenTabs.EN)
                    }
                    .padding(2.dp),
                contentAlignment = Alignment.Center
            ) {
                DictionaryTextLabelLarge(
                    text = context.getString(R.string.english),
                    color = Black
                )
            }
        }
    }
}
