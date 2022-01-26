package com.tana.onlinecourses.home.data.repository

import com.tana.onlinecourses.home.data.Course
import com.tana.onlinecourses.home.data.popularCourses
import kotlinx.coroutines.delay

class HomeRepositoryImpl : HomeRepository {
    override suspend fun getHomePopularCourses(): List<Course> {
        delay(5000)
        return popularCourses
    }

}