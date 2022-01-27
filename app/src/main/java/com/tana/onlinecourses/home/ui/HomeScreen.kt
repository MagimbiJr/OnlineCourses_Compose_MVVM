package com.tana.onlinecourses.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val homeUiState = viewModel.uiState.collectAsState()
    
    HomeContents(homeUiState = homeUiState.value)
}