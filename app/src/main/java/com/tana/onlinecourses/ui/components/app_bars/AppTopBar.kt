package com.tana.onlinecourses.ui.components.app_bars

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.R
import com.tana.onlinecourses.ui.theme.EerieBlackLight
import com.tana.onlinecourses.ui.theme.JazzberryJam

@Composable
fun AppTopBar(
    title:String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = title) },
        actions = {
            RoundedIconCard(modifier = modifier)
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.more_vert_icon),
                    contentDescription = "Options",
                    modifier = modifier
                        .size(20.dp)
                )
            }
        },
        backgroundColor = if (isSystemInDarkTheme()) EerieBlackLight else
            MaterialTheme.colors.background
    )
}

@Composable
fun RoundedIconCard(
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .size(35.dp)
            .clip(CircleShape)
            .clickable { }
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        MaterialTheme.colors.primary,
                        JazzberryJam
                    )
                )
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Icon(
            painter = painterResource(id = R.drawable.person_icon),
            contentDescription = "Profile icon",
            modifier = modifier.size(25.dp),
            tint = Color.White
        )
    }
}