package com.tana.onlinecourses.detail_screen.ui


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tana.onlinecourses.detail_screen.ui.components.DetailScreenTopBar
import com.tana.onlinecourses.utils.AppEvents
import kotlinx.coroutines.flow.collect

@Composable
fun CourseDetailScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: (AppEvents.PopBackStack) -> Unit,
    scaffoldState: ScaffoldState,
    viewModel: CourseDetailViewModel = hiltViewModel(),
) {
    val uiState = viewModel.uiState.collectAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.events.collect { event ->
            when (event) {
                is AppEvents.Navigate -> Unit
                is AppEvents.PopBackStack -> {
                    onNavigateBack(event)
                }
                is AppEvents.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            DetailScreenTopBar(
                onNavigateBack = viewModel::navigateBack,
                onShareClicked = viewModel::shareButtonClicked,
                modifier = modifier
            )
        }
    ) {
        if (uiState.loading) {
            Box(
                modifier = modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            DetailsContent(
                uiState = uiState,
                onBuyCourseClick = {},
                modifier = modifier
            )
        }
    }
}