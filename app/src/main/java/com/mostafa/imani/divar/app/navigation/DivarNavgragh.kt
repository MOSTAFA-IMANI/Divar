package com.mostafa.imani.divar.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.mostafa.imani.divar.feature.splash.splashNavigationRoute
import com.mostafa.imani.divar.feature.splash.splashScreen

@Composable
fun DivarNavgraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = splashNavigationRoute
    ) {
        splashScreen(
            navigateToHome = {}
        )

    }
}
