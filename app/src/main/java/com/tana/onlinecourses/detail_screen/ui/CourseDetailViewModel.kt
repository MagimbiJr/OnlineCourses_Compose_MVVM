package com.tana.onlinecourses.detail_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.onlinecourses.detail_screen.data.CourseDetailsRepository
import com.tana.onlinecourses.home.data.Course
import com.tana.onlinecourses.utils.AppEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CourseDetailViewModel @Inject constructor(
    private val repository: CourseDetailsRepository
) : ViewModel() {
    private val _events = Channel<AppEvents>()
    val events = _events.receiveAsFlow()


    suspend fun courseDetails(id: String): Course? {
        return repository.courseDetails(id = id)
    }

    fun navigateBack() {
        viewModelScope.launch {
            _events.send(AppEvents.PopBackStack)
        }
    }

    fun shareButtonClicked() {
        viewModelScope.launch {
            _events.send(AppEvents.ShowSnackbar(
                "Share functionality is not implemented yet"
            ))
        }
    }
}