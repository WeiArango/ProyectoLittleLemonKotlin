package com.example.littlelemonlogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LunchDining
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopAppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(Color(0xFFFFFFFF))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        //Llamo a la función scaffoldState.drawerState.open() para abrir el cajón. Hacer los mismo
        //para cerrar el cajón con scaffoldState.drawerState.close()
        IconButton(onClick = {
            scope?.launch { scaffoldState?.drawerState?.open() }
        }) {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menú",
                tint = Color.Black // Cambia el color del icono
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.Store,
                contentDescription = "Store",
                tint = Color.Black
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.LunchDining,
                contentDescription = "Lunch",
                tint = Color.Black
            )
        }

        IconButton(onClick = { }) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "ShoppingCart",
                tint = Color.Black
            )
        }

        Image(
            painter = painterResource(id = R.drawable.littlelemonlogo),
            contentDescription = "Logo Image",
            modifier = Modifier
                .padding(vertical = 5.dp, horizontal = 8.dp)
                .size(30.dp, 40.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    TopAppBar(scaffoldState = rememberScaffoldState(), scope = rememberCoroutineScope())
}

