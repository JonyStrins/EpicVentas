package com.jonystrins.epicventas.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jonystrins.epicventas.R
import com.jonystrins.epicventas.components.ListaProductExist
import com.jonystrins.epicventas.components.SearchBarM3
import com.jonystrins.epicventas.repository.ProductoRepository
import com.jonystrins.epicventas.viewmodels.DetallesVentasViewModel
import com.jonystrins.epicventas.viewmodels.VentaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventarioView(
    navController: NavController,
    repository: ProductoRepository,
    carritoViewModel: DetallesVentasViewModel,
    ventaViewModel: VentaViewModel
) {

    val idVenta = ventaViewModel.obtenerUltimoIdVenta()+1

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Agregar")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ){
                        Icon(Icons.AutoMirrored.Default.ArrowBack, null)
                    }
                },
                colors = TopAppBarColors(
                    containerColor = colorResource(R.color.dodger_blue_800),
                    scrolledContainerColor = colorResource(R.color.dodger_blue_300),
                    navigationIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    actionIconContentColor = colorResource(R.color.dodger_blue_300),
                )
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            SearchBarM3()
            LazyColumn(
                modifier = Modifier.padding(0.dp, 5.dp)
            ) {
                items(repository.getProductos()){
                    ListaProductExist(it, navController, "carrito", carritoViewModel, idVenta)
                    Spacer(modifier = Modifier.size(3.dp))
                }
            }
        }
    }
}