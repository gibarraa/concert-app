package com.example.concert_app.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.concert_app.ui.theme.Favoritos
import com.example.concert_app.viewmodels.DetalleViewModel

@Composable
fun DetalleScreen(id: String, navController: NavController, viewModel: DetalleViewModel){
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val concert = uiState.concert

    if (uiState.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else if (concert != null) {
        // Usamos los datos del concierto para diseñar la pantalla
        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = concert.imageUrl,
                contentDescription = concert.title,
                modifier = Modifier.fillMaxWidth().height(250.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(concert.title, style = MaterialTheme.typography.headlineMedium)
            Text(concert.artistName, style = MaterialTheme.typography.titleMedium)
            Text("Cuándo: ${concert.timeLocal} - ${concert.dateUtc}") // (Formatear esto mejor)
            Text("Lugar: ${concert.city}, ${concert.country}")
            Text("Precios: ${concert.priceMin} - ${concert.priceMax} ${concert.currency}")
        }
    } else {
        Text("Error: Concierto no encontrado")
    }

    Button(
        onClick = { navController.navigate(Favoritos) }
    ) {
        Text("Soy la pantalla PERFIL (Ir a Favoritos)")
    }
}
