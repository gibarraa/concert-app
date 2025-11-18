package com.example.concert_app.Screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.concert_app.ui.theme.Perfil
import com.example.concert_app.viewmodels.InicioViewModel

@Composable
fun InicioScreen (navController: NavController, viewModel: InicioViewModel){
   Button(onClick = { navController.navigate(Perfil) }) {
        Text("Soy la pantalla INICIO (Ir a Detalle del concierto 123)")
    }
    Text("Soy la pantalla INICIO (Ir a Detalle del concierto 123)")
}