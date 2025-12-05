package com.example.concert_app.repository

import com.example.concert_app.data.services.ConcertDto
import com.example.concert_app.data.services.RetroFitClient

class ConcertRepository {

    private val api = RetroFitClient.apiService

    suspend fun getConcerts(): List<ConcertDto> {
        return api.getConcerts()
    }

    suspend fun getConcertById(id: String): ConcertDto {
        return api.getConcertDetail(id)
    }
}