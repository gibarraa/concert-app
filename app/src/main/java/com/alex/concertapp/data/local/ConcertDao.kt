package com.alex.concertapp.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ConcertDao {
    @Query("SELECT * FROM concerts")
    fun observeAll(): Flow<List<ConcertEntity>>

    @Query("SELECT * FROM concerts WHERE id=:id")
    suspend fun getById(id: String): ConcertEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<ConcertEntity>)

    @Query("UPDATE concerts SET isFavorite = NOT isFavorite WHERE id=:id")
    suspend fun toggleFavorite(id: String)

    @Query("SELECT * FROM concerts WHERE isFavorite = 1")
    fun observeFavorites(): Flow<List<ConcertEntity>>
}
