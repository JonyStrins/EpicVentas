package com.jonystrins.epicventas.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jonystrins.epicventas.R
import com.jonystrins.epicventas.models.DetalleVenta
import com.jonystrins.epicventas.models.Producto
import com.jonystrins.epicventas.viewmodels.DetallesVentasViewModel

@Composable
fun ListaProductExist(
    producto: Producto,
    navController: NavController,
    carrito: String,
    dtsViewModel: DetallesVentasViewModel,
    idVenta: Int
){
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier.fillMaxWidth().padding(5.dp),
        onClick = {
            if(carrito.equals("carrito")){

                var entity = DetalleVenta(
                    id = 0,
                    idVenta = idVenta,
                    idProducto = producto.id,
                    cant = 1,
                    totalCant = producto.precio
                )

                dtsViewModel.agregarCarrito(entity)
                navController.popBackStack()
            }else{
                navController.navigate("Editar/${producto.id}")
            }
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ){
            AsyncImage(
                model = producto.imagen,
                contentDescription = producto.nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(150.dp)
            )
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = producto.nombre,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Text(
                    text = "Existencias: ${producto.onStock}",
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
        }
    }
}