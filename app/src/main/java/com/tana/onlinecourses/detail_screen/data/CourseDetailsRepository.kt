package com.tana.onlinecourses.detail_screen.data

import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CourseDetailsRepository {
    fun courseDetails(id: String): Flow<Resource<Course>>
}