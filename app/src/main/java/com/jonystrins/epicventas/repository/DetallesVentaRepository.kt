package com.jonystrins.epicventas.repository

import com.jonystrins.epicventas.dao.DetalleVentaDao
import com.jonystrins.epicventas.models.DetalleVenta

class DetallesVentaRepository(
    private val dvDao: DetalleVentaDao
) {
    fun agregar(detalleVenta: DetalleVenta){
        dvDao.agregarDetalleVenta(detalleVenta)
    }

    fun totalCant(idVenta: Int): Double{
        return dvDao.obtenerSumaTotalVentas(idVenta)
    }

    fun obtenerDetallesVenta(idVenta: Int): List<DetalleVenta>{
        return dvDao.obtenerVentasByIdVenta(idVenta)
    }

    fun actualizarDtlVnt(detalleVenta: DetalleVenta){
        dvDao.actualizarDetalleVenta(detalleVenta)
    }

    fun eliminar(detalleVenta: DetalleVenta){
        dvDao.eliminarDetalleVenta(detalleVenta)
    }
}