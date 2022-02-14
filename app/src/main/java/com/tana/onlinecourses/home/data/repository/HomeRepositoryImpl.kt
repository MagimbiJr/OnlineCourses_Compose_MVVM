package com.tana.onlinecourses.home.data.repository


import com.tana.onlinecourses.home.data.categories
import com.tana.onlinecourses.home.data.popularCourses
import com.tana.onlinecourses.model.Category
import com.tana.onlinecourses.model.Course
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