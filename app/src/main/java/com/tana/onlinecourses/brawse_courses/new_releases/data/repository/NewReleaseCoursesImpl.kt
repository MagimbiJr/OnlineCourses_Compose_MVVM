package com.tana.onlinecourses.brawse_courses.new_releases.data.repository

import com.tana.onlinecourses.brawse_courses.new_releases.data.newReleases
import com.tana.onlinecourses.model.Course
import kotlinx.coroutines.delay

class NewReleaseCoursesImpl : NewReleaseRepository {
    override suspend fun getNewReleaseCourses(): List<Course> {
        delay(2000)
        return newReleases
    }
}