package com.tana.onlinecourses.home.data.repository

import com.tana.onlinecourses.home.data.Course

interface HomeRepository {

    suspend fun getHomePopularCourses(): List<Course>

}