package com.example.concert_app.Screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.concert_app.Screens.components.InfoRow
import com.example.concert_app.ui.theme.Purchase
import com.example.concert_app.ui.theme.*
import com.example.concert_app.viewmodels.DetalleViewModel

@Composable
fun DetalleScreen(id: String, navController: NavController, viewModel: DetalleViewModel) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val concert = uiState.concert

    var isFavorite by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }

    val scale by animateFloatAsState(
        targetValue = if (isFavorite) 1.2f else 1.0f,
        animationSpec = tween(durationMillis = 150),
        label = "FavoriteScaleAnimation"
    )

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

                    Text(
                        text = concert.title,
                        color = ConcertWhite,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.ExtraBold
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        Text(
                            text = "Live in Concert",
                            color = PinkAccent,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Icon(
                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (isFavorite) PinkAccent else ConcertWhite,
                            modifier = Modifier
                                .size(24.dp)
                                .graphicsLayer(scaleX = scale, scaleY = scale)
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                ) { isFavorite = !isFavorite }
                        )
                    }

                    Spacer(Modifier.height(22.dp))

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

                    InfoRow(
                        icon = Icons.Default.CalendarMonth,
                        text = concert.date.take(10)
                    )

                    Spacer(Modifier.height(20.dp))

                    InfoRow(
                        icon = Icons.Default.Place,
                        text = concert.venue
                    )

                    Spacer(Modifier.height(20.dp))

                    InfoRow(
                        icon = Icons.Default.ConfirmationNumber,
                        text = "From \$${concert.price}.00"
                    )

                    Spacer(Modifier.height(50.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .background(GradButton)
                            .clickable {
                                navController.navigate(
                                    Purchase(
                                        price = concert.price.toDouble(),
                                        date = concert.date
                                    )
                                )
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