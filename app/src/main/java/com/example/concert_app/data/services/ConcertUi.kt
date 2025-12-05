package com.example.concert_app.data.services

data class ConcertUi(
    val id: String,
    val title: String,
    val date: String,
    val imageUrl: String,
    val city: String,
    val priceMin: Int
)

fun ConcertDto.toUi(): ConcertUi {
    return ConcertUi(
        id = id,
        title = title,
        date = timeLocal ?: "00:00",
        imageUrl = imageUrl,
        city = city,
        priceMin = priceMin
    )
}
