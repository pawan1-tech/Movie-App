package com.example.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.presentation.details.DetailScreen
import com.example.movieapp.presentation.home.HomeScreen

@Suppress("ktlint:standard:function-naming")
@Composable
fun WatchAppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToDetails = { contentId ->
                    navController.navigate(Screen.Details.createRoute(contentId))
                },
            )
        }
        composable(
            route = Screen.Details.route, // This will use "deatil/{contentId}"
            arguments =
                listOf(
                    navArgument("contentId") {
                        type = NavType.StringType
                    },
                ),
        ) { backStackEntry ->
            DetailScreen(
                contentId = backStackEntry.arguments?.getString("contentId") ?: "",
                contentType = "movie", // Default value since we' re not passing it in route
                onNavigateBack = {
                    navController.popBackStack()
                },
            )
        }
    }
}
