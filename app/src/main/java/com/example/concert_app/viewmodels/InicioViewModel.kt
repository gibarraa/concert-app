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

class InicioViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(InicioUiState())

    val uiState: StateFlow<InicioUiState> = _uiState.asStateFlow()

    init {
        loadMockConcerts()
    }

    private fun loadMockConcerts() {
        _uiState.value = InicioUiState(concerts = MockData.mockConcerts)
import androidx.lifecycle.viewModelScope
import com.example.concert_app.models.ConcertUi
import com.example.concert_app.models.toUi
import com.example.concert_app.repository.ConcertRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class InicioUiState(
    val concerts: List<ConcertUi> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class InicioViewModel : ViewModel() {

    private val repository = ConcertRepository()

    private val _uiState = MutableStateFlow(InicioUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadConcerts()
    }

    fun loadConcerts() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                val resultDto = repository.getConcerts()

                val resultUi = resultDto.map { it.toUi() }

                _uiState.update {
                    it.copy(concerts = resultUi, isLoading = false)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.update {
                    it.copy(isLoading = false, error = "Error: ${e.message}")
                }
            }
        }
    }
}