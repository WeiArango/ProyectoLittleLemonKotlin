package com.example.littlelemonlogin


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/*EVENTOS DE INTERACCIÓN
Uno de los conceptos clave en el desarrollo de aplicaciones es la interacción con el usuario. Los
eventos de interacción se activan cuando un usuario interactúa con un elemento de la interfaz de usuario.
Estos eventos pueden ser manejados por el desarrollador para dar una respuesta a las acciones del
usuario. Algunos ejemplos de eventos de interacción en Jetpack Compose incluyen clics, pulsaciones
prolongadas y deslizamientos.
Los componentes responden a las interacciones de diferentes maneras para que los usuarios sepan qué
están haciendo sus acciones. Por ejemplo, si toca un botón en la pantalla táctil de un dispositivo,
es probable que el botón cambie de alguna manera, tal vez agregando un color de resaltado. Este
cambio de interfaz de usuario ayuda al usuario a saber que tocó el botón.

El modificador clickable
Uno de los modificadores de eventos más utilizados es el modificador "clickable".
Este modificador permite a los desarrolladores especificar una función que se ejecutará cuando un
usuario haga clic o toque un componible específico. Esto se puede usar para desencadenar acciones como
navegar a una nueva pantalla o actualizar el estado de un componible.

El modificador de combinación en el que se puede hacer clic
Otro modificador de evento útil es el modificador "combineClickable", que permite ejecutar una función
diferente cuando un usuario presiona prolongadamente un componible. Esto puede ser útil para
proporcionar opciones o acciones adicionales para un componible.

El modificador draggable
Jetpack Compose también permite el uso de detectores de gestos, como el modificador "draggagle".
Este modificador permite la detección de gestos de arrastre en un componible, lo que permite la
implementación de la funcionalidad de arrastrar y soltar dentro de una interfaz de usuario.

Gestos personalizados
Además de los gestos integrados, Jetpack Compose también permite a los desarrolladores crear gestos
personalizados y detectores de gestos. Esto permite aún más flexibilidad y personalización en la
interfaz de usuario. Por ejemplo, un desarrollador podría crear un gesto personalizado que active
una acción específica cuando un usuario desliza el dedo en una dirección particular.

Recomposición de componibles
Actualiza la interfaz de usuario cada vez que cambien los datos. Esto se llama recomposición.

Sistema de Diseño
Un sistema de diseño representa pautas de diseño. Es una colección de componentes que llevan elementos
de IU estándar y reutilizables. No solo informa a los desarrolladores sobre cómo usar y organizar
elementos individuales de la IU, sino también expone patrones, temas y ejemplos de diseños y diseños
de IU en varios niveles.
* El diseño de materiales, por otro lado, es uno de los más populares y completos sistemas de diseño
que crean impresionantes interfaces de usuario. En el diseño de materiales, los elementos individuales
de la interfaz de usuario se denominan componentes materiales y tienen una apariencia y una sensación
estándar y adaptable. El kit de herramientas de interfaz de usuario Jetpack Compose puede ayudarlo a
implementar el diseño de materiales. Jetpack, Compose facilita la implementación del sistema de diseño
de materiales para darle a su aplicación una apariencia consistente. También ofrece varios componentes
de material que se pueden implementar integrados, es decir, en composición. Por ejemplo, los componentes
de botón, campo de texto, tarjeta de casilla de verificación y barra deslizadora también ofrecen patrones
de interfaz de usuario comunes, combinando varios de los componentes materiales
* Patrones de diseño: Son estructuras de diseño de IU comunes que se encuentran en muchas aplicaciones.
Por ejemplo, una barra de aplicación superior que lleva el nombre de la aplicación y algunos botones
relevantes para la pantalla actual. La barra superior de la aplicación es un patrón de IU y
generalmente se usa como un componente compuesto que consta de varios elementos de la IU.
Del mismo modo, el cajón de navegación es un patrón de IU común que se encuentra en muchas aplicaciones.
Contiene varios elementos de la IU, muchos de los cuales son botones, iconos u otros elementos de texto
en los que se puede hacer clic. El cajón normalmente se abre haciendo clic en un botón en la parte
superior de la barra o deslizando desde el borde izquierdo de la pantalla hacia la derecha. La barra
de la aplicación superior se compone del botón del cajón de navegación, el título de la aplicación y
el botón de la cesta

SCAFFOLD
Compose proporciona una manera conveniente de combinar estos patrones de IU y componentes materiales.
Utiliza un componible especial llamado andamio(Scaffold).
La palabra andamio se usa generalmente en la construcción y se refiere a las estructuras flexibles
que ayudan a sostener a los constructores. En los andamios de desarrollo de la IU de Android, hay
diseños personalizables que proporcionan soporte para agregar varias estructuras y componentes de
IU que incluyen barras de aplicaciones, snackbars, el cajón de navegación y los botones de acción
flotantes. Además del cuerpo principal del andamio. Un andamio se puede configurar para incluir
algunas o todas estas estructuras de interfaz de usuario.
Por ejemplo, para agregar una barra superior al andamio en su aplicación de Little Lemon, proporciona
un argumento para la propiedad de la barra superior mediante el TopAppBar incorporado, componible.
De manera similar, otras propiedades que se utilizan para definir componentes de material relevantes
son
bottomBar,
snackbarHost,
floatActionButton y
DrawerContent.
El andamio (Scaffold) es un compuesto que es un componente material en Compose

Otros tipos de Andamios:
* Bottom Sheet Scaffold
Un Bottom Sheet Scaffold es un patrón de interfaz de usuario que se desliza hacia arriba desde la
parte inferior de la pantalla para mostrar contenido u opciones adicionales. Por lo general, se usa
para mostrar información contextual, como una lista de opciones o una lista de elementos a los que
se accedió recientemente. Los Bottom Sheet Scaffold a menudo se utilizan para proporcionar un entorno
libre de distracciones para que los usuarios accedan a información adicional cuando sea necesario,
sin ocupar demasiado espacio en la pantalla.
@Composable
fun BottomSheetScaffold() {
    BottomSheetScaffold(
        bottomSheet = {
            BottomSheet(
                onCloseRequest = {
                    // Add logic to handle the bottom sheet closing
                }
            ) {
                // Add content to be displayed in the bottom sheet
            }
        },
        bodyContent = {
            // Add content to be displayed in the body
        }
    )
}

* Backdrop Scaffold
Backdrop Scaffold es una poderosa herramienta para crear diseños dinámicos en Jetpack Compose.
Proporciona una manera de crear fácilmente un diseño flexible y receptivo para una aplicación y
permite una fácil personalización de la apariencia. Backdrop Scaffold es un patrón de interfaz de
usuario que proporciona una superposición de pantalla completa cuando se activa. Por lo general, se
usa para mostrar contenido adicional, como un menú, una barra de búsqueda u otras opciones relacionadas
con el contenido principal en la pantalla. Backdrop Scaffold es útil para proporcionar una capa
adicional de contexto y opciones al usuario. También puede utilizar la API de BackdropScaffold para
animar el fondo, el tamaño de fuente y otros elementos del diseño.
@Composable
fun MyScreen() {
    BackdropScaffold(
        scaffoldState = rememberScaffoldState(),
        topBar = {
            TopAppBar(
                title = { Text("My Screen") }
            )
        },
        bodyContent = {
            // Your content here
            // ...
        },
        backLayer = {
            // Your content here
            // ...
        },
        frontLayer = {
            // Your content here
            // ...
        }
    )
}

* Navigation Drawer Scaffold
Navigation Drawer Scaffold es un patrón de interfaz de usuario que proporciona un panel lateral para
navegar entre diferentes partes de la aplicación. Se suele utilizar para proporcionar acceso a los
elementos de navegación de nivel superior de una aplicación, así como a cualquier contenido adicional.
Los cajones de navegación se utilizan a menudo para proporcionar acceso rápido a contenido o funciones
importantes cuando es necesario. También proporciona una manera fácil de configurar y controlar
mediante programación el cajón de navegación. Navigation Drawer Scaffold también facilita agregar
iconos, encabezados y otros componentes al cajón de navegación. Además, proporciona una forma de
moverse rápidamente entre diferentes pantallas sin tener que crear manualmente una lógica de navegación.
Esto le permite crear rápidamente una interfaz de usuario de estilo de navegación en su aplicación con
un mínimo esfuerzo.
@Composable
fun MyApp() {
    val navigation = NavigationDrawerController()
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "My App") },
                    navigationIcon = {
                        NavigationDrawerIcon(
                            drawerState = navigation.drawerState,
                            onStateChange = navigation.updateDrawerState
                        )
                    }
                )
            },
            drawerContent = {
                var context = ContextAmbient.current
                MyDrawerContent(
                    closeDrawer = {
                        navigation.updateDrawerState(DrawerState.Closed)
                    },
                    navigateToScreen = { screen ->
                        // Handle navigation
                    }
                )
            }
        ) {
            // The main content of your screen
            Text(text = "This is the main content")
        }
    }
}


SCAFFOLDSTATE
El estado de andamiaje es una clase en Compose. Mantiene un estado de pantalla básico como los
tamaños de los componentes en las tiendas, el estado del cajón y el anfitrión del snack bar.
El estado se puede cambiar al invocar sus funciones públicas como abiertas o cerradas que corresponden
a la apertura o cierre del cajón. Por ejemplo, para abrir el cajón utilice el objeto estado de
andamiaje para obtener el objeto de estado del cajón, luego llame a abrir usando el objeto de estado
del cajón. Sin embargo, como open es una función de suspensión, la declaración debe ejecutarse
dentro de una rutina central. Una rutina central a alto nivel es un componente del programa que toma
un bloque de código y lo ejecuta concurrentemente con el resto del código.
Una función suspendida en Kotlin es simplemente una función que se puede pausar y reanudar más tarde.
Una función suspendida solo puede invocarse dentro de una rutina. El lanzamiento construye una
rutina. Lanza una nueva rutina junto con el resto del código. Se declara un lanzamiento en el ámbito
de corutina, que es un ámbito para la nueva rutina




**/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContent se usa para establecer el contenido de la actividad. Configura la UI en pantalla
        setContent {
            //Llamo a myNavigation dentro del setContent para utilizar la función navegar entre páginas
            MyNavigation()
        }
    }
}
/**ACÁ CREO EL COMPONIBLE myNavigation Y LO INVOCO DENTRO DEL CONTENIDO ESTABLECIDO. MyNavigation
 * ES AHORA MI COMPINIBLE DE NIVEL SUPERIOR. LUEGO CREO navController DENTRO DE MyNavigation
 * INVOCANDO A LA FUNCIÓN rememberNavController(). A CONTINUACIÓN CREO NavHost Y LE PASO navController
 * COMO ARGUMENTO Y EN LUGAR DE DEFINIR EL GRÁFICO, UTILIZA startDestination Y LO ESTABLEZCO EN LA RUTA
 * HomeScreen.kt. AHORA LLAMO A LA FUNCIÓN componible Y PASO LA RUTA Home. PARA LA NAVEGACIÓN LLAMO
 * A LA FUNCIÓN HomeScreen. HAGO LO MISMO CON EL OBJETO MenuList. A CONTINUACIÓN PASO navController
 * AL COMPONIBLE HomeScreen PARA PODER UTILIZARLO PARA NAVEGAR DESDE HomeScreen A MenuList.
 * FINALMENTE VOY AL ARCHIVO HomeScreen Y LLAMO A LA FUNCIÓN navigate DE navController CON EL DESTINO
 * MenuList EN LAMBDA DEL BOTÓN DE FORMA QUE PUEDO NAVEGAR A MenuListScreenn DESDE HomeScreen.
 * Finalmente agrego el andamio (Scaffold) dentro de MyNavigation y paso la función de MyBottomNavigation
 * en el atributo bottomBar. Paso el navController a MyNavigation Composable. Creo un Box para
 * los valores de relleno del Scaffold con NavHost dentro. Paso el navController como primer parámetro
 * y Home.route como startDestination. Llamo a la función componible y paso Home.route como ruta. Dentro
 * de las llaves llamo al componible HomeScreen. Del mismo modo, agrego el componible SetttingsScreen
 * */
