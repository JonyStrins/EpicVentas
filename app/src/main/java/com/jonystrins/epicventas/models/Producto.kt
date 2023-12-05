package com.jonystrins.epicventas.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Producto")
data class Producto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre:String,
    val codigoBarras: String,
    val onStock: Int,
    val imagen:String?,
    val precio: Double
)
