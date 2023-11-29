package com.jonystrins.epicventas.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jonystrins.epicventas.models.Producto

@Dao
interface ProductoDao {

    @Query("SELECT * FROM Producto ORDER BY id DESC")
    suspend fun getProductos(): List<Producto>

    @Query("SELECT * FROM Producto WHERE id = :idProducto")
    suspend fun getProducto(idProducto: Int): Producto

    @Insert
    suspend fun agregarProducto(producto: Producto)

    @Update
    suspend fun actualizarProducto(producto: Producto)

    @Delete
    suspend fun eliminarProducto(producto: Producto)
}