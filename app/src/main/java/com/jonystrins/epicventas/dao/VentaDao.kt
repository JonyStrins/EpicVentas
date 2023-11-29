package com.jonystrins.epicventas.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jonystrins.epicventas.models.Venta

@Dao
interface VentaDao {

    @Query("SELECT * FROM Venta WHERE fecha = :fecha")
    suspend fun obtenerVentas(fecha: String): List<Venta>

    @Query("SELECT * FROM Venta WHERE id = :id")
    suspend fun obtenerVenta(id: Int): Venta

    @Insert
    suspend fun agregarVenta(venta: Venta)

    @Update
    suspend fun actualizarVenta(venta: Venta)

    @Delete
    suspend fun eliminarVenta(venta: Venta)
}