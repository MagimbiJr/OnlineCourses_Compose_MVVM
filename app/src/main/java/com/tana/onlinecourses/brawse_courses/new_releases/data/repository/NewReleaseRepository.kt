package com.tana.onlinecourses.brawse_courses.new_releases.data.repository

import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewReleaseRepository {
    suspend fun getNewReleaseCourses(): Flow<Resource<List<Course>>>
}