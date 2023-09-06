// MainActivity.kt
package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.TextStyle

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          GetStartedView(onLoginClick = {  }) {
          }
        }
    }

    @Composable
    fun GetStartedView(onLoginClick: () -> Unit, onSignUpClick: () -> Unit) {
        // Obtener el contexto local
        val context = LocalContext.current
        // Identificador de recurso para la imagen del logo
        val imageResId = R.drawable.logoconstia

        // Columna principal para la vista de inicio
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Mostrar la imagen del logo
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(500.dp)
                    .padding(8.dp)
            )

            // Texto que muestra "Empecemos" con estilo de tipografía de MaterialTheme
            val customTextStyle = TextStyle(
                fontSize = 38.sp,
            )

            // uSA EL ESTILO CUSTOMIZADO
            Text(
                text = "Empecemos",
                style = customTextStyle,
                modifier = Modifier.padding(vertical = 50.dp)
            )

            // Botón para iniciar sesión
            Button(
                onClick = {
                    // Crear un Intent para iniciar la nueva actividad
                    val intent = Intent(context, LoginActivity::class.java)

                    // Iniciar la nueva actividad
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Text(text = "Log In")
            }


            // Botón para registrarse
            Button(
                onClick = {
                    // Crear un Intent para iniciar la nueva actividad
                    val intent = Intent(context, RegisterActivity::class.java)

                    // Iniciar la nueva actividad
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Text(text = "Sign Up")
            }
        }
    }


    @Preview
    @Composable
    fun GetStartedViewPreview() {

        MyApplicationTheme {
            Surface {
                GetStartedView(
                    onLoginClick = { /* manejo login click */ },
                    onSignUpClick = { /* manejo sign up click */ })
            }
        }
    }
}

