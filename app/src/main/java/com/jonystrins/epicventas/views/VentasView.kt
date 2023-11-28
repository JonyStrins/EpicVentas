package com.jonystrins.epicventas.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jonystrins.epicventas.R
import com.jonystrins.epicventas.components.SearchBarM3
import com.jonystrins.epicventas.components.VentaCard
import kotlin.math.abs
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun VentasView() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Epic Ventas") },
                colors = TopAppBarColors(
                    containerColor = colorResource(R.color.purple_500),
                    actionIconContentColor = Color.DarkGray,
                    navigationIconContentColor = Color.DarkGray,
                    scrolledContainerColor = Color.DarkGray,
                    titleContentColor = colorResource(R.color.black)
                    )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Column (
                    modifier = Modifier.fillMaxWidth()
                        .background(color = colorResource(R.color.purple_200))
                        .padding(4.dp, 1.dp),
                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text("Ventas del dia",
                            modifier = Modifier
                                .padding(0.dp, 7.dp, 0.dp,0.dp)
                                .border(
                                    border = BorderStroke(1.dp, Color.Green),
                                    shape = CutCornerShape(2.dp)
                                ),
                            color = Color.DarkGray,
                            fontSize = 20.sp
                        )
                    }

                    SearchBarM3()

                    LazyVerticalGrid (
                        modifier = Modifier.fillMaxSize()
                            .padding(0.dp, 7.dp, 0.dp,0.dp),
                        contentPadding = PaddingValues(2.dp),
                        columns = GridCells.Adaptive(150.dp)
                    ){
                        items(50){item ->
                            VentaCard()
                        }
                    }
                }
            }
        }
    }
}