@Composable
fun MyNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = LoginScreen.route) {

        //Ruta para el login
        composable(LoginScreen.route) {
            LoginScreen(navController) // LoginScreen sin Scaffold
        }

        // Rutas para agregar Scaffold
        composable(Home.route) {
            ScaffoldDrawer(navController) {
                ScaffoldButtomBar(navController) { paddingValues ->
                    HomeScreen(navController)
                }
            }
        }
        composable(MenuList.route) {
            ScaffoldDrawer(navController) {
                ScaffoldButtomBar(navController) { paddingValues ->
                    MenuListenScreen()
                }
            }
        }
        composable(DashBoardScreen.route) {
            ScaffoldDrawer(navController) {
                ScaffoldButtomBar(navController) { paddingValues ->
                    DashBoardScreen(navController)
                }
            }
        }
        composable(DetailsScreen.route) {
            ScaffoldDrawer(navController) {
                ScaffoldButtomBar(navController) { paddingValues ->
                    DetailsScreen()
                }
            }
        }
        composable(SettingsScreen.route) {
            ScaffoldDrawer(navController) {
                ScaffoldButtomBar(navController) { paddingValues ->
                    SettingsScreen()
                }
            }
        }
        // ... otras rutas
    }
}

/**Acá voy a crear un componible para un botón de navegación inferior que me permita navegar entre
 * páginas. Primero creo una variable llamada destinatios que contenga una lista de objetos
 * de destino. Luego creo una variable llamada selectedIndex que se utiliza para almacenar el índice
 * al remembereSaveable de la última pantalla seleccionada con un valor de cero, en este caso sería
 * Home en la lista de objetos de destino. A continuación agrego BottonNavigation donde itero la
 * lista de destinos con forEachIndexed. Luego agrego un elemento de BottomNavigationItem y defino
 * el parámetro de etiqueta en el objeto de texto con el título de cada objeto de destino. Finalmente
 * se establece el parámetro del ícono en el objeto del ícono con el icono de cada objeto de destino.
 * Se pasa destination.title como segundo parámetro. Defino el parámetro seleccionado en
 * index==selectedIndex.value en mostrar el elemento como seleccionado cuando coincide con el
 * índice seleccionado. Configuro el valor del índice seleccionado igual al índice en la función
 * Elementos al hacer click, luego llamo al navController.navigate con la lista de destinos con la ruta.
 * dentro de las llaves de Navigate, llamo a popup to Home.route para eliminar todo desde Stack hasta
 * la pantalla de inicio. Y para evitar agregar la misma pantalla mas de una vez, configuro
 * launchSingleTop en true.*/
