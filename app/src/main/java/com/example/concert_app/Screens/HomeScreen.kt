package com.example.concert_app.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.concert_app.R
import com.example.concert_app.Screens.components.FeaturedEventCard
import com.example.concert_app.Screens.components.UpcomingEventRow
import com.example.concert_app.ui.theme.BlackBg
import com.example.concert_app.ui.theme.ConcertWhite
import com.example.concert_app.ui.theme.DarkPurple
import com.example.concert_app.ui.theme.Detalle
import com.example.concert_app.ui.theme.PinkAccent
import com.example.concert_app.viewmodels.InicioViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: InicioViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val featured = uiState.concerts.take(4)
    val upcoming = uiState.concerts.drop(4)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(DarkPurple, BlackBg)))
    ) {
        if (uiState.isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = PinkAccent)
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.icono),
                            contentDescription = null,
                            modifier = Modifier
                                .size(45.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "ConcertApp",
                            style = MaterialTheme.typography.headlineMedium,
                            color = ConcertWhite,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                item {
                    Text(
                        text = "Eventos Destacados",
                        color = ConcertWhite,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(featured) { event ->
                            FeaturedEventCard(event = event) {
                                navController.navigate(Detalle(id = event.id))
                            }
                        }
                    }
                }

                item {
                    Text(
                        text = "Próximos Conciertos",
                        color = ConcertWhite,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }

                items(upcoming) { event ->
                    UpcomingEventRow(event = event) {
                        navController.navigate(Detalle(id = event.id))
                    }
                }
            }
        }
    }
}