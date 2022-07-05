package com.tana.onlinecourses.detail_screen.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.onlinecourses.detail_screen.data.CourseDetailsRepository
import com.tana.onlinecourses.model.Course
import com.tana.onlinecourses.utils.AppEvents
import com.tana.onlinecourses.utils.Constants
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
class CourseDetailViewModel @Inject constructor(
    private val repository: CourseDetailsRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(CourseDetailUiState())
    val uiState = _uiState.asStateFlow()
    private val _events = Channel<AppEvents>()
    val events = _events.receiveAsFlow()


    init {
        savedStateHandle.get<String>(Constants.PARAM_COURSE_ID)?.let { courseId ->
            courseDetails(id = courseId)
        }
    }

    private fun courseDetails(id: String) {
        viewModelScope.launch {
            repository.courseDetails(id = id).collect { response ->
                when(response) {
                    is Resource.Success -> {
                        _uiState.value = CourseDetailUiState(course = response.data)
                    }
                    is Resource.Failure -> {
                        _uiState.value = CourseDetailUiState(errorMessage = response.message ?: "")
                    }
                    is Resource.Loading -> Unit
                }
            }
        }
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