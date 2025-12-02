package com.example.concert_app.data.services

data class Concert(
    val artistId: String,
    val artistName: String,
    val city: String,
    val country: String,
    val createdAt: String,
    val currency: String,
    val dateUtc: String,
    val genre: String,
    val id: String,
    val imageUrl: String,
    val isSoldOut: Boolean,
    val priceMax: Int,
    val priceMin: Int,
    val timeLocal: String,
    val title: String,
    val updatedAt: String,
    val venueId: String
)