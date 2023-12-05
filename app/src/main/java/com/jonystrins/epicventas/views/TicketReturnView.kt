package com.jonystrins.epicventas.views

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jonystrins.epicventas.R
import com.jonystrins.epicventas.models.Venta
import com.jonystrins.epicventas.viewmodels.DetallesVentasViewModel
import com.jonystrins.epicventas.viewmodels.ProductoViewModel
import com.jonystrins.epicventas.viewmodels.VentaViewModel
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.util.Calendar
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicketReturnView(
    idVenta: Int,
    produViewModel: ProductoViewModel,
    navigation: NavController,
    carritoViewModel: DetallesVentasViewModel,
    ventaViewModel: VentaViewModel
){

    var lista = carritoViewModel.obtenerDetallesVenta(idVenta)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Ticket")
                        Text("Compra: ${carritoViewModel.totalSum(idVenta)}", fontSize = 13.sp)
                    }
                }
//                navigationIcon = {
//                    IconButton(
//                        onClick = {}
//                    ){
//                        Icon(Icons.AutoMirrored.Default.ArrowBack, null)
//                    }
//                }
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            lista.forEach {
                var producto = produViewModel.obtenerProducto(it.idProducto)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(producto.nombre)
                    Text(it.cant.toString())
                    Text(producto.precio.toString())
                    Text(it.totalCant.toString())
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        navigation.popBackStack()
                    },
                    colors = ButtonColors(Color.Red, Color.White, Color.White, Color.White)
                ){
                    Text("Cancelar")
                }
            }
        }
    }
}