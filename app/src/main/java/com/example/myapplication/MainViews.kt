package com.example.myapplication

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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


@Composable
fun HeaderView() {
    // Obtener el contexto local
    val context = LocalContext.current
    // Identificador de recurso para la imagen del logo
    val imageResId = R.drawable.logoconstia

    // Columna principal para la vista de encabezado
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(R.color.paynes_gray))
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
        // Aplicar el estilo de MaterialTheme a un texto que muestra "ConstIA Logo"
        MaterialTheme {
            Text(text = "ConstIA Logo", style = MaterialTheme.typography.headlineLarge)
        }
    }
}

@Preview
@Composable
fun PreviewHeaderView(){
    // Vista previa de HeaderView
    HeaderView()
}

/**
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
        Text(
            text = "Empecemos",
            style = MaterialTheme.typography.labelLarge,
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
                .size(450.dp)
                .padding(8.dp)
        )

        // Texto que muestra "Iniciar sesión" con estilo de tipografía de MaterialTheme
        Text(
            text = "Iniciar sesión",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(vertical = 16.dp)
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

        // Campo de texto para el nombre de usuario
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text(text = "Nombre de usuario") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Botón para iniciar sesión
        Button(
            onClick = { onLoginClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Iniciar sesión")
        }
    }
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

**/

@Composable
fun HomeScreen() {
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
                .size(200.dp)
                .padding(8.dp)
        )
        // Texto que pregunta "¿Qué necesitas hoy?" con estilo de tipografía de MaterialTheme
        Text(
            text = "¿Qué necesitas hoy?",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Botones para diferentes opciones
        Button(
            onClick = { /* Lógica para registrar comida */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(bottom = 8.dp)
        ) {
            Text(text = "Registrar Comida")
        }

        Button(
            onClick = { /* Lógica para chequeo emocional */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(bottom = 8.dp)
        ) {
            Text(text = "Chequeo Emocional")
        }

        Button(
            onClick = { /* Lógica para monitoreo de sueño */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(bottom = 8.dp)
        ) {
            Text(text = "Monitoreo de sueño")
        }

        Button(
            onClick = { /* Lógica para registro de actividad */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(bottom = 8.dp)
        ) {
            Text(text = "Registro de Actividad")
        }

        Button(
            onClick = { /* Lógica para chat */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(bottom = 8.dp)
        ) {
            Text(text = "Chat")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MyApplicationTheme {
        Surface {
            // Vista previa de HomeScreen
            HomeScreen()
        }
    }
}


@Composable
fun FoodTracker() {
    val context = LocalContext.current
    val imageResId = R.drawable.logoconstia

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
                    .clickable {

                    }
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Text(
                    text = "Registra tus comidas",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                FoodMealSection(mealName = "Desayuno")
                FoodMealSection(mealName = "Almuerzo")
                FoodMealSection(mealName = "Cena")
                FoodMealSection(mealName = "Snacks")
            }
        }
    }
}

@Composable
fun FoodMealSection(mealName: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp)
    ) {
        Text(
            text = mealName,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        FoodEntryList()

        Button(
            onClick = { /* Lógica para agregar alimento */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Agregar alimento")
        }
    }
}

@Composable
fun FoodEntryList() {
    LazyColumn {
        // Aquí puedes agregar elementos representando cada entrada de alimento
        // Cada elemento podría contener el nombre del alimento, cantidad, etc.
        // Ejemplo:
        item {
            Text(text = "Alimento 1")
        }
        item {
            Text(text = "Alimento 2")
        }
        // Agrega más elementos según sea necesario
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SleepTracker() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Registro de Sueño",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(text = "Registrar Sueño")
            }

            // Resumen de Sueño
            Text(
                text = "Resumen de Sueño",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(vertical = 30.dp)
            )
            // TODO: Mostrar detalles del resumen de sueño

            Spacer(modifier = Modifier.height(16.dp))

            // Registro de Sueño Anterior
            Text(
                text = "Registro de Sueño Anterior",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(vertical = 30.dp)
            )
            // TODO: Mostrar elementos del registro de sueño de días anteriores

            Spacer(modifier = Modifier.height(16.dp))

            // Gráficos de Sueño
            Text(
                text = "Gráficos de Sueño",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(vertical = 30.dp)
            )
            // TODO: Mostrar gráficos de sueño usando una biblioteca de gráficos o Compose graphics

            Spacer(modifier = Modifier.height(8.dp))

            // Recomendaciones de Sueño
            Text(
                text = "Recomendaciones de Sueño",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(vertical = 30.dp)
            )
            // TODO: Mostrar recomendaciones relacionadas con el sueño
        }

        // Logotipo en la parte inferior
        Image(
            painter = painterResource(id = R.drawable.logoconstia),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clickable { /* Manejar clic en el logotipo si es necesario */ }
        )
    }
}

@Preview
@Composable
fun SleepTrackerPreview() {
    MyApplicationTheme {
        Surface {
            // Vista previa de SleepTracker
            SleepTracker()
        }
    }
}

@Composable
fun MoodTracker() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Botón de registro de estado de ánimo
        Button(
            onClick = { /* Manejar el registro de estado de ánimo */ },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Registrar Estado de Ánimo")
        }

        MoodSection(title = "Resumen de Estado de Ánimo") {
            // TODO: Mostrar detalles del resumen de estado de ánimo
        }

        MoodSection(title = "Registro de Estado de Ánimo Anterior") {
            // TODO: Mostrar elementos del registro de estado de ánimo de días anteriores
        }

        MoodSection(title = "Gráficos de Estado de Ánimo") {
            // TODO: Mostrar gráficos de estado de ánimo utilizando una biblioteca de gráficos o Compose graphics
        }

        MoodSection(title = "Recomendaciones de Estado de Ánimo") {
            // TODO: Mostrar recomendaciones relacionadas con el estado de ánimo
        }

        Spacer(modifier = Modifier.weight(1f)) // Empuja el logotipo hacia la parte inferior

        // Logotipo en la parte inferior
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

@Composable
fun MoodSection(title: String, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        content()
    }
}

@Composable
fun ActivityTracker() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Botón de registro de actividad
        Button(
            onClick = { /* Manejar el registro de actividad */ },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Registrar Actividad")
        }

        ActivitySection(title = "Resumen de Actividades") {
            // TODO: Mostrar detalles del resumen de actividades
        }

        ActivitySection(title = "Registro de Actividades Anteriores") {
            // TODO: Mostrar elementos del registro de actividades de días anteriores
        }

        ActivitySection(title = "Recomendaciones de Actividades") {
            // TODO: Mostrar recomendaciones relacionadas con las actividades
        }

        Spacer(modifier = Modifier.weight(1f)) // Empuja el logotipo hacia la parte inferior

        // Logotipo en la parte inferior
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

@Composable
fun ActivitySection(title: String, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        content()
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
        OutlinedTextField(
            value = "",
            onValueChange = {
            },
            placeholder = { Text("Escribe tu mensaje aquí") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp) // Aumenta el espacio vertical
                .height(300.dp) // Establece la altura deseada
        )

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

/**
@Composable
fun App() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        HeaderView()
        GetStartedView(
            onLoginClick = { /* Manejar clic en iniciar sesión */ },
            onSignUpClick = { /* Manejar clic en registrarse */ }
        )
        LoginView(onLoginClick = { /* Manejar clic en iniciar sesión */ })
        SignUpView(onSignUpClick = { /* Manejar clic en registrarse */ })
        HomeScreen()
        FoodTracker()
        SleepTracker()
        MoodTracker()
        ActivityTracker()
        ChatScreen()
    }
}

**/




