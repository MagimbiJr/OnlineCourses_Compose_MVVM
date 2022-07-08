package com.tana.onlinecourses.brawse_courses.main.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp

@Composable
fun BrowseCard(
    text: String,
    onBrowseCardClicked: () -> Unit,
    backgroundImage: Int,
    modifier: Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { onBrowseCardClicked() },
        shape = RoundedCornerShape(0.dp)
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(120.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = backgroundImage),
                contentDescription = "",
                modifier = modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Box(modifier = modifier.fillMaxWidth().height(100.dp).background(Color.Black.copy(alpha = .4f)))
            Text(
                text = text.toUpperCase(Locale.current),
                style = MaterialTheme.typography.subtitle2,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(vertical = 24.dp),
                color = Color.White
            )
        }
    }
}