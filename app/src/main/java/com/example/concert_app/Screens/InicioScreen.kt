package com.example.concert_app.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.concert_app.ui.theme.*
import com.example.concert_app.viewmodels.InicioViewModel
import com.example.concert_app.R
import com.example.concert_app.models.ConcertUi

@Composable
fun InicioScreen(navController: NavController, viewModel: InicioViewModel) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val featured = uiState.value.concerts.take(4)
    val upcoming = uiState.value.concerts.filter { it !in featured }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(DarkPurple, BlackBg)))
            .padding(16.dp)
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {

            AsyncImage(
                model = R.drawable.icono,
                contentDescription = "ConcertApp Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(42.dp)
                    .clip(MaterialTheme.shapes.small)
            )

            Spacer(Modifier.width(10.dp))

            Text(
                "ConcertApp",
                color = PinkAccent,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(24.dp))

        Text(
            "Eventos Destacados",
            color = Color.White,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(12.dp))

        if (uiState.value.isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = PinkAccent)
            }
        } else {

            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                items(featured) { concert ->
                    FeaturedCard(concert) {
                        navController.navigate(Detalle(id = concert.id))
                    }
                }
            }

            Spacer(Modifier.height(28.dp))

            Text(
                "Próximos Conciertos",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(12.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                items(upcoming) { concert ->
                    UpcomingCard(concert) {
                        navController.navigate(Detalle(id = concert.id))
                    }
                }
            }
        }
    }
}

@Composable
fun FeaturedCard(concert: ConcertUi, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(220.dp)
            .height(140.dp)
            .clickable { onClick() },
    ) {
        Box {
            AsyncImage(
                model = concert.imageUrl,
                contentDescription = concert.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color(0xAA000000))
                        )
                    )
            )
            Text(
                concert.title,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(10.dp)
            )
        }
    }
}

@Composable
fun UpcomingCard(concert: ConcertUi, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(Color(0xFF1A1A1A))
            .clickable { onClick() }
            .padding(10.dp)
    ) {
        AsyncImage(
            model = concert.imageUrl,
            contentDescription = concert.title,
            modifier = Modifier
                .width(100.dp)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(12.dp))

        Column {
            Text(concert.title, color = Color.White, fontWeight = FontWeight.SemiBold)
            Text(concert.artist, color = Color.Gray)
            Text("${concert.venue} • ${concert.date}", color = Color.Gray)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun InicioPreview() {
    ConcertappTheme {
        InicioScreen(
            navController = NavController(LocalContext.current),
            viewModel = InicioViewModel()
        )
    }
}
