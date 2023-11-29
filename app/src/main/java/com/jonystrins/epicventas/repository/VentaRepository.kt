package com.jonystrins.epicventas.repository

import com.jonystrins.epicventas.dao.VentaDao
import com.jonystrins.epicventas.models.Venta

class VentaRepository(
    private val ventaDao: VentaDao
) {
    suspend fun getVentas(fecha: String): List<Venta>{
        return ventaDao.obtenerVentas(fecha)
    }

    suspend fun getVenta(id: Int): Venta{
        return ventaDao.obtenerVenta(id)
    }

    suspend fun agregarVenta(venta: Venta){
        ventaDao.agregarVenta(venta)
    }

    suspend fun actualizarVenta(venta: Venta){
        ventaDao.actualizarVenta(venta)
    }

    suspend fun eliminarVenta(venta: Venta){
        ventaDao.eliminarVenta(venta)
    }
}