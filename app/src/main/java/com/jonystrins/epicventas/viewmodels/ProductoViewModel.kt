package com.jonystrins.epicventas.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonystrins.epicventas.models.Producto
import com.jonystrins.epicventas.repository.ProductoRepository
import com.jonystrins.epicventas.states.ProductoState
import kotlinx.coroutines.launch

class ProductoViewModel(
    private val repository: ProductoRepository
): ViewModel() {
    var state by remember { mutableStateOf(ProductoState()) }
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                productos = repository.getProductos()
            )
        }
    }

    suspend fun obtenerProducto(id: Int): Producto{
        viewModelScope.launch {
            state = state.copy(
                producto = repository.getProducto(id)
            )
        }

        return repository.getProducto(id)
    }

    fun agregarProducto(producto: Producto){
        viewModelScope.launch {
            repository.agregarProducto(producto)
        }
    }

    fun actualizarProdcuto(producto: Producto){
        viewModelScope.launch {
            repository.actualizarProducto(producto)
        }
    }

    fun eliminarProducto(producto: Producto){
        viewModelScope.launch {
            repository.eliminarProducto(producto)
        }
    }
}