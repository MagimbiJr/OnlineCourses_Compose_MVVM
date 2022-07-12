package com.tana.onlinecourses.brawse_courses.new_releases.data.repository

import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.model.courses
import com.tana.onlinecourses.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class NewReleaseCoursesImpl : NewReleaseRepository {
    override suspend fun getNewReleaseCourses(): Flow<Resource<List<Course>>> = flow{
        try {
            delay(1500)
            emit(Resource.Loading())
            val newReleaseCourses = courses
            emit(Resource.Success(data = newReleaseCourses))
        } catch (e: Exception) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something came up"))
        } catch (e: IOException) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something came up"))
        }
    }
}