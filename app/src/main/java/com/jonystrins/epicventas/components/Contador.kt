package com.jonystrins.epicventas.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jonystrins.epicventas.R

@Preview
@Composable
fun Contador(){

    var cont by remember {
        mutableIntStateOf(0)
    }

    Row(
        modifier = Modifier
            .border(BorderStroke(
                width = 2.dp,
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFF42A5F5),
                        Color(0xFFFFA726)
                    )
                )),
//                shape = CutCornerShape()
            )
    ) {
        IconButton(
            onClick = {
                if (cont>0){
                    cont = (cont-1)
                }
            },
            modifier = Modifier.background(Color.Red)
                .size(40.dp, 50.dp)
        ){
            Icon(imageVector = ImageVector.vectorResource(R.drawable.remove), "")
        }
        TextField(
            value = cont.toString(),
            onValueChange = { cont = it.toInt() },
            modifier = Modifier.size(40.dp, 50.dp)
        )
        IconButton(
            onClick = {
                if (cont>0){
                    cont = (cont-1)
                }
            },
            modifier = Modifier.background(Color.Green)
                .size(40.dp, 50.dp),
        ){
            Icon(Icons.Default.Add, "", tint = Color.White)
        }
    }
}