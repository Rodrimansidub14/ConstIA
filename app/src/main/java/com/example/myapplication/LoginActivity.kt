package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                LoginView()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LoginView() {
        val context = LocalContext.current
        val imageResId = R.drawable.logofin
        val backgroundColor = colorResource(id = R.color.backgroundcolorviews)
        val secundaryColor = colorResource(id = R.color.secundary)
        val principalColor = colorResource(id = R.color.principal)

        Surface(color = backgroundColor, modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = secundaryColor)) {
                        append("Iniciar")
                    }
                    withStyle(style = SpanStyle(color = principalColor)) {
                        append("Sesion")
                    }
                }

                Text(
                    text = text,
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(8.dp)
                )
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .padding(top = 24.dp, bottom = 16.dp)
                )

                TextEntry("Correo Electrónico")
                TextEntry("Contraseña", true)

                Button(
                    onClick = {
                        // Aquí irá la lógica para el inicio de sesión
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 24.dp)
                ) {
                    Text(text = "Iniciar Sesión")
                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("¿Aún no tienes una cuenta?")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Regístrate",
                        color = principalColor,
                        modifier = Modifier.clickable {
                            val intent = Intent(context, RegisterActivity::class.java)
                            context.startActivity(intent)
                        }
                    )
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TextEntry(hint: String, password: Boolean = false) {
        var textValue by remember { mutableStateOf(TextFieldValue()) }

        OutlinedTextField(
            value = textValue,
            onValueChange = {
                textValue = it
            },
            placeholder = { Text(hint) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .height(60.dp),
            visualTransformation = if (password) PasswordVisualTransformation() else VisualTransformation.None
        )
    }

    @Preview
    @Composable
    fun LoginViewPreview() {
        MyApplicationTheme {
            Surface {
                LoginView()
            }
        }
    }
}
