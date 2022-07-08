package com.tana.onlinecourses.navigation.routes

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector
import com.tana.onlinecourses.R

sealed class BottomNavRoutes(val icon: Int, val title: String, val route: String) {
    object Home : BottomNavRoutes(icon = R.drawable.home_icon, title = "Home", route = "home_screen")
    object Downloads : BottomNavRoutes(icon = R.drawable.download_icon, "Downloads", route = "download_screen")
    object Browse : BottomNavRoutes(icon = R.drawable.launcher_icon, title = "Browse", route = "browse_screen")
    object Search : BottomNavRoutes(icon = R.drawable.search_icon, title = "Search", route = "search_screen")
}
