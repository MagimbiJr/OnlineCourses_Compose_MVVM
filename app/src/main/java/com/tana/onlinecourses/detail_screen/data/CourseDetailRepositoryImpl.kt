package com.tana.onlinecourses.detail_screen.data

import com.tana.onlinecourses.home.data.popularCourses
import com.tana.onlinecourses.model.Course
import kotlinx.coroutines.delay

class CourseDetailRepositoryImpl : CourseDetailsRepository {

    override suspend fun courseDetails(id: String): Course? {
        var course: Course? = null
        delay(2000)
        popularCourses.map { mappedCourse ->

            course = Course(
                courseId = id,
                courseTitle = mappedCourse.courseTitle,
                courseAuthor = mappedCourse.courseAuthor,
                coursePrice = mappedCourse.coursePrice,
                courseDuration = mappedCourse.courseDuration,
                courseDescription = mappedCourse.courseDescription,
                courseImage = mappedCourse.courseImage,
                releaseDate = mappedCourse.releaseDate,
                entryLevel = mappedCourse.entryLevel
            )
        }
        return course
    }

}