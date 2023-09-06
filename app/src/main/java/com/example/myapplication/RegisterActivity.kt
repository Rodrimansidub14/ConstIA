// Main activity for the sign up screen
package com.example.myapplication
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme


class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpView() {

            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SignUpView(onSignUpClick: () -> Unit) {
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
            // Texto que muestra "Registrarse" con estilo de tipografía de MaterialTheme
            Text(
                text = "Registrarse",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            // Campo de texto para el nombre de usuario
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Nombre de usuario") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )
            // Campo de texto para el correo electrónico
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Correo electrónico") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            // Campo de texto para la contraseña
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text(text = "Contraseña") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Botón para registrarse
            Button(
                onClick = { onSignUpClick() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Registrarse")
            }
        }
    }

    @Preview
    @Composable
    fun SignUpViewPreview() {
        MyApplicationTheme {
            Surface {
                // Vista previa de SignUpView
                SignUpView(
                    onSignUpClick = { /* Manejar clic en registro */ }
                )
            }
        }
    }
}