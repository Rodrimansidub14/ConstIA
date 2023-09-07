package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

class ChatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatScreen()
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ChatScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título
            Text(
                text = "Chat",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Mostrar mensajes anteriores
            TextBubble("Hola")
            TextBubble("Busco recomendaciones.")
            TextBubble("¿Qué recomendaciones buscas?")

            // Espacio para escribir texto

            TextEntryView()


            Spacer(modifier = Modifier.weight(1f)) // Empuja el contenido hacia arriba
            // Botón de enviar

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .background(color = Color(0xEDAE49))

            ) {
                Text(text = "Enviar")
            }

            Image(
                painter = painterResource(id = R.drawable.logoconstia),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clickable { /* Manejar clic en el logotipo si es necesario */ }
                    .padding(start = 16.dp, bottom = 16.dp)
            )
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TextEntryView() {
        var textValue by remember { mutableStateOf(TextFieldValue()) }

        OutlinedTextField(
            value = textValue,
            onValueChange = {
                textValue = it
            },
            placeholder = { Text("Escribe tu mensaje aquí") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(300.dp)
        )
    }
    @Composable
    fun TextBubble(message: String) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(Color.LightGray)
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    @Preview
    @Composable
    fun ChatScreenPreview() {
        MyApplicationTheme {
            Surface {
                ChatScreen()
            }
        }
    }

}