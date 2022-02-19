package com.tana.onlinecourses.brawse_courses.recommended.data.repository

import com.tana.onlinecourses.brawse_courses.recommended.data.recommendedCourses
import com.tana.onlinecourses.model.Course
import kotlinx.coroutines.delay

class RecommendedRepositoryImpl : RecommendedRepository {
    override suspend fun getRecommended(): List<Course> {
        delay(2000)
        return recommendedCourses
    }
}