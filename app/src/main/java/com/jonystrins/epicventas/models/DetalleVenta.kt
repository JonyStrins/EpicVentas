package com.jonystrins.epicventas.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DetalleVenta")
data class DetalleVenta(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val idVenta: Int,
    val idProducto: Int,
    val cant: Int,
    val totalCant: Double
)
