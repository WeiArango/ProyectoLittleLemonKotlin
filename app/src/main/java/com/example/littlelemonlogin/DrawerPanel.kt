package com.example.littlelemonlogin

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardReturn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**Acá voy a crear un panel de cajón para abrir cuando el usuario haga clic en el botón de cajón.
 * Voy a agregar el cajón y la acción de abrir el cajón en el botón de la barra de aplicaciones
 * superior. */

@Composable
//Llamo a los parámetros de scaffoldState y coroutineScope para crear el cajón y abrirlo
fun DrawerPanel(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    List(10) {
        Text(text = "item #$it", modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp))
    }
    //Llamo a scope en el ícono de cierre del cajón para cerrar el cajón
    IconButton(onClick = {
        scope?.launch { scaffoldState?.drawerState?.close() }
    }) {
        Icon(
            imageVector = Icons.Filled.KeyboardReturn,
            contentDescription = "Close icon",
            tint = Color.Black
        )
    }
}


