package com.jonystrins.epicventas.states

import com.jonystrins.epicventas.models.Venta

data class VentaState(
    val venta: Venta = Venta(0, "", "", 0.0),
    val ventas: List<Venta> = emptyList()
)
