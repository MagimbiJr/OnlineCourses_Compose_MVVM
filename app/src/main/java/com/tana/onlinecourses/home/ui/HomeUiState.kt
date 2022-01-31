package com.tana.onlinecourses.home.ui

import com.tana.onlinecourses.home.data.Category
import com.tana.onlinecourses.home.data.Course

data class HomeUiState(
    val homePopularCourses: List<Course> = emptyList(),
    val categories: List<Category> = emptyList()
) {
    val loading
        get() = homePopularCourses.isEmpty() || categories.isEmpty()
}
