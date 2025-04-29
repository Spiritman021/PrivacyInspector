package com.tworoot2.privacyinspector.navigation


sealed class AppRoutes(val route: String) {

    data object ROUTE_SPLASH_SCREEN : AppRoutes("splash_screen")
    data object ROUTE_ALL_APPLICATION_SCREEN : AppRoutes("all_application_screen")

}
