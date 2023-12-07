package com.mostafa.imani.divar.feature.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class SplashViewModel @Inject constructor() : ViewModel() {
    private val _uiState: MutableStateFlow<SplashUiState> = MutableStateFlow(SplashUiState.Loading)
    val uiState: StateFlow<SplashUiState> = _uiState

    init {
        navigateToHomeAfterAWhile()
    }

    private fun navigateToHomeAfterAWhile() {
        viewModelScope.launch {
            delay(3000)
            _uiState.value = SplashUiState.NavigateToHome
        }
    }
}
