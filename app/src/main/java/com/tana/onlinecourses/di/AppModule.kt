package com.tana.onlinecourses.di

import com.tana.onlinecourses.brawse_courses.data.repository.BrowseRepository
import com.tana.onlinecourses.brawse_courses.data.repository.BrowseRepositoryImpl
import com.tana.onlinecourses.detail_screen.data.CourseDetailRepositoryImpl
import com.tana.onlinecourses.detail_screen.data.CourseDetailsRepository
import com.tana.onlinecourses.home.data.repository.HomeRepository
import com.tana.onlinecourses.home.data.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHomeRepository(): HomeRepository {
        return HomeRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideCourseDetailsRepository(): CourseDetailsRepository {
        return CourseDetailRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideBrowseRepository(): BrowseRepository {
        return BrowseRepositoryImpl()
    }

}