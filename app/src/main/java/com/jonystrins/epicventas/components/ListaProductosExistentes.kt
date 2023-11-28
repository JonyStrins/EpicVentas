package com.jonystrins.epicventas.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jonystrins.epicventas.R

@Preview
@Composable
fun ListaProductExist(){
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier.fillMaxWidth().padding(5.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ){
            Image(
                painter = painterResource(
                    id = R.drawable.ic_launcher_background
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Producto",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp
                )
                Text(
                    text = "Existencias: 5",
                    color = Color.Gray,
                    fontSize = 13.sp
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Top
            ) {
                Icon(Icons.Outlined.MoreVert,null)
            }
        }
    }
}