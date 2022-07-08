package com.tana.onlinecourses.brawse_courses.recommended.ui

import com.tana.onlinecourses.model.Course

data class RecommendedUiState(
    val recommendedCourses: List<Course> = emptyList(),
    val errorMessage: String = ""
) {
    val loading = recommendedCourses.isEmpty()
}
