package com.tana.onlinecourses.downloads_screen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.R
import com.tana.onlinecourses.ui.components.buttons.PrimaryButton

@Composable
fun DownloadsContents(
    onBrowseCoursesButtonClicked: () -> Unit,
    onBackToHomeCoursesButtonClicked: () -> Unit,
    viewModel: DownloadsViewModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.download_icon),
            contentDescription = "",
            modifier = modifier
                .size(80.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground.copy(alpha = .5f))
        )
        Spacer(modifier = modifier.height(24.dp))
        DownloadsScreenMessage(viewModel, modifier)
        Spacer(modifier = modifier.height(32.dp))
        ActionButtons(
            onBrowseCoursesButtonClicked = onBrowseCoursesButtonClicked,
            onBackToHomeCoursesButtonClicked = onBackToHomeCoursesButtonClicked,
            modifier = modifier,
        )
    }
}

@Composable
private fun ActionButtons(
    onBrowseCoursesButtonClicked: () -> Unit,
    onBackToHomeCoursesButtonClicked: () -> Unit,
    modifier: Modifier,
) {
    PrimaryButton(
        text = "Browse Courses",
        onClick = onBrowseCoursesButtonClicked,
        modifier = modifier
            .fillMaxWidth()
    )
    Spacer(modifier = modifier.height(12.dp))
    PrimaryButton(
        text = "Navigate Back",
        onClick = onBackToHomeCoursesButtonClicked,
        modifier = modifier
            .fillMaxWidth()
    )
}

@Composable
private fun DownloadsScreenMessage(
    viewModel: DownloadsViewModel,
    modifier: Modifier
) {
    Text(
        text = viewModel.noDownloadTitle,
        style = MaterialTheme.typography.subtitle2,
        textAlign = TextAlign.Justify
    )
    Spacer(modifier = modifier.height(12.dp))
    Text(
        text = viewModel.noDownloadMessage,
        fontWeight = FontWeight.W500,
        textAlign = TextAlign.Justify
    )
}