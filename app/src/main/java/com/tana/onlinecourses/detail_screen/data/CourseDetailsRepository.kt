package com.tana.onlinecourses.detail_screen.data

import com.tana.onlinecourses.model.Course

interface CourseDetailsRepository {
    suspend fun courseDetails(id: String): Course?
}