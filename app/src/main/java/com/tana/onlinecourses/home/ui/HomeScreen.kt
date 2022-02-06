package com.tana.onlinecourses.home.ui

import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.onlinecourses.home.ui.components.HomeTopAppBar
import com.tana.onlinecourses.ui.theme.EerieBlackLight
import com.tana.onlinecourses.utils.AppEvents
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect


@Composable
fun HomeScreen(
    onNavigate: (AppEvents.Navigate) -> Unit,
    systemUiController: SystemUiController,
    scaffoldState: ScaffoldState,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val homeUiState = viewModel.uiState.collectAsState()
    systemUiController.setStatusBarColor(
        color = if (isSystemInDarkTheme()) EerieBlackLight else
            MaterialTheme.colors.background

    )
    systemUiController.setNavigationBarColor(
        color = if (isSystemInDarkTheme()) MaterialTheme.colors.background else
            MaterialTheme.colors.surface
    )
    
    LaunchedEffect(key1 = true) {
        viewModel.events.collect { event ->
            when(event) {
                is AppEvents.PopBackStack -> Unit
                is AppEvents.Navigate -> { onNavigate(event) }
                is AppEvents.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.message
                    )
                }
            }
        }
    }
    
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { HomeTopAppBar() }
    ) {
        HomeContents(
            homeUiState = homeUiState.value,
            onCourseClicked = viewModel::onCourseClicked,
            viewModel = viewModel
        )
    }
}