package com.tana.onlinecourses.brawse_courses.recommended.data.repository

import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RecommendedRepository {

    suspend fun getRecommended(): Flow<Resource<List<Course>>>

}