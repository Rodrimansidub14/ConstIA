// Main activity for the login screen
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginView() {
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginView(onLoginClick: () -> Unit) {
        val context = LocalContext.current
        val imageResId = R.drawable.logoconstia

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
                    .size(350.dp)
                    .padding(8.dp)
            )

            // Texto que muestra "Iniciar sesión" con estilo de tipografía de MaterialTheme
            Text(
                text = "Iniciar sesión",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Campo de texto para el correo electrónico y contrasena llamando funciones
            TextEntryEmail()
            TextEntryPassword()

            // Botón para iniciar sesión
            Button(
                onClick = {
                    // Crear un Intent para iniciar la nueva actividad
                    val intent = Intent(context, HomeScreenActivity::class.java)

                    // Iniciar la nueva actividad
                    context.startActivity(intent)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Iniciar sesión")
            }
        }
    }

    /**
     * Campo de texto para el correo electrónico
     */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TextEntryEmail() {
        var textValue by remember { mutableStateOf(TextFieldValue()) }

        OutlinedTextField(
            value = textValue,
            onValueChange = {
                textValue = it
            },
            placeholder = { Text("Correo electronico:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(60.dp)
        )
    }

    /**
     * Campo de texto para la contraseña
     */
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TextEntryPassword() {
        var textValue by remember { mutableStateOf(TextFieldValue()) }

        OutlinedTextField(
            value = textValue,
            onValueChange = {
                textValue = it
            },
            placeholder = { Text("Contraseña:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(60.dp)
        )
    }
    @Preview
    @Composable
    fun LoginViewPreview() {
        MyApplicationTheme {
            Surface {
                // Vista previa de LoginView
                LoginView(
                    onLoginClick = { /* Manejar clic en inicio de sesión */ }
                )
            }
        }
    }
}