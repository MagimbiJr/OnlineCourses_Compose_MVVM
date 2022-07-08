package com.tana.onlinecourses.home.ui.components

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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.ui.theme.JazzberryJam

@Composable
fun PopularCard(
    course: Course,
    onCourseClicked: (Course) -> Unit,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .height(220.dp)
            .width(180.dp)
            .clip(RoundedCornerShape(4.dp))
            .clickable { onCourseClicked(course) },
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(100.dp),
                ) {
                    Image(
                        painter = painterResource(id = course.courseImage),
                        contentDescription = "Course image",
                        modifier = modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentScale = ContentScale.Crop
                    )
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(brush = Brush.horizontalGradient(
                                listOf(
                                    MaterialTheme.colors.primary.copy(alpha = .6f),
                                    JazzberryJam.copy(alpha = .4f)
                                )
                            )),

                    )
                }
            }
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    text = course.courseTitle,
                    fontWeight = FontWeight.W700
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = course.courseAuthor
                )
                Spacer(modifier = modifier.height(4.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = course.courseDuration)
                    Text(text = course.coursePrice)
                }
            }
        }
    }
}