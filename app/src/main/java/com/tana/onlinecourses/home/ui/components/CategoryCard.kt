package com.tana.onlinecourses.home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tana.onlinecourses.model.Category
import com.tana.onlinecourses.ui.theme.JazzberryJam

@Composable
fun CategoryCard(
    category: Category,
    modifier: Modifier
) {
    val brush = Brush.horizontalGradient(
        listOf(
            MaterialTheme.colors.primary,
            JazzberryJam
        )
    )
    Card(
        modifier = modifier
            .height(220.dp)
            .width(180.dp),
    ) {
        Column() {
           Column(
               modifier = modifier
                   .fillMaxWidth()
                   .background(brush = brush)
                   .height(100.dp),
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally
           ) {
               Icon(
                   painter = painterResource(id = category.categoryIcon),
                   contentDescription = "Category icon",
                   modifier = modifier
                       .size(50.dp),
                   tint = Color.White
               )
           }
            Column(
                modifier = modifier
                    .padding(12.dp)
            ) {
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.subtitle2,
                    fontSize = 20.sp
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = category.description,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}