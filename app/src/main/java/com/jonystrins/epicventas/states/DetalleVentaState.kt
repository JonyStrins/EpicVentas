package com.jonystrins.epicventas.states

import com.jonystrins.epicventas.models.DetalleVenta

data class DetalleVentaState(
    val detalle: DetalleVenta = DetalleVenta(0, 0, 0,0, 0.0),
    val detalles: List<DetalleVenta> = emptyList()
)
