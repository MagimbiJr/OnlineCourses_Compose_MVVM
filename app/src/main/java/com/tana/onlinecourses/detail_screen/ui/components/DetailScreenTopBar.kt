package com.tana.onlinecourses.detail_screen.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.R

@Composable
fun DetailScreenTopBar(
    onNavigateBack: () -> Unit,
    onShareClicked: () -> Unit,
    modifier: Modifier,
) {
    TopAppBar(
        title = { Text(text = "Course") },
        navigationIcon = {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    painter = painterResource(id = R.drawable.back_arrow_icon),
                    contentDescription = "Back navigation",
                    modifier = modifier
                        .size(25.dp),
                    tint = MaterialTheme.colors.onBackground
                )
            }
        },
        actions = {
            IconButton(onClick = onShareClicked) {
                Icon(
                    painter = painterResource(id = R.drawable.share_icon),
                    contentDescription = "Share course",
                    modifier = modifier
                        .size(20.dp),
                    tint = MaterialTheme.colors.onBackground
                )
            }
        },
        backgroundColor = MaterialTheme.colors.background
    )
}