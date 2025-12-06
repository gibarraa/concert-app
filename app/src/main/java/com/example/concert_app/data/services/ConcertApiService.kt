package com.example.concert_app.data.services

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Path

@Serializable
data class ConcertDto(
    @SerialName("_id") val id: String,
    val title: String,
    val artist: String,
    val date: String,
    val venue: String,
    val price: Int,
    @SerialName("image") val imageUrl: String,
    val description: String
)

interface ConcertApiService {
    @GET("concerts")
    suspend fun getConcerts(): List<ConcertDto>

    @GET("concerts/{id}")
    suspend fun getConcertDetail(@Path("id") concertId: String): ConcertDto
}