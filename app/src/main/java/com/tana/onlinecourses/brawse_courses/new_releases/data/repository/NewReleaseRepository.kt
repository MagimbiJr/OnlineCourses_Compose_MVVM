package com.tana.onlinecourses.brawse_courses.new_releases.data.repository

import com.tana.onlinecourses.model.Course

interface NewReleaseRepository {
    suspend fun getNewReleaseCourses(): List<Course>
}