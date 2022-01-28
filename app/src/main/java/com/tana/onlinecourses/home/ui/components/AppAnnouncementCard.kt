package com.tana.onlinecourses.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.R
import com.tana.onlinecourses.ui.components.buttons.SecondaryButton
import com.tana.onlinecourses.ui.theme.AcidGreen
import com.tana.onlinecourses.ui.theme.CandyPink
import com.tana.onlinecourses.ui.theme.EerieBlackLight
import com.tana.onlinecourses.ui.theme.Xanthic

@Composable
fun AppAnnouncementCard(
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        backgroundColor = if (isSystemInDarkTheme()) EerieBlackLight else MaterialTheme.colors.surface,
        elevation = 12.dp,
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.compass_icon),
                    contentDescription = "Compass icon",
                    modifier = modifier
                        .size(60.dp),
                    tint = CandyPink
                )
                Spacer(modifier = modifier.width(12.dp))
                Column() {
                    Card(
                        border = BorderStroke(
                            width = 1.dp,
                            color = if (isSystemInDarkTheme()) Xanthic else AcidGreen),
                        backgroundColor = if (isSystemInDarkTheme()) EerieBlackLight else MaterialTheme.colors.surface,
                    ) {
                        Text(
                            text = "Beta".toUpperCase(Locale.current),
                            style = MaterialTheme.typography.caption,
                            color = if (isSystemInDarkTheme()) Xanthic else AcidGreen,
                            modifier = modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                        )
                    }
                    Spacer(modifier = modifier.height(4.dp))
                    Text(
                        text = "Introducing Compass",
                        style = MaterialTheme.typography.subtitle2
                    )
                }
            }
            Spacer(modifier = modifier.height(12.dp))
            Text(
                text = "Catch up the latest android news and updates from across the web",
                //style = MaterialTheme.typography.subtitle2,
                modifier = modifier
                    .fillMaxWidth(),
                //.align(Alignment.CenterHorizontally)
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(4.dp))
            SecondaryButton(
                text = "Explore it now ",
                onClick = { /*TODO*/ },
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}