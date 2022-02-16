package com.tana.onlinecourses.brawse_courses.main.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.onlinecourses.brawse_courses.main.data.repository.BrowseRepository
import com.tana.onlinecourses.utils.AppEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BrowseViewModel @Inject constructor(
    repository: BrowseRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(BrowseUiState())
    val uiState = _uiState.asStateFlow()
    private val _events = Channel<AppEvents>()
    val events = _events.receiveAsFlow()

    init {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                skills = repository.getSkills()
            )
        }
    }

    fun newReleaseClicked() {
        viewModelScope.launch {
            _events.send(
                AppEvents.Navigate("new_releases")
            )
        }
    }
    fun recommendedClicked() {
        viewModelScope.launch {
            _events.send(
                AppEvents.Navigate("recommended")
            )
        }
    }

    fun showSnackBar() {
        viewModelScope.launch {
            _events.send(
                AppEvents.ShowSnackbar("This feature is not yet implemented")
            )
        }
    }

}