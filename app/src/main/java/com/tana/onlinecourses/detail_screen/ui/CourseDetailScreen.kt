package com.tana.onlinecourses.detail_screen.ui


import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.tana.onlinecourses.detail_screen.ui.components.DetailScreenTopBar
import com.tana.onlinecourses.utils.AppEvents
import kotlinx.coroutines.flow.collect

@Composable
fun CourseDetailScreen(
    id: String,
    onNavigateBack: (AppEvents.PopBackStack) -> Unit,
    scaffoldState: ScaffoldState,
    viewModel: CourseDetailViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
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
        DetailsContent(
            id = id,
            viewModel = viewModel, modifier = modifier
        )
    }
}