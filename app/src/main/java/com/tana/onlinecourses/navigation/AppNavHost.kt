package com.tana.onlinecourses.navigation

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.onlinecourses.brawse_courses.main.ui.BrowseScreen
import com.tana.onlinecourses.brawse_courses.new_releases.ui.NewReleaseScreen
import com.tana.onlinecourses.brawse_courses.recommended.ui.RecommendedScreen
import com.tana.onlinecourses.detail_screen.ui.CourseDetailScreen
import com.tana.onlinecourses.downloads_screen.ui.DownloadsScreen
import com.tana.onlinecourses.home.ui.HomeScreen
import com.tana.onlinecourses.ui.components.app_bars.AppBottomBar
import com.tana.onlinecourses.navigation.routes.BottomNavRoutes

@Composable
fun AppNAvHost(
    navHostController: NavHostController,
    systemUiController: SystemUiController,
    scaffoldState: ScaffoldState,
    scrollState: ScrollState,
) {
    val bottomAppItems = listOf(
        BottomNavRoutes.Home,
        BottomNavRoutes.Downloads,
        BottomNavRoutes.Browse,
        BottomNavRoutes.Search
    )
    Scaffold(
        bottomBar = {
            AppBottomBar(
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
                    systemUiController = systemUiController,
                    scrollState = scrollState
                )
            }
            composable(BottomNavRoutes.Downloads.route) {
                DownloadsScreen(
                    onNavigateToBrowse = { navHostController.navigate(it.route) },
                    onNavigateBack = { navHostController.popBackStack() }
                )
            }
            composable(BottomNavRoutes.Browse.route) {
                BrowseScreen(
                    onNavigate = { navHostController.navigate(it.route) },
                    scrollState = scrollState,
                    scaffoldState = scaffoldState
                )
            }
            composable(BottomNavRoutes.Search.route) {}
            composable(route = "course_details_screen/{courseId}") {
                CourseDetailScreen(
                    onNavigateBack = { navHostController.popBackStack() },
                    scaffoldState = scaffoldState
                )
            }
            composable("new_releases") {
                NewReleaseScreen(
                    onNavigate = { navHostController.navigate(it.route) },
                    onPopBack = { navHostController.popBackStack() },
                    systemUiController = systemUiController
                )
            }
            composable("recommended") {
                RecommendedScreen(
                    onNavigate = { navHostController.navigate(it.route) },
                    onPopBack = { navHostController.popBackStack() }
                )
            }
        }
    }
}