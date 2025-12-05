package com.example.concert_app.viewmodels

import androidx.lifecycle.ViewModel
import com.example.concert_app.data.services.ConcertDto
import com.example.concert_app.data.services.MockData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class InicioUiState(
    val concerts: List<ConcertDto> = emptyList(),
    val isLoading: Boolean = false
)

class InicioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(InicioUiState())

    val uiState: StateFlow<InicioUiState> = _uiState.asStateFlow()

    init {
        loadMockConcerts()
    }

    private fun loadMockConcerts() {
        _uiState.value = InicioUiState(concerts = MockData.mockConcerts)
    }
}