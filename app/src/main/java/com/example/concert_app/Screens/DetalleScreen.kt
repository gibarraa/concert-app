package com.example.concert_app.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.concert_app.ui.theme.*
import com.example.concert_app.viewmodels.DetalleViewModel
import com.example.concert_app.ui.theme.Purchase   // ⭐ IMPORTANTE: ruta del destino

@Composable
fun DetalleScreen(id: String, navController: NavController, viewModel: DetalleViewModel) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val concert = uiState.concert

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(DarkPurple, BlackBg)))
            .padding(20.dp)
    ) {

        when {
            uiState.isLoading -> {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = PinkAccent)
                }
            }

            concert != null -> {
                Column(modifier = Modifier.fillMaxSize()) {

                    // ⭐ TITULO PRINCIPAL
                    Text(
                        text = concert.title,
                        color = ConcertWhite,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = "Live in Concert",
                        color = PinkAccent,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(22.dp))

                    // ⭐ IMAGEN
                    AsyncImage(
                        model = concert.imageUrl,
                        contentDescription = concert.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(240.dp)
                            .clip(RoundedCornerShape(26.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(Modifier.height(30.dp))

                    // 📅 FECHA
                    InfoRow(
                        icon = Icons.Default.CalendarMonth,
                        text = "${concert.dateUtc.take(10)}  ${concert.timeLocal}"
                    )

                    Spacer(Modifier.height(20.dp))

                    // 📍 LUGAR
                    InfoRow(
                        icon = Icons.Default.Place,
                        text = "${concert.city}, ${concert.country}"
                    )

                    Spacer(Modifier.height(20.dp))

                    // 🎟️ PRECIO
                    InfoRow(
                        icon = Icons.Default.ConfirmationNumber,
                        text = "From \$${concert.priceMin}.00"
                    )

                    Spacer(Modifier.height(50.dp))

                    // ⭐ BOTON BUY TICKETS — YA CON NAVEGACION REAL
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(GradButton)
                            .clickable {
                                navController.navigate(Purchase)
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Buy Tickets",
                            color = ConcertWhite,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            else -> Text("Error: Concierto no encontrado", color = ConcertWhite)
        }
    }
}

@Composable
fun InfoRow(icon: ImageVector, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = ConcertWhite.copy(alpha = 0.65f),
            modifier = Modifier.size(26.dp)
        )
        Spacer(Modifier.width(12.dp))
        Text(text, color = ConcertWhite, style = MaterialTheme.typography.titleMedium)
    }
}
