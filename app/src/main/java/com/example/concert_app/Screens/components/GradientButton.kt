package com.example.concert_app.Screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.concert_app.ui.theme.ElectricPurple
import com.example.concert_app.ui.theme.VividPink

@Composable
fun GradientButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = modifier
            .height(52.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(ElectricPurple, VividPink)
                ),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Text(text = text, color = Color.White)
    }
}
