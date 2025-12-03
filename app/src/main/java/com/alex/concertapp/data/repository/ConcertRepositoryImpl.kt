package com.alex.concertapp.data.repository

import com.alex.concertapp.data.local.ConcertDao
import com.alex.concertapp.data.local.toDomain
import com.alex.concertapp.data.local.toEntity
import com.alex.concertapp.data.remote.ConcertApi
import com.alex.concertapp.data.remote.dto.toDomain
import com.alex.concertapp.domain.model.Concert
import com.alex.concertapp.domain.repository.ConcertRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConcertRepositoryImpl @Inject constructor(
    private val api: ConcertApi,
    private val dao: ConcertDao
) : ConcertRepository {

    override suspend fun fetchConcerts(): Result<List<Concert>> {
        return try {
            val remote = api.getConcerts().map { it.toDomain() }
            dao.upsertAll(remote.map { it.toEntity() })
            Result.success(remote)
        } catch (e: Exception) {

            val cached = try {
                dao.observeAll().first().map { it.toDomain() }
            } catch (_: Exception) {
                emptyList()
            }

            if (cached.isNotEmpty()) {
                Result.success(cached)
            } else {

                val fallback = listOf(
                    Concert(
                        id = "691c08b337bd182d7137220b",
                        title = "Bad Bunny - Debí Tirar Más Fotos",
                        artist = "Bad Bunny",
                        date = "2025-12-01 20:00",
                        venue = "Estadio GNP Seguros, CDMX",
                        priceFrom = "$2500",
                        imageUrl = "https://media.pitchfork.com/photos/6818ff4be530f20d9cbd834e/4:3/w_8279,h_6209,c_limit/Bad-Bunny.jpeg",
                        isFavorite = false
                    ),
                    Concert(
                        id = "691c091637bd182d7137220e",
                        title = "Dua Lipa - Radical Optimism World Tour",
                        artist = "Dua Lipa",
                        date = "2025-08-20 21:00",
                        venue = "Arena Monterrey, Nuevo León",
                        priceFrom = "$1800",
                        imageUrl = "https://www.billboard.com/wp-content/uploads/2025/07/Dua-Lipa-Radical-Optimism-dublin-june-2025-billboard-1548.jpg?w=942&h=628&crop=1",
                        isFavorite = false
                    ),
                    Concert(
                        id = "691c09cd37bd182d7137221b",
                        title = "Feid - Nitro Jam 2025",
                        artist = "Feid",
                        date = "2025-10-10 20:30",
                        venue = "Foro Sol, CDMX",
                        priceFrom = "$3000",
                        imageUrl = "https://www.kaseyacenter.com/assets/img/596_feid-2023-ff8f12974c.jpg",
                        isFavorite = false
                    )
                )

                dao.upsertAll(fallback.map { it.toEntity() })
                Result.success(fallback)
            }
        }
    }

    override suspend fun fetchConcert(id: String): Result<Concert> {
        return try {
            val fromApi = api.getConcert(id).toDomain()
            Result.success(fromApi)
        } catch (e: Exception) {
            val local = dao.getById(id)?.toDomain()
            if (local != null) Result.success(local)
            else Result.failure(e)
        }
    }


    override suspend fun fetchFavorites(): Result<List<Concert>> {
        return try {
            val remote = api.getFavorites().map { it.toDomain() }
            Result.success(remote)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun toggleFavorite(id: String): Result<Unit> {
        return runCatching { dao.toggleFavorite(id) }
    }

    override fun observeFavorites(): Flow<List<Concert>> {
        return dao.observeFavorites().map { list ->
            list.map { it.toDomain() }
        }
    }
}
