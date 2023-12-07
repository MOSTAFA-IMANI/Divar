package com.mostafa.imani.divar.feature.splash

import androidx.compose.runtime.Immutable

@Immutable
sealed interface SplashUiState {
    object Loading : SplashUiState
    object NavigateToHome : SplashUiState
}