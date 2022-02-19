package com.tana.onlinecourses.brawse_courses.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tana.onlinecourses.R
import com.tana.onlinecourses.model.Course

@Composable
fun NewCourseItem(
    course: Course,
    onCourseClicked: (String) -> Unit,
    modifier: Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCourseClicked(course.courseId) }
    ) {
        Spacer(modifier = modifier.width(12.dp))
        Image(
            painter = painterResource(id = course.courseImage), 
            contentDescription = "",
            modifier = modifier
                .height(60.dp)
                .width(90.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = modifier.width(12.dp))
        Column(
            modifier = modifier.weight(1f)
        ) {
            Text(
                text = course.courseTitle,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp
            )
            Text(
                text = course.courseAuthor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground.copy(alpha = .4f)
            )
            Row() {
                Text(
                    text = course.entryLevel,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground.copy(alpha = .4f)

                )
                Spacer(modifier = modifier.width(4.dp))
                Text(
                    text = course.releaseDate,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground.copy(alpha = .4f)
                )
                Spacer(modifier = modifier.width(4.dp))
                Text(
                    text = course.courseDuration,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colors.onBackground.copy(alpha = .4f)
                )
            }
        }
        Spacer(modifier = modifier.width(12.dp))
        IconButton(
            onClick = { /*TODO*/ },
            modifier = modifier.align(Alignment.CenterVertically)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.more_vert_icon),
                contentDescription = "",
                modifier = modifier
                    .size(18.dp)
            )
        }
        Spacer(modifier = modifier.width(12.dp))
    }
    Spacer(modifier = modifier.height(12.dp))
    Divider(
        modifier = modifier
            .padding(horizontal = 12.dp)
    )
}