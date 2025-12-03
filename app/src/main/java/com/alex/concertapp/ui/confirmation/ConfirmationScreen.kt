package com.alex.concertapp.ui.confirmation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConfirmationScreen(
    onBackHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Purchase Confirmed")
        Spacer(Modifier.height(8.dp))
        Text("Your order has been successfully placed.")
        Spacer(Modifier.height(32.dp))
        Button(onClick = onBackHome) {
            Text("Back to Home")
        }
    }
}
