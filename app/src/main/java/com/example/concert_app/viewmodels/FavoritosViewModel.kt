package com.example.concert_app.viewmodels

import androidx.lifecycle.ViewModel
import com.example.concert_app.data.services.ConcertDto
import com.example.concert_app.data.services.MockData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class FavoritosUIState(
    val favoriteConcerts: List<ConcertDto> = emptyList()
)

class FavoritosViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(FavoritosUIState())
    val uiState: StateFlow<FavoritosUIState> = _uiState.asStateFlow()

    init {
        _uiState.value = FavoritosUIState(
            favoriteConcerts = listOf(MockData.mockConcerts.first())
        )
    }
}