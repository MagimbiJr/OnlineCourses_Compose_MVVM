package com.tana.onlinecourses.downloads_screen.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tana.onlinecourses.ui.components.app_bars.AppTopBar
import com.tana.onlinecourses.utils.AppEvents
import kotlinx.coroutines.flow.collect

@Composable
fun DownloadsScreen(
    onNavigateToBrowse: (AppEvents.Navigate) -> Unit,
    onNavigateBack: (AppEvents.PopBackStack) -> Unit,
    viewModel: DownloadsViewModel = viewModel(),
) {
    LaunchedEffect(key1 = true) {
        viewModel.events.collect { event ->
            when(event) {
                is AppEvents.PopBackStack -> { onNavigateBack(event) }
                is AppEvents.Navigate -> { onNavigateToBrowse(event) }
                is AppEvents.ShowSnackbar -> Unit
            }
        }
    }
    
    Scaffold(
        topBar = { AppTopBar(title = "Downloads") }
    ) {
        DownloadsContents(
            onBrowseCoursesButtonClicked = viewModel::navigateToBrowse,
            onBackToHomeCoursesButtonClicked = viewModel::navigateBack,
            viewModel = viewModel,
        )
    }
}