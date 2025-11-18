package com.example.concert_app.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.concert_app.ui.theme.Detalle
import com.example.concert_app.ui.theme.Perfil
import com.example.concert_app.viewmodels.FavoritosViewModel

@Composable
fun FavoritosScreen(navController: NavController, viewModel: FavoritosViewModel){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.favoriteConcerts.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Aún no tienes favoritos")
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(uiState.favoriteConcerts) { concert ->
                ConcertCard(
                    concert = concert,
                    onConcertClick = {
                        navController.navigate(Detalle(id = concert.id))
                    }
                )
            }
        }
    }

    Button(
        onClick = { navController.navigate(Perfil) }
    ) {
        Text("Soy la pantalla PERFIL (Ir a Favoritos)")
    }


}