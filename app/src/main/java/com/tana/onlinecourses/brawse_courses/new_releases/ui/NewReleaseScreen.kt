package com.tana.onlinecourses.brawse_courses.new_releases.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.onlinecourses.R
import com.tana.onlinecourses.ui.theme.EerieBlackLight
import com.tana.onlinecourses.utils.AppEvents
import kotlinx.coroutines.flow.collect

@Composable
fun NewReleaseScreen(
    modifier: Modifier = Modifier,
    onNavigate: (AppEvents.Navigate) -> Unit,
    onPopBack: (AppEvents.PopBackStack) -> Unit,
    systemUiController: SystemUiController,
    viewModel: NewReleaseViewModel = hiltViewModel(),
) {
    systemUiController.setStatusBarColor(
        if (isSystemInDarkTheme()) EerieBlackLight else
            MaterialTheme.colors.background
    )
    val uiState = viewModel.uiState.collectAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.events.collect { event ->
            when(event) {
                is AppEvents.Navigate -> { onNavigate(event) }
                is AppEvents.PopBackStack -> { onPopBack(event) }
                is AppEvents.ShowSnackbar -> Unit
            }
        }
    }

    if (uiState.loading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Box() {
            NewReleaseContent(
                onCourseClicked = viewModel::onCourseClicked,
                uiState = uiState
            )
        }
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