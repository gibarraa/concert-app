package com.example.concert_app.data.services

import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Path

@Serializable
data class ConcertDto(
    val id: String,
    val title: String,
    val dateUtc: String,
    val timeLocal: String,
    val genre: String,
    val imageUrl: String,
    val priceMin: Int,
    val priceMax: Int,
    val currency: String,
    val isSoldOut: Boolean,
    val artistId: String,
    val artistName: String,
    val venueId: String,
    val city: String,
    val country: String,
    val createdAt: String, //Opcional
    val updatedAt: String,
)

interface ConcertApiService {

    // Un endpoint de ejemplo para obtener la lista de conciertos
    @GET("concerts") // Esta es la ruta en la API
    suspend fun getConcerts(): List<ConcertDto>

    @GET("concerts/{id}")
    suspend fun getConcertDetail(@Path("id") concertId: String): ConcertDto
}