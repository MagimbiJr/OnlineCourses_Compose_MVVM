package com.tana.onlinecourses.brawse_courses.new_releases.ui

import com.tana.onlinecourses.model.Course

data class NewReleaseUiState(
    val newReleases: List<Course> = emptyList(),
    val errorMessage: String = ""
) {
    val loading = newReleases.isEmpty()
}