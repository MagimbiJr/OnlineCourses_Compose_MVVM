package com.tana.onlinecourses.model

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