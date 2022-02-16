package com.tana.onlinecourses.brawse_courses.new_releases.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.onlinecourses.brawse_courses.new_releases.data.repository.NewReleaseRepository
import com.tana.onlinecourses.utils.AppEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewReleaseViewModel @Inject constructor(
    repository: NewReleaseRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(NewReleaseUiState())
    val uiState = _uiState.asStateFlow()
    private val _events = Channel<AppEvents>()
    val events = _events.receiveAsFlow()

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                newReleases = repository.getNewReleaseCourses()
            )
        }
    }

    fun onBackButtonClicked() {
        viewModelScope.launch {
            _events.send(
                AppEvents.PopBackStack
            )
        }
    }

    fun onCourseClicked(courseId: String) {
        viewModelScope.launch {
            _events.send(
                AppEvents.Navigate(
                    route = "course_details_screen/$courseId"
                )
            )
        }
    }


}