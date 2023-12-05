package com.jonystrins.epicventas.repository

import com.jonystrins.epicventas.dao.VentaDao
import com.jonystrins.epicventas.models.Venta

class VentaRepository(
    private val ventaDao: VentaDao
) {
    fun getVentas(fecha: String): List<Venta>{
        return ventaDao.obtenerVentas(fecha)
    }

    fun getVenta(id: Int): Venta{
        return ventaDao.obtenerVenta(id)
    }

    fun getUltimoId(): Int{
        return ventaDao.getUltimoIdNota()
    }

    fun agregarVenta(venta: Venta){
        ventaDao.agregarVenta(venta)
    }

    fun actualizarVenta(venta: Venta){
        ventaDao.actualizarVenta(venta)
    }

    fun eliminarVenta(venta: Venta){
        ventaDao.eliminarVenta(venta)
    }
}