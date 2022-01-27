package com.tana.onlinecourses.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.home.ui.components.AppAnnouncementCard
import com.tana.onlinecourses.home.ui.components.AppReminderCard

@Composable
fun HomeContents(
    homeUiState: HomeUiState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),

    ) {
        if (homeUiState.loading) {
            CircularProgressIndicator(
                modifier = modifier
                    .align(Alignment.Center)
            )
        } else {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                AppReminderCard(modifier = modifier)
                Spacer(modifier = modifier.height(16.dp))
                AppAnnouncementCard(modifier = modifier)
            }
        }
    }
}

//LazyColumn() {
//    items(homeUiState.homePopularCourses) { course ->
//        Column() {
//            Text(text = course.courseTitle)
//            Image(
//                painter = painterResource(id = course.courseImage),
//                contentDescription = "",
//                modifier = modifier
//                    .fillMaxWidth()
//                    .height(160.dp),
//                contentScale = ContentScale.Crop
//            )
//        }
//    }
//}