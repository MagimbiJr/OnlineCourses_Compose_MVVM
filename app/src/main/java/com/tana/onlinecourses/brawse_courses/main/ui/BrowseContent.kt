package com.tana.onlinecourses.brawse_courses.main.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.R
import com.tana.onlinecourses.brawse_courses.main.ui.components.AreaOfInterests
import com.tana.onlinecourses.brawse_courses.main.ui.components.BrowseCard
import com.tana.onlinecourses.ui.theme.JazzberryJam

@Composable
fun BrowseContents(
    uiState: BrowseUiState,
    newReleasesClicked: () -> Unit,
    recommendedClicked: () -> Unit,
    onConferenceClicked: () -> Unit,
    onCertificationClicked: () -> Unit,
    onSoftwareDevClicked: () -> Unit,
    onItOpsClicked: () -> Unit,
    onBusinessProfClicked: () -> Unit,
    onCreativeProfClicked: () -> Unit,
    scrollState: ScrollState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (uiState.loading) {
            CircularProgressIndicator()
        } else {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(12.dp)
                    .verticalScroll(state = scrollState)
            ) {
                BrowseCard(
                    text = "new \n releases",
                    onBrowseCardClicked = newReleasesClicked,
                    backgroundImage = R.drawable.card_background_img,
                    modifier = modifier
                )
                Spacer(modifier = modifier.height(8.dp))
                BrowseCard(
                    text = "recommended \n for you",
                    onBrowseCardClicked = recommendedClicked,
                    backgroundImage = R.drawable.card_background_img,
                    modifier = modifier
                )
                Spacer(modifier = modifier.height(16.dp))
                AreaOfInterests(
                    onConferenceClicked = onConferenceClicked,
                    onCertificationClicked = onCertificationClicked,
                    onItOpsClicked = onItOpsClicked,
                    onSoftwareDevClicked = onSoftwareDevClicked,
                    onBusinessProfClicked = onBusinessProfClicked,
                    onCreativeProfClicked = onCreativeProfClicked
                )
                Spacer(modifier = modifier.height(16.dp))
                Skills(uiState = uiState, modifier = modifier)
            }
        }
    }
}

@Composable
fun Skills(
    uiState: BrowseUiState,
    modifier: Modifier
) {
    val skills = uiState.skills

    Text(
        text = "Popular skills",
        style = MaterialTheme.typography.subtitle2
    )
    Spacer(modifier = modifier.height(12.dp))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(skills) { skill ->
            Card(
                shape = CircleShape,
                backgroundColor = if (isSystemInDarkTheme()) MaterialTheme.colors.background.copy(alpha = .1f) else
                    MaterialTheme.colors.surface
            ) {
                if (skill.checked) {
                    Row(
                        modifier = modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Box(
                            modifier = modifier
                                .size(20.dp)
                                .clip(CircleShape)
                                .background(JazzberryJam.copy(alpha = .5f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.check_icon),
                                contentDescription = "",
                                modifier = modifier
                                    .size(12.dp),
                                tint = Color.White
                            )
                        }
                        Spacer(modifier = modifier.width(6.dp))
                        Text(text = skill.skill)
                    }
                } else {
                    Text(
                        text = skill.skill,
                        modifier = modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}