// Función auxiliar para encapsular el BottomNavigation
@Composable
fun MyBottomNavigation(navController: NavHostController) {
    val destinations = listOf<Destinations> (
        Home,
        SettingsScreen
    )
    val selectedIndex = rememberSaveable {
        mutableStateOf(0)
    }
    BottomNavigation(){
        destinations.forEachIndexed { index, destination ->
            BottomNavigationItem(
                label = { Text(text = destination.title) },
                icon = { Icon(imageVector = destination.icon, contentDescription = destination.title) },
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destinations[index].route){
                        //El atributo popUp impide agregar la misma pantalla más de una vez a la pila posterior
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }
                }

            )
        }
    }
}

// Función auxiliar para encapsular el ScaffoldButtonBar
@Composable
fun ScaffoldButtomBar(navController: NavHostController, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(bottomBar = { MyBottomNavigation(navController = navController) }) { paddingValues ->
        content(paddingValues)
    }
}

//Acá voy a crear las variables corerspondientes del scaffoldState para crear el cajón y abrirlo
//Scaffold me permite agregar una barra de navegación. Debo crear una función llamada TopAppBar
//en un nuevo archivo llamado TopAppBar.kt en el mismo paquete com.example.littlelemonlogin
//es decir donde se ubica mi MainActivity.kt, y en ese archivo creo el componible TopAppBar y
//creo todos los elementos que tendrá el TopAppBar.
@Composable
fun ScaffoldDrawer(navController: NavHostController, content: @Composable (PaddingValues) -> Unit) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { DrawerPanel(scaffoldState = scaffoldState, scope = scope) },
        topBar = { TopAppBar(scaffoldState = scaffoldState, scope = scope) }
    ) { paddingValues ->content(paddingValues) // Muestra el contenido dentro del Scaffold
    }
}





