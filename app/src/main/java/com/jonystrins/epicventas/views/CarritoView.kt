package com.jonystrins.epicventas.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jonystrins.epicventas.R
import com.jonystrins.epicventas.components.ProductCard
import com.jonystrins.epicventas.components.SearchBarM3
import com.jonystrins.epicventas.repository.DetallesVentaRepository
import com.jonystrins.epicventas.states.TotalState
import com.jonystrins.epicventas.viewmodels.DetallesVentasViewModel
import com.jonystrins.epicventas.viewmodels.ProductoViewModel

@Composable
fun CarritoView(
    navController: NavController,
    carritoRepo: DetallesVentaRepository,
    carritoViewModel: DetallesVentasViewModel,
    idVenta: Int,
    productoViewModel: ProductoViewModel
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("Inventario")
                },
            ){
                Icon(Icons.Outlined.Add, null)
            }
        }
    ) {
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                              navController.navigate("Ticket/$idVenta")
                    },
                    containerColor = colorResource(R.color.verde)
                ){
                    Icon(imageVector = ImageVector.vectorResource(R.drawable.dolar), null)
                }
            },
            floatingActionButtonPosition = FabPosition.Start,
            modifier = Modifier.padding(it)
        ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it)
        ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .background(color = colorResource(R.color.purple_500)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Carrito",
                        modifier = Modifier.padding(20.dp),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                SearchBarM3()
                Row(
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total: ${carritoRepo.totalCant(idVenta)}",
                        fontSize = 30.sp
                    )
                }
                LazyColumn(
                    modifier = Modifier.padding(0.dp, 5.dp)
                ) {
                    items(carritoRepo.obtenerDetallesVenta(idVenta = idVenta)){
                        ProductCard(it, carritoViewModel, productoViewModel, navController)
                        Spacer(modifier = Modifier.size(3.dp))
                    }
                }

            }


        }
    }
}
