package com.tana.onlinecourses.detail_screen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.ui.components.buttons.PrimaryButton

@Composable
fun DetailsContent(
    uiState: CourseDetailUiState,
    onBuyCourseClick: () -> Unit,
    modifier: Modifier
) {

    uiState.course?.let { course ->
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = course.courseImage),
                contentDescription = "",
                modifier = modifier
                    .fillMaxWidth()
                    .height(210.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = modifier
                        .weight(1f)
                ) {
                    Text(
                        text = course.courseTitle,
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = modifier.height(12.dp))
                    Row() {
                        Text(text = "By")
                        Spacer(modifier = modifier.width(4.dp))
                        Text(
                            text = course.courseAuthor,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = modifier.height(16.dp))
                    Participants(modifier = modifier)
                    Spacer(modifier = modifier.height(12.dp))
                    CourseDescription(course = course, modifier = modifier)

                }
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = course.coursePrice,
                        //style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    PrimaryButton(
                        text = "Buy this course",
                        onClick = onBuyCourseClick
                    )
                }
            }
        }
    }
}

@Composable
fun CourseDescription(
    course: Course,
    modifier: Modifier
) {
    Column() {
        Text(
            text = "Description",
            style = MaterialTheme.typography.subtitle2,
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = course.courseDescription,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f)
        )
    }
}

@Composable
fun Participants(
    modifier: Modifier
) {
    Column() {
        Text(
            text = "Participants",
            style = MaterialTheme.typography.subtitle2
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = "No participants in this course yet. Be the one by buying this course below",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f)
        )
    }
}