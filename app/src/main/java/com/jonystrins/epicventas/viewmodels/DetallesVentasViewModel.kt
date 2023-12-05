package com.jonystrins.epicventas.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonystrins.epicventas.models.DetalleVenta
import com.jonystrins.epicventas.repository.DetallesVentaRepository
import com.jonystrins.epicventas.states.DetalleVentaState
import com.jonystrins.epicventas.states.TotalState
import kotlinx.coroutines.launch

class DetallesVentasViewModel(
    private val repository: DetallesVentaRepository,
    idVenta: Int
): ViewModel() {

    var state by mutableStateOf(DetalleVentaState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                detalles = repository.obtenerDetallesVenta(idVenta)
            )
        }
    }

    fun totalSum(idVenta: Int): Double{
        return repository.totalCant(idVenta)
    }

    fun obtenerDetallesVenta(idVenta: Int): List<DetalleVenta>{
        return repository.obtenerDetallesVenta(idVenta)
    }

    fun agregarCarrito(detalleVenta: DetalleVenta){
        viewModelScope.launch {
            repository.agregar(detalleVenta)
        }
    }

    fun actualizar(detalleVenta: DetalleVenta){
        viewModelScope.launch {
            repository.actualizarDtlVnt(detalleVenta)
        }
    }

    fun eliminarCarrito(detalleVenta: DetalleVenta){
        viewModelScope.launch {
            repository.eliminar(detalleVenta)
        }
    }
}