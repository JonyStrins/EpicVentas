package com.jonystrins.epicventas.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Venta",
//    foreignKeys = arrayOf(ForeignKey(entity = Producto::class,
//        parentColumns = arrayOf("id"),
//        childColumns = arrayOf("idProducto"),
//        onDelete = ForeignKey.CASCADE,
//        onUpdate = ForeignKey.CASCADE
//    ))
    )
data class Venta(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val fecha: String,
    val hora: String,
    val total: Double
)
