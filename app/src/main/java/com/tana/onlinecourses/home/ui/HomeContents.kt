package com.tana.onlinecourses.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.home.ui.components.AppAnnouncementCard
import com.tana.onlinecourses.home.ui.components.AppReminderCard
import com.tana.onlinecourses.home.ui.components.CategoryCard
import com.tana.onlinecourses.home.ui.components.PopularCard

@Composable
fun HomeContents(
    homeUiState: HomeUiState,
    modifier: Modifier = Modifier
) {

    val scrollState = rememberScrollState()
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
                    .verticalScroll(scrollState)
            ) {
                AppReminderCard(modifier = modifier)
                Spacer(modifier = modifier.height(12.dp))
                AppAnnouncementCard(modifier = modifier)
                Spacer(modifier = modifier.height(12.dp))
                Categories(homeUiState = homeUiState)
                Spacer(modifier = modifier.height(24.dp))
                PopularCourses(homeUiState = homeUiState, modifier = modifier)
            }
        }
    }
}

@Composable
fun Categories(
    homeUiState: HomeUiState,
    modifier: Modifier = Modifier
) {
    val categories = homeUiState.categories


    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(19.dp)
    ) {
        items(categories) { category ->
            CategoryCard(category = category, modifier = modifier)
        }
    }
}

@Composable
fun PopularCourses(
    homeUiState: HomeUiState,
    modifier: Modifier
) {
    val popularCourses = homeUiState.homePopularCourses
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Popular",
            style = MaterialTheme.typography.subtitle2
        )
        Text(
            text = "See all",
            modifier = modifier
                .clickable {  }
        )
    }
    Spacer(modifier = modifier.height(12.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(19.dp)
    ) {
        items(popularCourses) { course ->
            PopularCard(course = course, modifier = modifier)
        }
    }
}