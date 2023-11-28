package com.jonystrins.epicventas.views

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.jonystrins.epicventas.R
import com.jonystrins.epicventas.components.ListaProductExist
import com.jonystrins.epicventas.components.ProductCard
import com.jonystrins.epicventas.components.SearchBarM3
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

@Composable
fun AlmacenView(navController: NavController) {

    var resultadoScanner by remember{ mutableStateOf("") }
    val scanLauncher = rememberLauncherForActivityResult(contract = ScanContract()){
        resultadoScanner = it.contents?: "Sin Resultado"
    }

    var options = ScanOptions().setCameraId(0).setBeepEnabled(true).setPrompt("Escanear codigo de barras");


    Scaffold(
        floatingActionButton = {
            if (resultadoScanner == ""){
                FloatingActionButton(
                    onClick = {
                        scanLauncher.launch(options)
                    },
                ){
                    Icon(ImageVector.vectorResource(R.drawable.barcode_scanner), null)
                }
            }else{
                FloatingActionButton(
                    onClick = {
                        navController.navigate("Agregar/${resultadoScanner}")
                    },
                    containerColor = colorResource(R.color.confirmacion),
                    contentColor = Color.DarkGray
                ){
                    Icon(ImageVector.vectorResource(R.drawable.barcode_scanner), null)
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Start
    ) {
        Scaffold(
            modifier = Modifier.padding(it),
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                    },
                ){
                    Icon(ImageVector.vectorResource(R.drawable.outline_note_add_24), null)
                }
            }
        ) {
            Column(
                modifier = Modifier.padding(it).fillMaxSize()
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .background(color = colorResource(R.color.purple_500)),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Inventario",
                        modifier = Modifier.padding(20.dp),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                SearchBarM3()
                LazyColumn(
                    modifier = Modifier.padding(0.dp, 5.dp)
                ) {
                    items(20){
                            item ->
                        ListaProductExist()
                        Spacer(modifier = Modifier.size(3.dp))
                    }
                }
            }
        }
    }

}