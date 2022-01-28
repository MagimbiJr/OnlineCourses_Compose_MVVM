package com.tana.onlinecourses.home.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.onlinecourses.home.ui.components.HomeTopAppBar
import com.tana.onlinecourses.ui.theme.EerieBlackLight

@Composable
fun HomeScreen(
    systemUiController: SystemUiController,
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
    
    Scaffold(
        topBar = { HomeTopAppBar() }
    ) {
        HomeContents(homeUiState = homeUiState.value)
    }
}