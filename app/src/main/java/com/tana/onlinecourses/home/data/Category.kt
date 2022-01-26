package com.tana.onlinecourses.home.data

data class Category(
    val name: String
)

val categories = listOf(
    Category("Android Development"),
    Category("UI/UX Design"),
    Category("Async Programming"),
    Category("JVM")
)