package com.alex.concertapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alex.concertapp.domain.model.Concert

@Entity(tableName = "concerts")
data class ConcertEntity(
    @PrimaryKey val id: String,
    val title: String,
    val artist: String,
    val date: String,
    val venue: String,
    val priceFrom: String,
    val imageUrl: String,
    val isFavorite: Boolean
)

fun ConcertEntity.toDomain() = Concert(id, title, artist, date, venue, priceFrom, imageUrl, isFavorite)
fun Concert.toEntity() = ConcertEntity(id, title, artist, date, venue, priceFrom, imageUrl, isFavorite)
