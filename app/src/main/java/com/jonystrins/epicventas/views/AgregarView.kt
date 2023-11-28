package com.jonystrins.epicventas.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgregarView(
    numero: String,
    navController: NavController
){
    Scaffold(
        topBar = {
            TopAppBar(
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
                }
            )

        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Text("$numero")
        }
    }
}