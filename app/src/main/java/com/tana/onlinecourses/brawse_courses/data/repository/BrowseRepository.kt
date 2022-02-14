package com.tana.onlinecourses.brawse_courses.data.repository

import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.model.Skill

interface BrowseRepository {

    suspend fun getSkills(): List<Skill>

}