package com.jonystrins.epicventas.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jonystrins.epicventas.models.Venta

@Dao
interface VentaDao {

    @Query("SELECT * FROM Venta WHERE fecha = :fecha ORDER BY id DESC")
    fun obtenerVentas(fecha: String): List<Venta>

    @Query("SELECT * FROM Venta WHERE id = :id")
    fun obtenerVenta(id: Int): Venta

    @Query("SELECT MAX(id) FROM Venta")
    fun getUltimoIdNota(): Int

    @Insert
    fun agregarVenta(venta: Venta)

    @Update
    fun actualizarVenta(venta: Venta)

    @Delete
    fun eliminarVenta(venta: Venta)
}