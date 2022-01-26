package com.tana.onlinecourses.home.data

import com.tana.onlinecourses.R
import java.util.*

data class Course(
    val courseId: String,
    val courseTitle: String,
    val courseAuthor: String,
    val coursePrice: String,
    val courseDuration: String,
    val courseDescription: String,
    val courseImage: Int
)

val randomUid = UUID.randomUUID().toString()

val popularCourses = listOf(
    Course(
        courseId = randomUid,
        courseTitle = "Jetpack Compose: Fundamental",
        courseAuthor = "Atanas Charle",
        coursePrice = "$140.00",
        courseDuration = "2h 15 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.navigation_comp
    ),
    Course(
        courseId = randomUid,
        courseTitle = "Understanding MVVM pattern",
        courseAuthor = "Phillip Kalela",
        coursePrice = "$98.00",
        courseDuration = "4h 20 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.android_app_arch
    ),
    Course(
        courseId = randomUid,
        courseTitle = "Android - Architect your App",
        courseAuthor = "Phillip Kalela",
        coursePrice = "$67.00",
        courseDuration = "1h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.android_app_arch
    ),
    Course(
        courseId = randomUid,
        courseTitle = "Kotlin flow: Big picture",
        courseAuthor = "Samwel Charles",
        coursePrice = "$80.00",
        courseDuration = "3h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.kotlin_flow
    ),
    Course(
        courseId = randomUid,
        courseTitle = "Introduction UI/UX",
        courseAuthor = "Jeremiah Charles",
        coursePrice = "$85.00",
        courseDuration = "1h 45 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.ui_ux_fundamental
    ),
    Course(
        courseId = randomUid,
        courseTitle = "UI/UX The best way",
        courseAuthor = "Jeremiah Keneth",
        coursePrice = "$110.00",
        courseDuration = "1h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.android_app_arch
    )
)