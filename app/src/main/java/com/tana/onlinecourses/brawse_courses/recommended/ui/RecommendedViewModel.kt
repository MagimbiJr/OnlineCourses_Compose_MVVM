package com.tana.onlinecourses.brawse_courses.recommended.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.onlinecourses.brawse_courses.recommended.data.repository.RecommendedRepository
import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.utils.AppEvents
import com.tana.onlinecourses.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendedViewModel @Inject constructor(
    private val repository: RecommendedRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecommendedUiState())
    val uiState = _uiState.asStateFlow()
    private val _events = Channel<AppEvents>()
    val events = _events.receiveAsFlow()

    init {
        viewModelScope.launch {
            repository.getRecommended().collect { response ->
                when(response) {
                    is Resource.Success -> {
                        _uiState.value = _uiState.value.copy(
                            recommendedCourses = response.data ?: emptyList()
                        )
                    }
                    is Resource.Failure -> {
                        _uiState.value = _uiState.value.copy(
                            errorMessage = response.message ?: ""
                        )
                    }
                    is Resource.Loading -> Unit
                }
            }
        }
    }

    fun onCourseClicked(course: Course) {
        viewModelScope.launch {
            _events.send(
                AppEvents.Navigate(
                    route = "course_details_screen/${course.courseId}"
                )
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
}