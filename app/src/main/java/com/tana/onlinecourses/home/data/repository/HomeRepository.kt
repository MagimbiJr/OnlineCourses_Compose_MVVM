package com.tana.onlinecourses.home.data.repository

import com.tana.onlinecourses.model.Category
import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.utils.Resource
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun getHomePopularCourses(): Flow<Resource<List<Course>>>

    suspend fun getCategories(): Flow<Resource<List<Category>>>

}