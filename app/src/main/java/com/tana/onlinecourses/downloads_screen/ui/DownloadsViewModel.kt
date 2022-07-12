package com.tana.onlinecourses.downloads_screen.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.onlinecourses.utils.AppEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class DownloadsViewModel : ViewModel() {
    private val _events = Channel<AppEvents>()
    val events = _events.receiveAsFlow()
    val noDownloadTitle = "No download functionality for now"
    val noDownloadMessage = "Sorry there is no downloads for now and the feature is not yet implemented. " +
            "You can keep interacting with app by clicking one of buttons below"

    fun navigateToBrowse() {
        viewModelScope.launch {
            _events.send(
                AppEvents.Navigate("browse_screen")
            )
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            _events.send(
                AppEvents.PopBackStack
            )
        }
    }
}