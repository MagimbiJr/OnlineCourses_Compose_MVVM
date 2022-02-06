package com.tana.onlinecourses.detail_screen.data

import com.tana.onlinecourses.home.data.Course

interface CourseDetailsRepository {
    suspend fun courseDetails(id: String): Course?
}