package com.example.concert_app.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.concert_app.data.services.ConcertDto
import com.example.concert_app.ui.theme.ConcertappTheme
import com.example.concert_app.ui.theme.Detalle
import com.example.concert_app.ui.theme.Perfil
import com.example.concert_app.viewmodels.InicioViewModel

@Composable
fun InicioScreen (navController: NavController, viewModel: InicioViewModel){
   Button(onClick = { navController.navigate(Perfil) }) {
        Text("Soy la pantalla INICIO (Ir a Detalle del concierto 123)")
    }
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.value.isLoading) {
        // Mostrar un indicador de carga
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(uiState.value.concerts) { concert ->
                ConcertCard(
                    concert = concert,
                    onConcertClick = {
                        // Navegación segura
                        navController.navigate(Detalle(id = concert.id))
                    }
                )
            }
        }
    }
}

@Composable
fun ConcertCard(concert: ConcertDto, onConcertClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onConcertClick() } // Usamos el evento
    ) {
        Column {
            // ¡Aquí usas la librería Coil que instalamos!
            AsyncImage(
                model = concert.imageUrl,
                contentDescription = concert.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = concert.title, style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(8.dp))
            Text(text = concert.artistName, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(horizontal = 8.dp))
            Text(text = "${concert.city} - ${concert.timeLocal}", style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun InicioScreenPreview(){
    ConcertappTheme{
        InicioScreen(navController = NavController(LocalContext.current), viewModel = InicioViewModel())

    }
}