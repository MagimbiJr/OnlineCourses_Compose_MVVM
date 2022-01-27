package com.tana.onlinecourses.home.data.repository

import com.tana.onlinecourses.home.data.Category
import com.tana.onlinecourses.home.data.Course

interface HomeRepository {

    suspend fun getHomePopularCourses(): List<Course>

    suspend fun getCategories(): List<Category>

}