package com.tana.onlinecourses.brawse_courses.recommended.data.repository

import com.tana.onlinecourses.model.Course

interface RecommendedRepository {

    suspend fun getRecommended(): List<Course>

}