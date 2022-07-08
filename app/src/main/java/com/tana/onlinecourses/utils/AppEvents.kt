package com.tana.onlinecourses.utils

import android.content.Context

sealed class AppEvents {
    object PopBackStack : AppEvents()
    data class Navigate(val route: String) : AppEvents()
    data class ShowSnackbar(val message: String) : AppEvents()
    //data class ShowToast(val context: Context, val message: String) : AppEvents()
}