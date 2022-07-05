package com.tana.onlinecourses.detail_screen.ui

import com.tana.onlinecourses.model.Course

data class CourseDetailUiState(
    val course: Course? = null,
    val errorMessage: String = ""
) {
    val loading: Boolean = course == null
}
