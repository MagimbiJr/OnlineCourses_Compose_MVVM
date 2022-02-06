package com.tana.onlinecourses.home.ui

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.onlinecourses.OnlineCoursesApp
import com.tana.onlinecourses.home.data.repository.HomeRepository
import com.tana.onlinecourses.utils.AppEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()
    var clickedIndex = -1

    private val _events = Channel<AppEvents>()
    val events = _events.receiveAsFlow()

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                homePopularCourses = repository.getHomePopularCourses()
            )
            _uiState.value = _uiState.value.copy(
                categories = repository.getCategories()
            )
        }

    }

    fun onCourseClicked(courseId: String) {
        viewModelScope.launch {
            _events.send(
                AppEvents.Navigate(
                    route = "course_details_screen/${courseId}"
                )
            )
            _events.send(
                AppEvents.ShowSnackbar("Clicked ID is $courseId")
            )
        }
    }

}