package com.example.concert_app.data.services

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object RetroFitClient {
    private const val BASE_URL = "https://concert-api-g.fly.dev/"
    private const val BASE_URL = "https://concert-api-80uo.onrender.com/api/"

    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            json.asConverterFactory("application/json".toMediaType())
        )
        .build()

    val apiService: ConcertApiService by lazy {
        retrofit.create(ConcertApiService::class.java)
    }
}