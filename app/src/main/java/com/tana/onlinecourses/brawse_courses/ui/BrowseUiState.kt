package com.tana.onlinecourses.brawse_courses.ui

import com.tana.onlinecourses.model.Skill

data class BrowseUiState(
    val skills: List<Skill> = emptyList()
) {
    val loading = skills.isEmpty()
}
