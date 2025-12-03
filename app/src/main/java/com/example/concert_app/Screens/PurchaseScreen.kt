package com.example.concert_app.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.concert_app.R
import com.example.concert_app.ui.theme.*
import com.example.concert_app.ui.theme.PurchaseConfirmed

@Composable
fun PurchaseScreen(navController: NavController, price: Double, date: String) {

    var selectedSection by remember { mutableStateOf("General Admission") }
    var ticketCount by remember { mutableStateOf(2) }
    val totalPrice = ticketCount * price

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(DarkPurple, BlackBg)))
            .padding(20.dp)
    ) {

        Column {

            Row(verticalAlignment = Alignment.CenterVertically) {

                androidx.compose.foundation.Image(
                    painter = painterResource(id = R.drawable.icono),
                    contentDescription = "logo",
                    modifier = Modifier.size(40.dp)
                )

                Spacer(Modifier.width(10.dp))

                Text(
                    "ConcertApp",
                    color = PinkAccent,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.height(30.dp))

            Text(
                text = "Purchase Tickets",
                color = ConcertWhite,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(Modifier.height(40.dp))

            Text(
                "Section",
                color = ConcertWhite,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color(0xFF2A1435))
                    .padding(horizontal = 18.dp)
                    .clickable { /* */ },
                contentAlignment = Alignment.CenterStart
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        selectedSection,
                        color = ConcertWhite,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = ConcertWhite
                    )
                }
            }

            Spacer(Modifier.height(40.dp))

            Text(
                "Number of Tickets",
                color = ConcertWhite,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                // MINUS
                Box(
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(GradPink)
                        .clickable {
                            if (ticketCount > 1) ticketCount--
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "-",
                        color = ConcertWhite,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = MaterialTheme.typography.headlineMedium.fontSize
                    )
                }

                Spacer(Modifier.width(20.dp))


                Box(
                    modifier = Modifier
                        .height(55.dp)
                        .weight(1f)
                        .clip(RoundedCornerShape(18.dp))
                        .background(Color(0xFF2A1435)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "$ticketCount",
                        color = ConcertWhite,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(Modifier.width(20.dp))

                Box(
                    modifier = Modifier
                        .size(55.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(GradPink)
                        .clickable { ticketCount++ },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "+",
                        color = ConcertWhite,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = MaterialTheme.typography.headlineMedium.fontSize
                    )
                }
            }

            Spacer(Modifier.height(40.dp))

            // TOTAL PRICE
            Text(
                "Total Price",
                color = ConcertWhite,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(6.dp))

            Text(
                "$${String.format("%.2f", totalPrice)}",
                color = ConcertWhite,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.ExtraBold
            )

            Spacer(Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(GradButton)
                    .clickable {
                        navController.navigate(PurchaseConfirmed(date = date))
                    },
                contentAlignment = Alignment.Center
            ) {

                Text(
                    "Pay $${String.format("%.2f", totalPrice)}",
                    color = ConcertWhite,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
