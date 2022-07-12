package com.tana.onlinecourses.brawse_courses.main.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp

@Composable
fun AreaOfInterests(
    onConferenceClicked: () -> Unit,
    onCertificationClicked: () -> Unit,
    onSoftwareDevClicked: () -> Unit,
    onItOpsClicked: () -> Unit,
    onBusinessProfClicked: () -> Unit,
    onCreativeProfClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Card(
                backgroundColor = MaterialTheme.colors.background,
                shape = RoundedCornerShape(0.dp)
            ) {
                Column() {
                    InterestItem(item = "conferences", onItemClicked = onConferenceClicked, modifier = modifier)
                    Spacer(modifier = modifier.height(8.dp))
                    InterestItem(item = "certifications", onItemClicked = onCertificationClicked, modifier = modifier)
                }
            }
        }
        item {
            Card(
                backgroundColor = MaterialTheme.colors.background,
                shape = RoundedCornerShape(0.dp)
            ) {
                Column() {
                    InterestItem(item = "software \n development", onItemClicked = onSoftwareDevClicked, modifier = modifier)
                    Spacer(modifier = modifier.height(8.dp))
                    InterestItem(item = "it \n ops", onItemClicked = onItOpsClicked, modifier = modifier)
                }
            }
        }
        item {
            Card(
                backgroundColor = MaterialTheme.colors.background,
                shape = RoundedCornerShape(0.dp)
            ) {
                Column() {
                    InterestItem(item = "Business \n professional", onItemClicked = onBusinessProfClicked, modifier = modifier)
                    Spacer(modifier = modifier.height(8.dp))
                    InterestItem(item = "creative \n professional", onItemClicked = onCreativeProfClicked, modifier = modifier)
                }
            }
        }
    }
}

@Composable
fun InterestItem(
    item: String,
    onItemClicked: () -> Unit,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .width(200.dp)
            .height(70.dp)
            .background(color = if (isSystemInDarkTheme()) MaterialTheme.colors.onBackground.copy(alpha = .1f)
            else MaterialTheme.colors.surface)
            .clickable { onItemClicked() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = item.toUpperCase(Locale.current),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}