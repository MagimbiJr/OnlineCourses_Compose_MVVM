package com.tana.onlinecourses.brawse_courses.recommended.data

import com.tana.onlinecourses.R
import com.tana.onlinecourses.model.Course

val recommendedCourses = mutableListOf(
    Course(
        courseTitle = "Jetpack Compose: Fundamental",
        courseAuthor = "Atanas Charle",
        coursePrice = "$140.00",
        courseDuration = "2h 15 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.navigation_comp,
        releaseDate = "17 June 2021",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "Jetpack Compose: Thinking in compose",
        courseAuthor = "Atanas Charle",
        coursePrice = "$110.00",
        courseDuration = "3h 15 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.navigation_comp,
        releaseDate = "17 Jan 2022",
        entryLevel = "Beginner"
    ),
)