package com.tana.onlinecourses.home.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.home.ui.components.*

@Composable
fun HomeContents(
    homeUiState: HomeUiState,
    onCourseClicked: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    scrollState: ScrollState
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
                    .verticalScroll(scrollState)
            ) {
                AppReminderCard(modifier = modifier)
                Spacer(modifier = modifier.height(12.dp))
                AppAnnouncementCard(modifier = modifier)
                Spacer(modifier = modifier.height(12.dp))
                HomeInfoCard(modifier = modifier)
                Spacer(modifier = modifier.height(24.dp))
                Categories(homeUiState = homeUiState)
                Spacer(modifier = modifier.height(24.dp))
                PopularCourses(
                    homeUiState = homeUiState,
                    onCourseClicked = onCourseClicked,
                    modifier = modifier,
                    viewModel = viewModel
                )
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

    Text(
        text = "Category",
        style = MaterialTheme.typography.subtitle2
    )
    Spacer(modifier = modifier.height(12.dp))
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
    onCourseClicked: (String) -> Unit,
    modifier: Modifier,
    viewModel: HomeViewModel
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
        itemsIndexed(popularCourses) { index, course ->
            Log.d(TAG, "PopularCourses: $index")
            viewModel.clickedIndex = index
            Log.d(TAG, "PopularCourses: view model index is ${viewModel.clickedIndex}")
            PopularCard(onCourseClicked = onCourseClicked, course = course, modifier = modifier)
        }
    }
    //onCourseClicked

}

const val TAG = "Tag la BUG"