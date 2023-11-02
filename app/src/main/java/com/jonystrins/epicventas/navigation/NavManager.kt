package com.jonystrins.epicventas.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jonystrins.epicventas.components.NavBarM3
import com.jonystrins.epicventas.views.AjustesView
import com.jonystrins.epicventas.views.AlmacenView
import com.jonystrins.epicventas.views.CarritoView
import com.jonystrins.epicventas.views.VentasView

@Preview
@Composable
fun NavManager() {
    val navController: NavHostController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavBarM3(navController = navController)
        }
    ){padding ->
        NavHost(navController = navController, startDestination = "Ventas", modifier = Modifier.padding(padding)){
            composable(route = "Ventas"){
                VentasView()
            }
            composable(route = "Carrito"){
                CarritoView()
            }
            composable(route = "Almacen"){
                AlmacenView(navController)
            }
            composable(route = "Ajustes"){
                AjustesView(navController)
            }
        }
    }
}