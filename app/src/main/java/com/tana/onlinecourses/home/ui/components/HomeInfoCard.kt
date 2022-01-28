package com.tana.onlinecourses.home.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeInfoCard(
    modifier: Modifier
) {
    var isToggled by remember { mutableStateOf(false) }
    var icon by remember { mutableStateOf(Icons.Default.ArrowDropDown) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(230.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.online_courses_image_1),
                contentDescription = "Info card image",
                modifier = modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = .4f))
            )
            Card(
                modifier = modifier
                    .padding(top = 16.dp, end = 12.dp)
                    .align(Alignment.TopEnd)
                    .clickable {
                        isToggled = !isToggled
                        icon =
                            if (isToggled) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown
                    },
                backgroundColor = Color.Black.copy(alpha = .4f)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    modifier = modifier
                        .padding(12.dp)
                        .align(Alignment.TopEnd),
                    tint = Color.White
                )
            }
            Column(
                modifier = modifier
                    .padding(start = 12.dp, end = 12.dp, bottom = 16.dp)
                    .align(Alignment.BottomStart)
            ) {
                if (isToggled) {
                    AnimatedVisibility(
                        visible = isToggled,
                    ) {
                        Text(
                            text = "Sint incididunt voluptate fugiat et elit pariatur dolore. Enim officia " +
                                    "esse incididunt nisi voluptate officia esse est fugiat cupidatat tempor. " +
                                    "Quis nisi mollit duis proident non in sit",
                            color = Color.White
                        )
                    }
                }
                Spacer(modifier = modifier.height(6.dp))
                Text(
                    text = "Keep learning and track your progress. " +
                            "We will be helping you to track your progress.",
                    color = Color.White,
                )
            }
        }
    }
}