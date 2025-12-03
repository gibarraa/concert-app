package com.example.concert_app.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class UserProfile(
    val name: String,
    val email: String,
    val profileImageUrl: String
)

data class PerfilUiState(
    val user: UserProfile? = null
)

class PerfilViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(PerfilUiState())
    val uiState: StateFlow<PerfilUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = PerfilUiState(
            user = UserProfile(
                name = "Ibarra",
                email = "ibarra@ticketMaster.com",
                profileImageUrl = "https://picsum.photos/seed/user/300/300"
            )
        )
    }
}