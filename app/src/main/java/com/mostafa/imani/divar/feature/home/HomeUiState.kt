package com.mostafa.imani.divar.feature.home

import androidx.compose.runtime.Immutable

@Immutable
sealed interface HomeUiState {

    object NoDataError : HomeUiState
    object NavigateToDetail : HomeUiState
}