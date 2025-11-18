package com.example.concert_app.data.services

import com.example.concert_app.data.services.ConcertDto

object MockData {
    val mockConcerts = listOf(
        ConcertDto(
            id = "c1",
            title = "Indie Nights",
            dateUtc = "2025-11-15T02:00:00Z",
            timeLocal = "21:00",
            genre = "indie rock",
            imageUrl = "https://picsum.photos/seed/c1/900/600",
            priceMin = 30,
            priceMax = 75,
            currency = "USD",
            isSoldOut = false,
            artistId = "a1",
            artistName = "The Satellites",
            venueId = "v1",
            city = "cdmx",
            country = "mx",
            createdAt = "",
            updatedAt = ""
        ),
        ConcertDto(
            id = "c2",
            title = "Luna Live",
            dateUtc = "2025-12-05T02:00:00Z",
            timeLocal = "20:30",
            genre = "pop",
            imageUrl = "https://picsum.photos/seed/c2/900/600",
            priceMin = 45,
            priceMax = 120,
            currency = "USD",
            isSoldOut = false,
            artistId = "a2",
            artistName = "Luna Beat",
            venueId = "v2",
            city = "monterrey",
            country = "mx",
            createdAt = "",
            updatedAt = ""
        )
    )
}