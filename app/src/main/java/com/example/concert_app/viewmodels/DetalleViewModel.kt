package com.example.concert_app.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.concert_app.data.services.ConcertDto
import com.example.concert_app.data.services.MockData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class DetalleUiState(
    val concert: ConcertDto? = null,
    val isLoading: Boolean = true
)
//Usamos SavedStateHandle para obtener el id del concierto
class DetalleViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _uiState = MutableStateFlow(DetalleUiState())
    val uiState: StateFlow<DetalleUiState> = _uiState.asStateFlow()

    init {

        val args = DetalleArgs(savedStateHandle)
        val concertId = args.id

        val concert = MockData.mockConcerts.find { it.id == concertId }

        _uiState.value = DetalleUiState(concert = concert, isLoading = false)
    }
}

private data class DetalleArgs(val id: String) {
    constructor(savedStateHandle: SavedStateHandle) : this(
        id = checkNotNull(savedStateHandle["id"]) // "id" debe coincidir con el nombre en @Serializable data class Detalle(val id: String)
    )
}