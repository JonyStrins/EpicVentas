package com.jonystrins.epicventas.views

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jonystrins.epicventas.R
import com.jonystrins.epicventas.transforms.PrefixVisualTransformation

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarView(
//    numero: String,
//    navController: NavController
){

    var num by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var precio by remember { mutableStateOf("") }
    var cant by remember { mutableStateOf("") }
    var exist by remember { mutableStateOf("0") }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Agregar")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
//                            navController.popBackStack()
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
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .border(2.dp, Color.LightGray, RoundedCornerShape(10.dp))
            ){
                Column(
                    modifier = Modifier.padding(7.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = null,
                        contentDescription = null,
                        placeholder = painterResource(R.drawable.ic_launcher_background),
                        modifier = Modifier
                            .width(300.dp)
                            .height(300.dp)
                            .clickable {

                            },
                        contentScale = ContentScale.Crop
                    )
                    Row {
                        OutlinedTextField(
                            value = num,
                            onValueChange = { num = it },
                            label = { Text("Numero del producto") },
                            singleLine = true,
                            placeholder = { Text("Ingrese el numero del producto") },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )
                        )
                    }
                    Row {
                        OutlinedTextField(
                            value = nombre,
                            onValueChange = { nombre = it },
                            label = { Text("Nombre del producto") },
                            singleLine = true,
                            placeholder = { Text("Ingrese el Nombre del producto") },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Done
                            )
                        )
                    }
                    Row {
                        OutlinedTextField(
                            value = precio,
                            onValueChange = { precio = it },
                            label = { Text("Precio del producto") },
                            singleLine = true,
                            visualTransformation = PrefixVisualTransformation("$ "),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            )
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Text("Cantidad de Productos")
                            OutlinedTextField(
                                value = cant,
                                onValueChange = { cant = it },
                                label = { Text("#") },
                                placeholder = { Text("#") },
                                modifier = Modifier.width(70.dp),
                                singleLine = true,
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Done
                                )
                            )
                        }
                        Column (
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(4.dp)
                        ){
                            Text("En Existencia")
                            OutlinedTextField(
                                value = exist,
                                onValueChange = { exist = it },
                                label = { Text("#") },
                                modifier = Modifier.width(70.dp),
                                singleLine = true,
                                readOnly = true,
                            )
                        }
                    }
                }
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {},
                    colors = ButtonColors(Color.Red, Color.White, Color.White, Color.White)
                ){
                    Text("Cancelar")
                }
                Button(
                    onClick = {},
                    colors = ButtonColors(colorResource(R.color.confirmacion), Color.White, Color.White, Color.White)
                ){
                    Text("Agregar")
                }
            }
        }
    }
}