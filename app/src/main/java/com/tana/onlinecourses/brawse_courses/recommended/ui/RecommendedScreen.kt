package com.tana.onlinecourses.brawse_courses.recommended.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tana.onlinecourses.R
import com.tana.onlinecourses.utils.AppEvents
import kotlinx.coroutines.flow.collect

@Composable
fun RecommendedScreen(
    onNavigate: (AppEvents.Navigate) -> Unit,
    onPopBack: (AppEvents.PopBackStack) -> Unit,
    viewModel: RecommendedViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.events.collect { event ->
            when(event) {
                is AppEvents.Navigate -> { onNavigate(event) }
                is AppEvents.PopBackStack -> { onPopBack(event) }
                is AppEvents.ShowSnackbar -> Unit
            }
        }
    }

    Box() {
        RecommendedContents(
            uiState = uiState.value,
            onCourseClicked = viewModel::onCourseClicked,
            modifier = modifier
        )

        IconButton(
            onClick = viewModel::onBackButtonClicked ,
            modifier = modifier
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_arrow_icon),
                contentDescription = "",
                modifier = modifier
                    .size(25.dp)
            )
        }
    }
}