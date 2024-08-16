package com.example.littlelemonlogin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

/**VAMOS A NAVEGAR UTILIZANDO NavController, NavHost y NavGraph EN JETPACK COMPOSE
 * En primer lugar, cada pantalla de la aplicación se llamará destino.
 * >>>NavGraph es una colección de destinos navegables. NavGraph se proporciona a VavHost para
 * construir el gráfico de navegación. NavGraph necesita raíces, así que se necesita crear un
 * archivo .kt para los destinos junto con sus raíces. En este caso se llamará Destinatios.kt.
 * >>>NavHost actúa como contenedor para mostrar el destino actual. Toma el NavController como
 * parámetro de entrada, y lo asocia al NavGraph.
 * >>>Navcontroller es responsable de navegar entre destinos, mientras se gestiona la pila trasera.
 * VAMOS A TRABAJAR PARA ESTE EJEMPLO CON DOS PANTALLAS: DashboardScreen Y DetailsScreen*/

@Composable
fun DashBoardScreen(navController: NavHostController){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Dashboard Screen",
            fontSize = 48.sp,
        )
        Button(onClick = { navController.navigate(DetailsScreen.route) }) {
            Text(text = "Destino Details")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DashBoardScreenPreview(){
    DashBoardScreen(navController = rememberNavController())
}