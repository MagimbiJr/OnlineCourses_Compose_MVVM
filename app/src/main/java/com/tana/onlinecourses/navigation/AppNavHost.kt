package com.tana.onlinecourses.navigation

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tana.onlinecourses.home.ui.HomeScreen
import com.tana.onlinecourses.navigation.components.AppBottomAppBar
import com.tana.onlinecourses.navigation.routes.BottomNavRoutes

@Composable
fun AppNAvHost(
    navHostController: NavHostController
) {
    val bottomAppItems = listOf(
        BottomNavRoutes.Home,
        BottomNavRoutes.Downloads,
        BottomNavRoutes.Browse,
        BottomNavRoutes.Search
    )
    Scaffold(
        bottomBar = { AppBottomAppBar(navHostController = navHostController, bottomNavItems = bottomAppItems) }
    ) {
        NavHost(navController = navHostController, startDestination = BottomNavRoutes.Home.route) {
            composable(BottomNavRoutes.Home.route) { HomeScreen() }
            composable(BottomNavRoutes.Downloads.route) {}
            composable(BottomNavRoutes.Browse.route) {}
            composable(BottomNavRoutes.Search.route) {}
        }
    }
}