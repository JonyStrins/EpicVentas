package com.jonystrins.epicventas.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jonystrins.epicventas.models.Venta
import com.jonystrins.epicventas.repository.DetallesVentaRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VentaCard(
    venta: Venta,
    navController: NavController
){
    OutlinedCard(
        modifier = Modifier.width(150.dp).height(110.dp),
        onClick = {
            navController.navigate("TicketReturn/${venta.id}")
        }
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CenterAlignedTopAppBar(title = { Text("Venta ${venta.id}") })
                Text(venta.hora, fontSize = 20.sp)
                Text("Total: ${venta.total}")
            }
        }
    }
}