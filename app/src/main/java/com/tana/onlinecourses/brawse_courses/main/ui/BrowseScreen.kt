package com.tana.onlinecourses.brawse_courses.main.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.tana.onlinecourses.ui.components.app_bars.AppTopBar
import com.tana.onlinecourses.utils.AppEvents
import kotlinx.coroutines.flow.collect

@Composable
fun BrowseScreen(
    onNavigate: (AppEvents.Navigate) -> Unit,
    scrollState: ScrollState,
    scaffoldState: ScaffoldState,
    viewModel: BrowseViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.events.collect { event ->
            when(event) {
                is AppEvents.Navigate -> {
                    onNavigate(event)
                }
                is AppEvents.PopBackStack -> Unit
                is AppEvents.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }
    
    Scaffold(
        topBar = { AppTopBar(title = "Browse") },
        scaffoldState = scaffoldState
    ) {
        BrowseContents(
            uiState = uiState.value,
            newReleasesClicked = viewModel::newReleaseClicked,
            recommendedClicked = viewModel::recommendedClicked,
            onConferenceClicked = viewModel::showSnackBar,
            onCertificationClicked = viewModel::showSnackBar,
            onSoftwareDevClicked = viewModel::showSnackBar,
            onItOpsClicked = viewModel::showSnackBar,
            onBusinessProfClicked = viewModel::showSnackBar,
            onCreativeProfClicked = viewModel::showSnackBar,
            scrollState = scrollState
        )
    }
}