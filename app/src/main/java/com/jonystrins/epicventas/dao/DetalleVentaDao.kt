package com.jonystrins.epicventas.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jonystrins.epicventas.models.DetalleVenta

@Dao
interface DetalleVentaDao {

    @Query("SELECT * FROM DetalleVenta WHERE idVenta = :idVenta")
    fun obtenerVentasByIdVenta(idVenta: Int): List<DetalleVenta>

    @Query("SELECT SUM(totalcant) FROM DetalleVenta WHERE idventa = :idVenta")
    fun obtenerSumaTotalVentas(idVenta: Int): Double

    @Insert
    fun agregarDetalleVenta(detalle: DetalleVenta)

    @Update
    fun actualizarDetalleVenta(detalle: DetalleVenta)

    @Delete
    fun eliminarDetalleVenta(detalle: DetalleVenta)
}