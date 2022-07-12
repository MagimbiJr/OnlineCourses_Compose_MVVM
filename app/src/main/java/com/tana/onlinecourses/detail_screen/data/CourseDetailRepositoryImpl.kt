package com.tana.onlinecourses.detail_screen.data

import android.util.Log
import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.model.courses
import com.tana.onlinecourses.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class CourseDetailRepositoryImpl : CourseDetailsRepository {

    override fun courseDetails(id: String): Flow<Resource<Course>> = flow {

        try {
            delay(1500)
            emit(Resource.Loading())
            val course = courses.find { it.courseId == id }
            Log.d("TAG", "courseDetails: $course")
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