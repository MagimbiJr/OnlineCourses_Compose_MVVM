package com.tana.onlinecourses.detail_screen.data

import com.tana.onlinecourses.home.data.popularCourses
import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class CourseDetailRepositoryImpl : CourseDetailsRepository {

    override fun courseDetails(id: String): Flow<Resource<Course>> = flow {

        try {
            delay(2000)
            emit(Resource.Loading())
            val course = popularCourses.find { it.courseId == id }
            if (course != null) {
                emit(Resource.Success(data = course))
            }
        } catch (e: Exception) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something came up"))
        } catch (e: IOException) {
            emit(Resource.Failure(message = e.localizedMessage ?: "Something came up"))
        }
    }

}