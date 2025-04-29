package com.tworoot2.privacyinspector.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tworoot2.privacyinspector.presentation.ui.applications_screen.AllApplicationScreen
import com.tworoot2.privacyinspector.presentation.ui.splash_screen.SplashScreen
import com.tworoot2.privacyinspector.presentation.viewmodel.AllApplicationsViewModel


@Composable
fun AppNavigationHost(
    navHostController: NavHostController,
    viewModel: AllApplicationsViewModel
) {

    NavHost(
        navController = navHostController,
        startDestination = AppRoutes.ROUTE_SPLASH_SCREEN.route
    ) {
        composable(
            route = AppRoutes.ROUTE_SPLASH_SCREEN.route,
            enterTransition = slideUpDownEnterTransition,
            exitTransition = slideUpDownExitTransition,
            popEnterTransition = slideUpDownPopEnterTransition,
            popExitTransition = slideUpDownPopExitTransition
        ) {

            SplashScreen(navHostController = navHostController)
        }

        composable(
            route = AppRoutes.ROUTE_ALL_APPLICATION_SCREEN.route,
            enterTransition = slideUpDownEnterTransition,
            exitTransition = slideUpDownExitTransition,
            popEnterTransition = slideUpDownPopEnterTransition,
            popExitTransition = slideUpDownPopExitTransition
        ) {

            AllApplicationScreen(navHostController = navHostController, viewModel = viewModel)
        }


    }
}