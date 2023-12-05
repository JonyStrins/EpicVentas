package com.jonystrins.epicventas.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.jonystrins.epicventas.components.NavBarM3
import com.jonystrins.epicventas.database.EpicVentasDataBase
import com.jonystrins.epicventas.repository.DetallesVentaRepository
import com.jonystrins.epicventas.repository.ProductoRepository
import com.jonystrins.epicventas.repository.VentaRepository
import com.jonystrins.epicventas.viewmodels.DetallesVentasViewModel
import com.jonystrins.epicventas.viewmodels.ProductoViewModel
import com.jonystrins.epicventas.viewmodels.VentaViewModel
import com.jonystrins.epicventas.views.AgregarView
import com.jonystrins.epicventas.views.AlmacenView
import com.jonystrins.epicventas.views.CarritoView
import com.jonystrins.epicventas.views.EditarView
import com.jonystrins.epicventas.views.InventarioView
import com.jonystrins.epicventas.views.TicketReturnView
import com.jonystrins.epicventas.views.TicketView
import com.jonystrins.epicventas.views.VentasView

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun NavManager() {
    val navController: NavHostController = rememberNavController()
    val fecha = "00-00-0000"
    val db = Room.databaseBuilder(LocalContext.current, EpicVentasDataBase::class.java, "EpicVentas_db").allowMainThreadQueries().fallbackToDestructiveMigration().build()
    val productoDao = db.productoDao
    val ventaDao = db.ventaDao
    val carritoDao = db.dvDao
    val productoRepo = ProductoRepository(productoDao)
    val ventaRepo = VentaRepository(ventaDao)
    val carritoRepo = DetallesVentaRepository(carritoDao)
    val carritoViewModel = DetallesVentasViewModel(carritoRepo, ventaRepo.getUltimoId()+1)
    val ventaViewModel = VentaViewModel(ventaRepo, fecha)
    val productoViewModel = ProductoViewModel(productoRepo)

    Scaffold(
        bottomBar = {
            NavBarM3(navController = navController)
        }
    ){padding ->
        NavHost(navController = navController, startDestination = "Ventas", modifier = Modifier.padding(padding)){
            composable(route = "Ventas"){
                VentasView(navController, ventaRepo, carritoRepo)
            }
            composable(route = "Carrito"){
                CarritoView(navController, carritoRepo, carritoViewModel,ventaRepo.getUltimoId()+1, productoViewModel)
            }
            composable(route = "Almacen"){
                AlmacenView(navController, productoViewModel, productoRepo, carritoViewModel)
            }
            composable(route = "Agregar/{scaneo}"){
                val scaneo = it.arguments?.getString("scaneo")
                if (scaneo != null){
                    AgregarView(scaneo, navController, productoViewModel)
                }
            }
            composable(route = "Agregar"){
                    AgregarView("", navController, productoViewModel)
            }
            composable(route = "Editar/{id}"){
                val id = it.arguments?.getString("id")?.toInt()
                if (id != null){
                    EditarView(id,navController,productoViewModel)
                }
            }
            composable(route = "Inventario"){
                InventarioView(navController, productoRepo, carritoViewModel, ventaViewModel)
            }
            composable(route = "Ticket/{id}"){
                val id = it.arguments?.getString("id")?.toInt()
                if (id != null ){
                    TicketView(id, productoViewModel, navController, carritoViewModel, ventaViewModel)
                }
            }
            composable(route = "TicketReturn/{id}"){
                val id = it.arguments?.getString("id")?.toInt()
                if (id != null ){
                    TicketReturnView(id, productoViewModel, navController, carritoViewModel, ventaViewModel)
                }
            }
        }
    }
}