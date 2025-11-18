package com.example.concert_app.Screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.concert_app.ui.theme.Favoritos
import com.example.concert_app.viewmodels.PerfilViewModel

@Composable
fun PerfilScreen(navController: NavController, viewModel: PerfilViewModel){
    Button(
        onClick = { navController.navigate(Favoritos) }
    ) {
        Text("Soy la pantalla PERFIL (Ir a Favoritos)")
    }
}