package com.tana.onlinecourses.brawse_courses.recommended.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.brawse_courses.components.NewCourseItem
import com.tana.onlinecourses.brawse_courses.new_releases.ui.NewReleaseUiState

@Composable
fun RecommendedContents(
    uiState: RecommendedUiState,
    onCourseClicked: (String) -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (uiState.loading) {
            CircularProgressIndicator()
        } else {
            Column(
                modifier = modifier
                    .fillMaxSize()
            ) {
                Recommended(
                    uiState = uiState,
                    onCourseClicked = onCourseClicked,
                    modifier = modifier
                )
            }
        }
    }
}

@Composable
fun Recommended(
    uiState: RecommendedUiState,
    onCourseClicked: (String) -> Unit,
    modifier: Modifier
) {
    val newReleases = uiState.recommendedCourses

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Spacer(modifier = modifier.height(32.dp))
            Text(
                text = "recommended \n for you".toUpperCase(Locale.current),
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = modifier.height(32.dp))
        }
        items(newReleases) { course ->
            NewCourseItem(
                course = course,
                onCourseClicked = onCourseClicked,
                modifier = modifier
            )
        }
    }
}