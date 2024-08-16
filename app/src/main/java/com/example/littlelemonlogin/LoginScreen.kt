package com.example.littlelemonlogin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
//Pasamos los parámetros del navController para poder navegar entre pantallas
fun LoginScreen(navController: NavHostController){
    //LocalContext me permite mostrar un mensaje en pantalla
    val context = LocalContext.current

    val TextFieldValueSaver = Saver<TextFieldValue, String>(
        save = { it.text },
        restore = { TextFieldValue(text = it) }
    )
    //Hacer que los campos de texto acepten y muestren la entrada
    /*Nota: TextFieldValue no se puede guardar directamente usando rememberSaveable con la
    configuración predeterminada. Esto se debe a que TextFieldValue no es un tipo de dato primitivo
    ni una clase serializable que pueda ser almacenada en un Bundle. Para solucionar este problema,
    necesitas proporcionar un Saver personalizado para TextFieldValue al usar rememberSaveable.
    Aquí te muestro cómo hacerlo:*/
    var username by rememberSaveable(stateSaver = TextFieldValueSaver) {
        mutableStateOf(TextFieldValue(""))
    }
    var password by rememberSaveable(stateSaver = TextFieldValueSaver) {
        mutableStateOf(TextFieldValue(""))
    }

    //ScrollState me permite hacer scroll en la pantalla
    val scrollState = rememberScrollState()
    Column(
            /*Modifier se usa para dar una forma a un elemento también para añadir acciones como
            por ejemplo a un botón, un campo de texto y en general a un componible que no admite
            una acción por defecto.*/
            modifier = Modifier
                //.padding(10.dp)
                .size(1000.dp)
                //.height(500.dp)
                .background(Color(0xFF495E57))
                //scrollState me permite hacer scroll en la pantalla
                .verticalScroll(scrollState)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 30.dp)
                    .clip(RoundedCornerShape(5.dp)),
                painter = painterResource(
                    id = R.drawable.littlelemonlogo),
                contentDescription = "Logo Image"
            )
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") },
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp)
            )
            TextField(
                value =password,
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp)
            )
            Button(
                //Puedo manejar un evento de click con onClick con la acción Toast.makeText por ejemplo:
                onClick = {
                    if(username.text == ""
                        && password.text==""
                    ){navController.navigate(Home.route)
                        Toast.makeText(context,
                            "Welcome to Little Lemon!",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(context,
                            "Invalid credentials."
                                    + "Please try again.",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFF4CE14)
                ),
                modifier = Modifier.padding(10.dp,0.dp,0.dp,10.dp)
            ) {
                Text(
                    text = "Login",
                    color = Color(0xFF000000)
                )
            }
            Text(
                //Puedo agregar una acción de click a un texto con Modifier.clickable:
                modifier = Modifier
                    .clickable(onClick = {
                        Toast
                            .makeText(context, "Register", Toast.LENGTH_LONG)
                            .show()
                    })
                    .padding(0.dp, 0.dp, 0.dp, 10.dp),
                text = "Do not have an account? Register HERE",
                color = Color(0xFFFFFFFF),
                fontSize = 12.sp
            )
            Text(
                //Puedo agregar una acción de click a un texto con Modifier.clickable:
                modifier = Modifier
                    .clickable(onClick = {
                        Toast
                            .makeText(context, "Forgot password?", Toast.LENGTH_LONG)
                            .show()
                    })
                    .padding(0.dp, 0.dp, 0.dp, 10.dp),
                text = "You don't remember your password?",
                color = Color(0xFFFFFFFF),
                fontSize = 12.sp
            )
        }

}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen(navController = rememberNavController())
}