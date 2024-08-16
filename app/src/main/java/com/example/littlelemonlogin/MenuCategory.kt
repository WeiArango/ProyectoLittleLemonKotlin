package com.example.littlelemonlogin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**LISTAS
Ahora es el momento de explorar las listas con mayor detalle, ya que esto le ayudará a mostrar listas
en su aplicación Little Lemon. En este video, aprenderá sobre listas en Jetpack Compose y cómo
rellenar listas de elementos vertical y horizontalmente al iterar sobre ellas. También descubrirá cómo
organizar los elementos dentro de una lista. Primero exploremos las listas. Las listas se utilizan
cuando lo necesita para mostrar varios elementos, y pueden ser verticales u horizontales.
>>>Las listas horizontales se definen mediante una fila. Una fila es simplemente un diseño componible
para colocar sus elementos secundarios en una secuencia horizontal.
>>>Para listas verticales, utilice una columna. Una columna es simplemente un diseño componible para
colocar sus elementos secundarios en una secuencia vertical.
La disposición horizontal se puede utilizar para la fila que definirá la posición horizontal de sus
elementos secundarios. La disposición vertical para la columna se utiliza de una forma similar para
definir verticalmente la posición de sus elementos secundarios. Hay varios tipos de disposiciones
disponibles en Jetpack Compose. Exploremos algunas de ellas con mayor detalle. Space Between es una
posición de disposición donde comienza el primer elemento secundario y termina el último, y distribuye
equitativamente los elementos restantes intermedios. Space Around arrangement agrega espacio
al primer y último elemento secundario mientras se mantienen los demás en el centro. Como su nombre indica,
Space Evenly arrangement añade igual espacio a todos los elementos secundarios, incluyendo
espacio al inicio y al final. Finalmente, “start” mueve los elementos secundarios al comienzo,
“center” centra los elementos secundarios y “ends” los mueve hasta el final.
 */

@Composable
fun MenuCategory(categories: List<String>, onCategorySelected: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        categories.forEach { category ->
            Button(
                onClick = { onCategorySelected(category) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                shape = RoundedCornerShape(40),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = category)
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        categories.forEach { category ->
            Button(
                onClick = { onCategorySelected(category) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
                shape = RoundedCornerShape(40),
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = category)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuCategoryPreview() {
    MenuCategory(categories = Categories, onCategorySelected = {}) // Pasa una función vacía como callback
}

val Categories = listOf(
    "Launch",
    "Desert",
    "Mains"
)