package com.example.concert_app.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.concert_app.ui.theme.Detalle
import com.example.concert_app.data.services.ConcertDto
import com.example.concert_app.data.services.MockData
import com.example.concert_app.repository.ConcertRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class DetalleUiState(
    val concert: ConcertDto? = null,
    val isLoading: Boolean = true
)

class DetalleViewModel(savedStateHandle: SavedStateHandle ) : ViewModel() {

    private val repository = ConcertRepository()

    private val _uiState = MutableStateFlow(DetalleUiState())
    val uiState: StateFlow<DetalleUiState> = _uiState.asStateFlow()

    init {
        val route = savedStateHandle.toRoute<Detalle>()
        val id = route.id

        loadConcertDetail(id)
    }

    private fun loadConcertDetail(id: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            try {
                val concertDto = repository.getConcertById(id)

                _uiState.update {
                    it.copy(concert = concertDto, isLoading = false)
                }

            } catch (e: Exception) {
                val fallback = MockData.mockConcerts.find { it.id == id }

                _uiState.update {
                    it.copy(concert = fallback, isLoading = false)
                }
            }
        }
    }
}