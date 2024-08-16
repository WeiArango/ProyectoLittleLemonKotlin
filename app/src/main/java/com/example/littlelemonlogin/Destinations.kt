package com.example.littlelemonlogin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

/**ACÁ VOY DEFINIR UNA INTERFÁZ LLAMADA DESTINOS EN LA QUE AÑADO LAS PANTALLAS QUE VAMOS A TENER Y
 * AGREGO UNA RUTA VARIABLE DE TIPO STRING. ESTA INTERFÁZ SE UTILIZARÁ PARA AMPLIAR LOS OBJETOS
 * DE DESTINO. ESTO EQUIVALE A DEFINIR UN ID PARA CADA PANTALLA.
 * RECUERDE QUE LA PALABRA CLAVE OBJETC CREA UN OBJETO SIN CREAR LA CLASE. UNA VEZ DEFINIDOS LOS
 * OBJETOS DE DESTINO CON LA RUTA, PASO A LA ACTIVIDAD PRINCIPAL PARA DEFINIR NavController y
 * NavHost, DEBE CREARSE NavController EN LA PARTE SUPERIOR DE LA JERARQUÍA COMPONIBLE*/

interface Destinations {
    val route: String
    val icon: ImageVector
    val title: String
}
object Home : Destinations {
    /**Debo utilizar todas las variables que estoy creando en el componible Destinations en todas y
     * cada uno de los objetos de destino.*/
    override val route = "Home"
    override val icon = Icons.Filled.Home
    override val title = "Home"
}
object MenuList : Destinations {
    override val route = "MenuList"
    override val icon = Icons.Filled.Home
    override val title = "Menu"
}
object LoginScreen : Destinations {
    override val route = "LoginScreen"
    override val icon = Icons.Filled.Home
    override val title = "Login"
}
object DashBoardScreen : Destinations {
    override val route = "Dashboard"
    override val icon = Icons.Filled.Home
    override val title = "Dashboard"
}
object DetailsScreen : Destinations {
    override val route = "Details"
    override val icon = Icons.Filled.Home
    override val title = "Details"
}
object SettingsScreen : Destinations {
    override val route = "SettingsScreen"
    override val icon = Icons.Filled.Settings
    override val title = "Settings"
}