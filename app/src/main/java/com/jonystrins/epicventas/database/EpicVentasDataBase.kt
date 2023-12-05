package com.jonystrins.epicventas.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jonystrins.epicventas.dao.DetalleVentaDao
import com.jonystrins.epicventas.dao.ProductoDao
import com.jonystrins.epicventas.dao.VentaDao
import com.jonystrins.epicventas.models.DetalleVenta
import com.jonystrins.epicventas.models.Producto
import com.jonystrins.epicventas.models.Venta

@Database(entities = [Producto::class, Venta::class, DetalleVenta::class], version = 2)
abstract class EpicVentasDataBase(): RoomDatabase() {
    abstract val productoDao: ProductoDao
    abstract val ventaDao: VentaDao
    abstract val dvDao: DetalleVentaDao
}