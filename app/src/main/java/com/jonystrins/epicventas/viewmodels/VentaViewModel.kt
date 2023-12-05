package com.jonystrins.epicventas.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonystrins.epicventas.models.Venta
import com.jonystrins.epicventas.repository.VentaRepository
import com.jonystrins.epicventas.states.VentaState
import kotlinx.coroutines.launch

class VentaViewModel(
    private val repository: VentaRepository,
    private val fecha: String
): ViewModel() {
    var state by mutableStateOf(VentaState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(
                ventas = repository.getVentas(fecha)
            )
        }
    }

    fun obtenerVenta(id: Int): Venta{
        viewModelScope.launch {
            state = state.copy(
                venta = repository.getVenta(id)
            )
        }

        return repository.getVenta(id)
    }

    fun obtenerUltimoIdVenta(): Int{
        return repository.getUltimoId()
    }

    fun agregarVenta(venta: Venta){
        viewModelScope.launch {
            repository.agregarVenta(venta)
        }
    }

    fun actualizarVenta(venta: Venta){
        viewModelScope.launch {
            repository.actualizarVenta(venta)
        }
    }

    fun eliminarVenta(venta: Venta){
        viewModelScope.launch {
            repository.eliminarVenta(venta)
        }
    }
}