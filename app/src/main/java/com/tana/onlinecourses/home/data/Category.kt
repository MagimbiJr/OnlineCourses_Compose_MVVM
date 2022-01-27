package com.tana.onlinecourses.home.data

import com.tana.onlinecourses.R

data class Category(
    val name: String,
    val description: String,
    val categoryIcon: Int
)

val categories = listOf(
    Category(
        name = "Android Development",
        description = "Nisi eiusmod amet veniam nulla elit velit labore " +
                "occaecat sint. Eiusmod sint qui do et proident qui occaecat " +
                "nostrud et minim culpa ",
        categoryIcon = R.drawable.android_logo
    ),
    Category(
        name = "Kotlin Development",
        description = "Nisi eiusmod amet veniam nulla elit velit labore" +
                "occaecat sint. Eiusmod sint qui do et proident qui occaecat" +
                "nostrud et minim culpa",
        categoryIcon = R.drawable.kotlin_icon
    ),
    Category(
        name = "Java Development",
        description = "Nisi eiusmod amet veniam nulla elit velit labore" +
                "occaecat sint. Eiusmod sint qui do et proident qui occaecat" +
                "nostrud et minim culpa",
        categoryIcon = R.drawable.java_logo
    ),
    Category(
        name = "UI/UX Design",
        description = "Nisi eiusmod amet veniam nulla elit velit labore" +
                "occaecat sint. Eiusmod sint qui do et proident qui occaecat" +
                "nostrud et minim culpa",
        categoryIcon = R.drawable.category_icon
    )
)