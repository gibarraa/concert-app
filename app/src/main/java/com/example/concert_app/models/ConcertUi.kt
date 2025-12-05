package com.example.concert_app.models

import com.example.concert_app.data.services.ConcertDto

data class ConcertUi(
    val id: String,
    val title: String,
    val artist: String = "",
    val date: String,
    val imageUrl: String,
    val venue: String,
    val price: Int
)

fun ConcertDto.toUi(): ConcertUi {
    return ConcertUi(
        id = id,
        title = title,
        artist = artist,
        date = date ?: "00:00",
        imageUrl = imageUrl,
        venue = venue,
        price = price
    )
}
