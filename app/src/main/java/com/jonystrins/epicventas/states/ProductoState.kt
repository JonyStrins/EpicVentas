package com.jonystrins.epicventas.states

import com.jonystrins.epicventas.models.Producto

data class ProductoState(
    val producto: Producto = Producto(0,"","", 0,"", 0.0),
    val productos: List<Producto> = emptyList()
)
