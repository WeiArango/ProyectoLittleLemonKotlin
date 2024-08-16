package com.example.littlelemonlogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**CUADRÍCULA
 * En Android, una cuadrícula es un diseño desplazable que muestra los elementos en dos dimensiones.
 * Una cuadrícula consta de filas y columnas. Cada elemento de una cuadrícula se denomina celda.
 * Para que una columna sea desplazable la propiedad de desplazamiento vertical o el modificador
 * necesitan el parámetro llamado remember scroll state. */

@Composable
fun MenuGrid() {
    GridCell()
}

@Composable
fun GridCell() {
    Card(
        elevation = 16.dp,
        modifier = Modifier
            .padding(8.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.littlelemonlogo),
            contentDescription = "Greek Salad",
        )
        Text(
            text = "Greek Salad",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 4.dp)
                .background(Color.White),
            textAlign = TextAlign.Start
        )
        Text(
            text = "12.99$",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(Color.White)
                .padding(start = 4.dp, end = 4.dp),
            textAlign = TextAlign.End
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuGridPreview() {
    MenuGrid()
}