package com.jonystrins.epicventas.views

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.jonystrins.epicventas.R
import com.jonystrins.epicventas.components.MyDatePickerDialog
import com.jonystrins.epicventas.components.SearchBarM3
import com.jonystrins.epicventas.components.VentaCard
import com.jonystrins.epicventas.repository.DetallesVentaRepository
import com.jonystrins.epicventas.repository.VentaRepository
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.math.abs
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VentasView(
    navController: NavController,
    ventasRepo: VentaRepository,
    carritoRepo: DetallesVentaRepository
) {

    val calendar = Calendar.getInstance()
    calendar.set(LocalDate.now().year, LocalDate.now().monthValue-1, LocalDate.now().dayOfMonth-1) // add year, month (Jan), date

    // set the initial date
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = calendar.timeInMillis)

    var showDatePicker by remember {
        mutableStateOf(false)
    }

    var selectedDate by remember {
        mutableLongStateOf(calendar.timeInMillis) // or use mutableStateOf(calendar.timeInMillis)
    }

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

                    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.ROOT)

                    if (showDatePicker) {
                        DatePickerDialog(
                            onDismissRequest = {
                                showDatePicker = false
                            },
                            confirmButton = {
                                TextButton(onClick = {
                                    showDatePicker = false
                                    selectedDate = datePickerState.selectedDateMillis!!
                                }) {
                                    Text(text = "Confirm")
                                }
                            },
                            dismissButton = {
                                TextButton(onClick = {
                                    showDatePicker = false
                                }) {
                                    Text(text = "Cancel")
                                }
                            }
                        ) {
                            DatePicker(
                                state = datePickerState
                            )
                        }
                    }

                    Button(
                        onClick = {
                            showDatePicker = true
                        }
                    ) {
                        Text(text = formatter.format(Date(selectedDate.plus(86400000))))
                    }

                    SearchBarM3()

                    LazyVerticalGrid (
                        modifier = Modifier.fillMaxSize()
                            .padding(0.dp, 7.dp, 0.dp,0.dp),
                        contentPadding = PaddingValues(2.dp),
                        columns = GridCells.Adaptive(150.dp)
                    ){
                        items(ventasRepo.getVentas(formatter.format(Date(selectedDate.plus(86400000))))){
                            VentaCard(it, navController)
                        }
                    }
                }
            }
        }
    }
}