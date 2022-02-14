package com.tana.onlinecourses.brawse_courses.data.repository

import com.tana.onlinecourses.brawse_courses.data.skills
import com.tana.onlinecourses.model.Skill
import kotlinx.coroutines.delay

class BrowseRepositoryImpl : BrowseRepository {

    override suspend fun getSkills(): List<Skill> {
        delay(2000)
        return skills
    }

}