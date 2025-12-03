package com.alex.concertapp.ui.checkout

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CheckoutScreen(
    onPurchaseDone: () -> Unit
) {
    var tickets by remember { mutableIntStateOf(2) }
    val pricePer = 50
    val total = tickets * pricePer

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Purchase Tickets", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(24.dp))

        Text("Number of Tickets", style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { if (tickets > 1) tickets-- }) { Text("−") }
            Text(
                tickets.toString(),
                modifier = Modifier.padding(horizontal = 32.dp),
                style = MaterialTheme.typography.titleLarge
            )
            Button(onClick = { tickets++ }) { Text("+") }
        }

        Spacer(Modifier.height(24.dp))
        Text("Total Price", style = MaterialTheme.typography.bodyMedium)
        Text("$${total}", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))
        Button(onClick = onPurchaseDone, modifier = Modifier.fillMaxWidth()) {
            Text("Pay $${total}")
        }
    }
}
