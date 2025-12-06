package com.example.concert_app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = ElectricPurple,
    secondary = VividPink,
    background = ConcertBackground,
    surface = ConcertBackground,
    onPrimary = ConcertWhite,
    onSecondary = ConcertWhite,
    onBackground = ConcertWhite,
    onSurface = ConcertWhite
)

private val LightColorScheme = lightColorScheme(
    primary = ElectricPurple,
    secondary = VividPink,
    background = ConcertBackground,
    surface = ConcertBackground,
    onPrimary = ConcertWhite,
    onSecondary = ConcertWhite,
    onBackground = ConcertWhite,
    onSurface = ConcertWhite
)

@Composable
fun ConcertappTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors =
        if (darkTheme || isSystemInDarkTheme()) DarkColorScheme
        else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
