package com.jonystrins.epicventas.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun ProductCard() {
    Card {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(0.dp, 5.dp, 10.dp, 5.dp)
            ) {
                Icon(Icons.Default.Face, "")
            }
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = "Producto")
                Text(text = "Descripcion")
                Text(text = "ID: 15246")
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Row {
                    Button(onClick = {  }){
                        Text(text = "1")
                    }
                    IconButton(
                        onClick = {  }
                    ){
                        Icon(Icons.Default.Delete, "")
                    }
                }
            }
        }
    }
}