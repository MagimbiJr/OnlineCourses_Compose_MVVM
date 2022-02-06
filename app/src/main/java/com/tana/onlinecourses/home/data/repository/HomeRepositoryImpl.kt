package com.tana.onlinecourses.home.data.repository

import com.tana.onlinecourses.home.data.Category
import com.tana.onlinecourses.home.data.Course
import com.tana.onlinecourses.home.data.categories
import com.tana.onlinecourses.home.data.popularCourses
import kotlinx.coroutines.delay

class HomeRepositoryImpl : HomeRepository {
    override suspend fun getHomePopularCourses(): List<Course> {
        delay(3000)
        return popularCourses
    }

    override suspend fun getCategories(): List<Category> {
        delay(3000)
        return categories
    }

}