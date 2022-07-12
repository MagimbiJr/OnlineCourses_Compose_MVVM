package com.tana.onlinecourses.brawse_courses.main.data.repository

import com.tana.onlinecourses.model.Skill

interface BrowseRepository {

    suspend fun getSkills(): List<Skill>

}