package com.alex.concertapp.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.alex.concertapp.R
import com.alex.concertapp.domain.model.Concert
import com.alex.concertapp.ui.common.ErrorView
import com.alex.concertapp.ui.common.UiState

@Composable
fun HomeScreen(
    onConcertClick: (String) -> Unit,
    vm: HomeViewModel = hiltViewModel()
) {
    val state by vm.state.collectAsStateWithLifecycle()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF050012)
    ) {
        when (state) {
            UiState.Loading -> Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color.Magenta)
            }

            is UiState.Error -> ErrorView(
                message = (state as UiState.Error).message,
                onRetry = { vm.refresh() }
            )

            is UiState.Success -> {
                val data = (state as UiState.Success<List<Concert>>).data
                if (data.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No hay conciertos disponibles 🥲",
                            color = Color.White
                        )
                    }
                } else {
                    HomeContent(
                        concerts = data,
                        onConcertClick = onConcertClick
                    )
                }
            }
        }
    }
}

@Composable
private fun HomeContent(
    concerts: List<Concert>,
    onConcertClick: (String) -> Unit
) {
    val featured = concerts.take(3)
    val upcoming = concerts.drop(3)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        item {
            TopBar()
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Eventos Destacados",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(Modifier.height(12.dp))
            FeaturedRow(
                concerts = featured,
                onConcertClick = onConcertClick
            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Próximos Conciertos",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(Modifier.height(12.dp))
        }

        items(upcoming) { concert ->
            UpcomingConcertCard(
                concert = concert,
                onClick = { onConcertClick(concert.id) }
            )
            Spacer(Modifier.height(12.dp))
        }
    }
}

@Composable
private fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(MaterialTheme.shapes.large)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_concert_ticket),
                contentDescription = "ConcertApp logo",
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(Modifier.width(12.dp))

        Text(
            text = "ConcertApp",
            style = MaterialTheme.typography.titleLarge.copy(
                color = Color(0xFFFF4EDD),
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
private fun FeaturedRow(
    concerts: List<Concert>,
    onConcertClick: (String) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(concerts) { concert ->
            FeaturedCard(
                concert = concert,
                onClick = { onConcertClick(concert.id) }
            )
        }
    }
}

@Composable
private fun FeaturedCard(
    concert: Concert,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(260.dp)
            .height(180.dp)
            .clip(MaterialTheme.shapes.large)
            .clickable(onClick = onClick)
    ) {
        AsyncImage(
            model = concert.imageUrl,
            contentDescription = concert.title,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(0xAA000000)
                        )
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp)
        ) {
            Text(
                text = concert.title,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun UpcomingConcertCard(
    concert: Concert,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.large)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF181421)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            AsyncImage(
                model = concert.imageUrl,
                contentDescription = concert.title,
                modifier = Modifier
                    .size(72.dp)
                    .clip(MaterialTheme.shapes.medium)
            )

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = concert.title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(Modifier.height(4.dp))

                Text(
                    text = concert.artist,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color(0xFFB3B3B3)
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = concert.venue,
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = Color(0xFF7F7F88)
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
