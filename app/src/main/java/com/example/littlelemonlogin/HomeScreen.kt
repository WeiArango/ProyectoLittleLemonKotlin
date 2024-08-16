package com.example.littlelemonlogin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Home Screen",
        fontSize = 32.sp,
        )
        Button(
            onClick = { navController.navigate(MenuList.route) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF495E57),
            )
        ) {
            Text(text = "Destino MenuList",
            color = Color(0xFFFFFFFF)
            )
        }
        Button(
            onClick = { navController.navigate(SettingsScreen.route) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF495E57),
            )
        ) {
            Text(text = "Destino SettingsString",
            color = Color(0xFFFFFFFF)
            )
        }
        Button(
            onClick = { navController.navigate(DashBoardScreen.route) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF495E57),
            )
        ) {
            Text(text = "Destino Dashboard",
            color = Color(0xFFFFFFFF)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}