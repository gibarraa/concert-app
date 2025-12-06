package com.example.concert_app.ui.theme

import kotlinx.serialization.Serializable

@Serializable
object Inicio

@Serializable
data class Detalle(val id: String)

@Serializable
object Favoritos

@Serializable
object Perfil

@Serializable
data class Purchase(val price: Double, val date: String)

@Serializable
data class PurchaseConfirmed(val date: String)
