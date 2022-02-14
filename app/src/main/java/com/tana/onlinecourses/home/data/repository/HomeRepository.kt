package com.tana.onlinecourses.home.data.repository

import com.tana.onlinecourses.model.Category
import com.tana.onlinecourses.model.Course

interface HomeRepository {

    suspend fun getHomePopularCourses(): List<Course>

    suspend fun getCategories(): List<Category>

}