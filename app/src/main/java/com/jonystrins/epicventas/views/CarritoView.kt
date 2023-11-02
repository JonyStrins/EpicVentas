package com.jonystrins.epicventas.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jonystrins.epicventas.R
import com.jonystrins.epicventas.components.ProductCard
import com.jonystrins.epicventas.components.SearchBarM3

@Preview
@Composable
fun CarritoView() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(color = colorResource(R.color.purple_500)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Carrito",
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
                ProductCard()
                Spacer(modifier = Modifier.size(3.dp))
            }
        }
    }
}