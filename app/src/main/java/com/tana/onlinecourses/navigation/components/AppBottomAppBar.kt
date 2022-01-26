package com.tana.onlinecourses.navigation.components

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tana.onlinecourses.home.data.randomUid
import com.tana.onlinecourses.navigation.routes.BottomNavRoutes

@Composable
fun AppBottomAppBar(
    navHostController: NavHostController,
    bottomNavItems: List<BottomNavRoutes>,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        backgroundColor = if (isSystemInDarkTheme()) MaterialTheme.colors.background else
            MaterialTheme.colors.surface,
        elevation = 16.dp
    ) {
        val navBackStackEntry = navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route

        bottomNavItems.forEach { screen ->
            BottomNavigationItem(
                selected = screen.route == currentRoute,
                onClick = {
                    navHostController.navigate(screen.route) {
                        popUpTo(navHostController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = null,
                        modifier = modifier
                            .size(25.dp),
                        //tint = MaterialTheme.colors.onBackground
                    )
                },
                label = {
                    Text(
                        text = screen.title,
                        //color = MaterialTheme.colors.onBackground
                    )
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.onBackground
            )
        }
    }
}