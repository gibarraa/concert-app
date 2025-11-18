package com.example.concert_app.Screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.concert_app.ui.theme.Favoritos
import com.example.concert_app.ui.theme.Inicio
import com.example.concert_app.viewmodels.FavoritosViewModel

@Composable
fun FavoritosScreen(navController: NavController, viewModel: FavoritosViewModel){
    Button(
    onClick = { navController.navigate(Inicio) }
    ) {
        Text("Soy la pantalla FAVORITOS (Ir a Inicio)")
    }
}