package com.example.concert_app.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.concert_app.R
import com.example.concert_app.data.services.MockData
import com.example.concert_app.data.services.ConcertUi
import com.example.concert_app.models.ConcertUi
import com.example.concert_app.ui.theme.ConcertBackground
import com.example.concert_app.ui.theme.ConcertWhite
import com.example.concert_app.Screens.components.FeaturedEventCard
import com.example.concert_app.Screens.components.UpcomingEventRow

@Composable
fun HomeScreen(
    onEventClick: (ConcertUi) -> Unit
) {

    val concerts = MockData.mockConcertsUi

    Column(
        modifier = Modifier
            .background(ConcertBackground)
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // LOGO + TÍTULO
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.logo), // Tu logo en drawable
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(45.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "ConcertApp",
                style = MaterialTheme.typography.titleLarge,
                color = ConcertWhite
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // SECTION: Featured
        Text(
            text = "Eventos Destacados",
            color = ConcertWhite,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(concerts) { event ->
                FeaturedEventCard(event = event) {
                    onEventClick(event)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // SECTION: Upcoming
        Text(
            text = "Próximos Conciertos",
            color = ConcertWhite,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(concerts) { event ->
                UpcomingEventRow(event) {
                    onEventClick(event)
                }
            }
        }
    }
}
