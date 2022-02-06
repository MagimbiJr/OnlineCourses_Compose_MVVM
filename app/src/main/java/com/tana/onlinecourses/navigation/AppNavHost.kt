package com.tana.onlinecourses.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavArgument
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.onlinecourses.detail_screen.ui.CourseDetailScreen
import com.tana.onlinecourses.home.ui.HomeScreen
import com.tana.onlinecourses.navigation.components.AppBottomAppBar
import com.tana.onlinecourses.navigation.routes.BottomNavRoutes

@Composable
fun AppNAvHost(
    navHostController: NavHostController,
    systemUiController: SystemUiController,
    scaffoldState: ScaffoldState
) {
    val bottomAppItems = listOf(
        BottomNavRoutes.Home,
        BottomNavRoutes.Downloads,
        BottomNavRoutes.Browse,
        BottomNavRoutes.Search
    )
    Scaffold(
        bottomBar = {
            AppBottomAppBar(
                navHostController = navHostController,
                bottomNavItems = bottomAppItems
            )
        }
    ) { paddingValue ->
        NavHost(
            navController = navHostController,
            startDestination = BottomNavRoutes.Home.route,
            modifier = Modifier.padding(paddingValues = paddingValue)
        ) {
            composable(BottomNavRoutes.Home.route) {
                HomeScreen(
                    onNavigate = { navHostController.navigate(it.route) },
                    scaffoldState = scaffoldState,
                    systemUiController = systemUiController
                )
            }
            composable(BottomNavRoutes.Downloads.route) {}
            composable(BottomNavRoutes.Browse.route) {}
            composable(BottomNavRoutes.Search.route) {}
            composable(
                route = "course_details_screen/{id}",
                arguments = listOf(
                    navArgument(name = "id") { type = NavType.StringType }
                )
            ) { navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getString("id")!!
                CourseDetailScreen(
                    id = id,
                    onNavigateBack = { navHostController.popBackStack() },
                    scaffoldState = scaffoldState
                )
            }
        }
    }
}