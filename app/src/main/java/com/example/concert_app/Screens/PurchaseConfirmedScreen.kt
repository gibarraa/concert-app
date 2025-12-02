package com.example.concert_app.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.concert_app.R
import com.example.concert_app.ui.theme.*

@Composable
fun PurchaseConfirmedScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(DarkPurple, BlackBg)))
            .padding(24.dp),
        contentAlignment = Alignment.TopCenter
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(Modifier.height(40.dp))

            // ⭐ LOGO
            androidx.compose.foundation.Image(
                painter = painterResource(id = R.drawable.icono),
                contentDescription = "logo",
                modifier = Modifier.size(90.dp)
            )

            Spacer(Modifier.height(20.dp))

            // ⭐ TITLE
            Text(
                text = "Purchase Confirmed",
                color = ConcertWhite,
                style = androidx.compose.material3.MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = "Your order has been successfully placed.",
                color = ConcertWhite.copy(alpha = 0.75f),
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
            )

            Spacer(Modifier.height(30.dp))

            // ⭐ ORDER DETAILS TITLE
            Text(
                text = "ORDER DETAILS",
                color = PinkAccent,
                fontWeight = FontWeight.Bold,
                style = androidx.compose.material3.MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(26.dp))

            // ⭐ ORDER NUMBER
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Order Number", color = ConcertWhite)
                Text("123456", color = ConcertWhite)
            }

            Spacer(Modifier.height(20.dp))

            // ⭐ DATE + TIME
            Text(
                text = "Monday Dec 19, 2022  |  7:00 PM",
                color = ConcertWhite,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(Modifier.height(20.dp))

            // ⭐ EMAIL
            Text(
                text = "sm@example.com",
                color = ConcertWhite,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(Modifier.height(60.dp))

            // ⭐ BOTÓN BACK TO HOME
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(GradButton)
                    .clickable {
                        navController.navigate(Inicio) {
                            popUpTo(Inicio) { inclusive = true }  // 🚀 Limpia el stack y regresa al inicio
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Back to Home",
                    color = ConcertWhite,
                    fontWeight = FontWeight.Bold,
                    style = androidx.compose.material3.MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
