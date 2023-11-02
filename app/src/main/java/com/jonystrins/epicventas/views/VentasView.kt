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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
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
import kotlin.math.abs
import kotlin.random.Random

@Preview
@Composable
fun VentasView() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .background(color = colorResource(R.color.purple_500)),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Epic Ventas",
                    modifier = Modifier.padding(20.dp),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }
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
                            .border(
                                border = BorderStroke(1.dp, Color.Green),
                                shape = CutCornerShape(2.dp)
                            ),
                        color = Color.DarkGray,
                        fontSize = 20.sp
                    )
                }
                
                SearchBarM3()

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp, 5.dp)
                        .background(Color.White),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Text("Hora")
                    Text("Productos")
                    Text("Total")
                }

                LazyColumn (
                    modifier = Modifier.fillMaxSize()
                ){
                    items(50){item ->
                        Row (
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White),
                            horizontalArrangement = Arrangement.SpaceAround
                        ){
                            Text("00:00:00", modifier = Modifier.padding(5.dp), fontSize = 15.sp)
                            Text("${item+1}", modifier = Modifier.padding(5.dp), fontSize = 15.sp)
                            Text("$"+ "${abs(item + Random.nextInt())}", modifier = Modifier.padding(5.dp), fontSize = 15.sp)
                        }
                    }
                }
            }
        }
    }
}