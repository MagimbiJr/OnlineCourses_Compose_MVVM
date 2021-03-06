package com.tana.onlinecourses.brawse_courses.recommended.data.repository

import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.model.courses
import com.tana.onlinecourses.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class RecommendedRepositoryImpl : RecommendedRepository {
    override suspend fun getRecommended(): Flow<Resource<List<Course>>> = flow {
        try {
            delay(1500)
            emit(Resource.Loading())
            val recommendedCourses = courses.take(5)
            emit(Resource.Success(data = recommendedCourses))
        } catch (e: Exception) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something came up"))
        } catch (e: IOException) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something came up"))
        }
    }
}