package com.mostafa.imani.divar.feature.splash

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val splashNavigationRoute = "splash_route"

fun NavController.navigateToSplash(navOptions: NavOptions? = null) {
    this.backQueue.clear()
    this.navigate(splashNavigationRoute, navOptions)
}

fun NavGraphBuilder.splashScreen(
    navigateToHome: () -> Unit,
) {
    composable(splashNavigationRoute) {
        SplashScreen(navigateToHome = navigateToHome)
    }
}