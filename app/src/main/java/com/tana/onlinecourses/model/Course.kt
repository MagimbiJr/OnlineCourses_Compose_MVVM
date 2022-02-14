package com.tana.onlinecourses.model


data class Course(
    val courseId: String,
    val courseTitle: String,
    val courseAuthor: String,
    val coursePrice: String,
    val courseDuration: String,
    val courseDescription: String,
    val courseImage: Int,
    val releaseDate: String
)