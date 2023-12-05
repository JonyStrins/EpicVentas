package com.jonystrins.epicventas.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jonystrins.epicventas.models.DetalleVenta
import com.jonystrins.epicventas.states.TotalState
import com.jonystrins.epicventas.viewmodels.DetallesVentasViewModel
import com.jonystrins.epicventas.viewmodels.ProductoViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun ProductCard(
    detalleVenta: DetalleVenta,
    carritoViewModel: DetallesVentasViewModel,
    productoViewModel: ProductoViewModel,
    navController: NavController
) {

    var cant by remember { mutableStateOf(detalleVenta.cant.toString()) }
    var cantTemp by remember { mutableStateOf(cant) }
    val producto = productoViewModel.obtenerProducto(detalleVenta.idProducto)
    val keyboardController = LocalSoftwareKeyboardController.current

    Card {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(0.dp, 5.dp, 10.dp, 5.dp)
            ) {
                Icon(Icons.Default.Face, "")
            }
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = producto.nombre)
                Text(text = "En Existencia: ${producto.onStock}")
                Text(text = "ID: ${producto.codigoBarras}")
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Row {
                    TextField(
                        value = cantTemp,
                        onValueChange = {
                            cantTemp = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                if(cantTemp.isNotEmpty()) {
                                    var entity = DetalleVenta(
                                        id = detalleVenta.id,
                                        idVenta = detalleVenta.idVenta,
                                        idProducto = detalleVenta.idProducto,
                                        cant = cantTemp.toInt(),
                                        totalCant = cantTemp.toInt() * producto.precio
                                    )

                                    if(cantTemp.toInt() > producto.onStock){
                                        cantTemp = producto.onStock.toString()

                                        var entity = DetalleVenta(
                                            id = detalleVenta.id,
                                            idVenta = detalleVenta.idVenta,
                                            idProducto = detalleVenta.idProducto,
                                            cant = cantTemp.toInt(),
                                            totalCant = cantTemp.toInt() * producto.precio
                                        )

                                        carritoViewModel.actualizar(entity)
                                        navController.navigate("Carrito")
                                    }else{
                                        carritoViewModel.actualizar(entity)
                                        navController.navigate("Carrito")
                                    }
                                }

                                keyboardController?.hide()
                            }
                        ),
                        modifier = Modifier.size(60.dp, 50.dp)
                    )
                    IconButton(
                        onClick = {
                            var entity = DetalleVenta(
                                id = detalleVenta.id,
                                idVenta = detalleVenta.idVenta,
                                idProducto = detalleVenta.idProducto,
                                cant = cantTemp.toInt(),
                                totalCant = cantTemp.toInt() * producto.precio
                            )

                            carritoViewModel.eliminarCarrito(entity)
                            navController.navigate("Carrito")
                        }
                    ){
                        Icon(Icons.Default.Delete, "")
                    }
                }
            }
        }
    }
}