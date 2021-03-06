package com.tana.onlinecourses.model

import com.tana.onlinecourses.R
import java.util.*


data class Course(
    val courseId: String = UUID.randomUUID().toString(),
    val courseTitle: String,
    val courseAuthor: String,
    val coursePrice: String,
    val courseDuration: String,
    val courseDescription: String,
    val courseImage: Int,
    val releaseDate: String,
    val entryLevel: String
)

val courses = listOf(
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
        courseTitle = "Understanding MVVM pattern",
        courseAuthor = "Phillip Kalela",
        coursePrice = "$98.00",
        courseDuration = "4h 20 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.android_app_arch,
        releaseDate = "10 Sep 2020",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "Android - Architect your App",
        courseAuthor = "Phillip Kalela",
        coursePrice = "$67.00",
        courseDuration = "1h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.java_fundamental,
        releaseDate = "15 May 2091",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "Kotlin flow: Big picture",
        courseAuthor = "Samwel Charles",
        coursePrice = "$80.00",
        courseDuration = "3h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.kotlin_flow,
        releaseDate = "17 Mar 2021",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "Introduction UI/UX",
        courseAuthor = "Jeremiah Charles",
        coursePrice = "$85.00",
        courseDuration = "1h 45 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.ui_ux_fundamental,
        releaseDate = "07 June 2018",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "UI/UX The best way",
        courseAuthor = "Jeremiah Charles",
        coursePrice = "$110.00",
        courseDuration = "1h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.kotlin_multiplatform,
        releaseDate = "17 Dec 2021",
        entryLevel = "Beginner"
    ),


    Course(
        courseTitle = "Android - Architect your App",
        courseAuthor = "Phillip Kalela",
        coursePrice = "$67.00",
        courseDuration = "1h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.java_fundamental,
        releaseDate = "15 May 2091",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "Kotlin flow: Big picture",
        courseAuthor = "Samwel Charles",
        coursePrice = "$80.00",
        courseDuration = "3h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.kotlin_flow,
        releaseDate = "17 Mar 2021",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "Introduction UI/UX",
        courseAuthor = "Jeremiah Charles",
        coursePrice = "$85.00",
        courseDuration = "1h 45 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.ui_ux_fundamental,
        releaseDate = "07 June 2018",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "UI/UX The best way",
        courseAuthor = "Jeremiah Charles",
        coursePrice = "$110.00",
        courseDuration = "1h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.kotlin_multiplatform,
        releaseDate = "17 Dec 2021",
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
    Course(
        courseTitle = "MVVM or MVC: Guide to decide which to use",
        courseAuthor = "Phillip Kalela",
        coursePrice = "$98.00",
        courseDuration = "1h 20 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.android_app_arch,
        releaseDate = "10 Aug 2021",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "Hands on Coroutine",
        courseAuthor = "Yeuni Gilbert",
        coursePrice = "$67.00",
        courseDuration = "2h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.kotlin_coroutines,
        releaseDate = "15 May 2020",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "Kotlin Collection",
        courseAuthor = "Samwel Charles",
        coursePrice = "$80.00",
        courseDuration = "3h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.kotlin_flow,
        releaseDate = "27 Jul 2021",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "UI/UX: How to design",
        courseAuthor = "Jeremiah Charles",
        coursePrice = "$85.00",
        courseDuration = "1h 45 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.ui_ux_fundamental,
        releaseDate = "07 June 2019",
        entryLevel = "Beginner"
    ),
    Course(
        courseTitle = "UI/UX: Introduction to FIGMA",
        courseAuthor = "Jeremiah Charles",
        coursePrice = "$110.00",
        courseDuration = "1h 25 mins",
        courseDescription = "Mollit ad nulla laboris nulla anim. Culpa mollit do laboris est id eu." +
                " Est enim labore et ad Lorem. Amet culpa labore ut tempor id occaecat mollit do ipsum" +
                " commodo. Est pariatur culpa ut cupidatat nostrud do deserunt aliquip amet ",
        courseImage = R.drawable.kotlin_multiplatform,
        releaseDate = "17 Dec 2021",
        entryLevel = "Beginner"
    )
)