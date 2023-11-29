package com.jonystrins.epicventas.repository

import com.jonystrins.epicventas.dao.ProductoDao
import com.jonystrins.epicventas.models.Producto

class ProductoRepository(
    private val productoDao: ProductoDao
) {

    suspend fun getProductos(): List<Producto>{
        return productoDao.getProductos()
    }

    suspend fun getProducto(id: Int): Producto{
        return productoDao.getProducto(id)
    }

    suspend fun agregarProducto(producto: Producto){
        productoDao.agregarProducto(producto)
    }

    suspend fun actualizarProducto(producto: Producto){
        productoDao.actualizarProducto(producto)
    }

    suspend fun eliminarProducto(producto: Producto){
        productoDao.eliminarProducto(producto)
    }
}