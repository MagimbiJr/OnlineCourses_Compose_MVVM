package com.tana.onlinecourses.home.data.repository


import com.tana.onlinecourses.home.data.categories
import com.tana.onlinecourses.home.data.popularCourses
import com.tana.onlinecourses.model.Category
import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class HomeRepositoryImpl : HomeRepository {
    override suspend fun getHomePopularCourses(): Flow<Resource<List<Course>>> = flow {
        try {
            delay(1500)
            emit(Resource.Loading())
            emit(Resource.Success(data = popularCourses))
        } catch (e: Exception) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something came up"))
        } catch (e: IOException) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something came up"))
        }
    }

    override suspend fun getCategories(): Flow<Resource<List<Category>>> = flow {
        try {
            delay(1500)
            emit(Resource.Loading())
            emit(Resource.Success(data = categories))
        } catch (e: Exception) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something came up"))
        } catch (e: IOException) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something came up"))
        }
    }

}