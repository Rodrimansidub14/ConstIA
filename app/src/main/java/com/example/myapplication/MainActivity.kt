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
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.res.colorResource

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
        val imageResId = R.drawable.logofin

        val backgroundColor = colorResource(id = R.color.backgroundcolorviews)
        val secundaryColor = colorResource(id = R.color.secundary)
        val principalColor = colorResource(id = R.color.principal)

        val text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = secundaryColor)) {
                append("Const")
            }
            withStyle(style = SpanStyle(color = principalColor)) {
                append("IA")
            }
        }

        Surface(color = backgroundColor, modifier = Modifier.fillMaxSize()){

        // Columna principal para la vista de inicio
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween // Cambio aquí para distribuir espacio entre elementos
        ) {
            // Mostrar la imagen del logo
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(350.dp)
                    .padding(8.dp)
            )

            // Texto "ConstIA" con estilo grande
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 40.sp, // tamaño grande para el texto
                    fontWeight = FontWeight.Bold // estilo en molde
                ),
                modifier = Modifier.padding(8.dp)
            )

            // Botón para empezar
            Button(
                onClick = {
                    // Crear un Intent para iniciar la nueva actividad
                    val intent = Intent(context, LoginActivity::class.java)

                    // Iniciar la nueva actividad
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 18.dp)
            ) {
                Text(text = "GET STARTED")
            }
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

