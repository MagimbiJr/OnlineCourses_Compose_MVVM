package com.tana.onlinecourses.home.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.R
import com.tana.onlinecourses.ui.components.buttons.OutlineButton
import com.tana.onlinecourses.ui.theme.EerieBlack
import com.tana.onlinecourses.ui.theme.JazzberryJam
import com.tana.onlinecourses.ui.theme.Shapes

@Composable
fun AppReminderCard(
    modifier: Modifier
) {
    val brush = Brush.horizontalGradient(
        listOf(
            MaterialTheme.colors.primary,
            JazzberryJam
        )
    )
    Card(
        modifier = modifier
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = Shapes.medium,
        backgroundColor = if (isSystemInDarkTheme()) EerieBlack else MaterialTheme.colors.surface
    ) {
        Row(
            modifier = modifier
                .background(color = Color.Transparent)
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.tracker_icon),
                contentDescription = "Tracker icon",
                modifier = modifier
                    //.background(brush = brush)
                    .size(80.dp),
                tint = JazzberryJam
            )
            Spacer(modifier = modifier.width(12.dp))
            Column() {
                Text(
                    text = "Track your progress and stay motivated to hit your goal.",
                    fontWeight = FontWeight.W500
                )
                Spacer(modifier = modifier.height(12.dp))
                OutlineButton(text = "Set personal goal", onClick = { /*TODO*/ })
            }
        }
    }
}