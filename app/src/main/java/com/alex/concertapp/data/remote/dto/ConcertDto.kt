package com.alex.concertapp.data.remote.dto

import com.squareup.moshi.Json
import com.alex.concertapp.domain.model.Concert

data class ConcertDto(
    @Json(name = "_id") val id: String,
    @Json(name = "title") val title: String,
    @Json(name = "artist") val artist: String,
    @Json(name = "date") val date: String,
    @Json(name = "venue") val venue: String,
    @Json(name = "price") val price: Double,
    @Json(name = "image") val image: String,
    @Json(name = "description") val description: String,
    @Json(name = "createdAt") val createdAt: String,
    @Json(name = "updatedAt") val updatedAt: String
)


fun ConcertDto.toDomain() = Concert(
    id = id,
    title = title,
    artist = artist,

    date = date,
    venue = venue,
    priceFrom = "$$price",
    imageUrl = image,
    isFavorite = false
)
