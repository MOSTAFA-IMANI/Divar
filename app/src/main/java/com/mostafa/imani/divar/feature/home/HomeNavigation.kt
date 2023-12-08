package com.mostafa.imani.divar.feature.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

private const val homeNavigationRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.backQueue.clear()
    this.navigate(homeNavigationRoute, navOptions)
}

fun NavGraphBuilder.homeScreen(
    navigateToDetail: () -> Unit,
) {
    composable(homeNavigationRoute) {
        HomeScreen(navigateToDetail = navigateToDetail)
    }
}