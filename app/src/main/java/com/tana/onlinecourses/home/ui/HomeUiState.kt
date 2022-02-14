package com.tana.onlinecourses.home.ui

import com.tana.onlinecourses.model.Category
import com.tana.onlinecourses.model.Course

data class HomeUiState(
    val homePopularCourses: List<Course> = emptyList(),
    val categories: List<Category> = emptyList()
) {
    val loading
        get() = homePopularCourses.isEmpty() || categories.isEmpty()
}
