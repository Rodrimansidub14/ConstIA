package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.annotation.DrawableRes
import androidx.compose.ui.platform.LocalContext
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

@OptIn(ExperimentalMaterial3Api::class)
class PerfilView : ComponentActivity() {
    private var correo by mutableStateOf("")
    private var peso by mutableStateOf("")
    private var altura by mutableStateOf("")
    private var imc by mutableStateOf(0f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchUserData()

        setContent {
            PerfilScreen()
        }
    }

    @Composable
    fun PerfilScreen() {
        val context = LocalContext.current
        val imageResId = R.drawable.logoconstia

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // Texto con Tipografia
            Text(
                text = "PERFIL DEL USUARIO",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .padding(8.dp)
            )
            // Parte superior: Imagen y correo
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Imagen de perfil basada en IMC
                Image(
                    painter = painterResource(id = getProfileImageBasedOnIMC(imc)),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier.size(200.dp)
                )

                // Correo del usuario
                Text(text = correo, style = MaterialTheme.typography.headlineMedium)
            }

            Spacer(modifier = Modifier.height(16.dp))
            // Datos del usuario
            Text(text = "Peso: $peso kg", style = MaterialTheme.typography.headlineMedium)
            Text(text = "Altura: $altura m", style = MaterialTheme.typography.headlineMedium)
            Text(text = "IMC: $imc", style = MaterialTheme.typography.headlineMedium)

            // Mensaje basado en el IMC
            when {
                imc < 18f -> Text(text = "Te encuentras en: Bajo peso", style = MaterialTheme.typography.headlineMedium)
                imc in 18f..24.9f -> Text(text = "Te encuentras en: Peso normal", style = MaterialTheme.typography.headlineMedium)
                imc in 25f..29.9f -> Text(text = "Te encuentras en: Sobrepeso", style = MaterialTheme.typography.headlineMedium)
                imc >= 30f -> Text(text = "Te encuentras en: Obesidad", style = MaterialTheme.typography.headlineMedium)
                else -> Text(text = "Valor de IMC no válido", style = MaterialTheme.typography.headlineMedium)
            }

            Button(
                onClick = {
                    // Crear un Intent para iniciar la nueva actividad
                    val intent = Intent(context, NutritionScreenActivity::class.java)

                    // Iniciar la nueva actividad
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 50.dp)
            ) {
                Text(text = "REGRESAR")
            }
        }
    }

    // Función para obtener la imagen de perfil basada en el IMC
    @DrawableRes
    fun getProfileImageBasedOnIMC(imc: Float): Int {
        return when {
            imc < 18f -> R.drawable.imagen_delgada
            imc >= 30f -> R.drawable.imagen_obesa
            else -> R.drawable.imagen_normal
        }
    }

    private fun fetchUserData() {
        val user = FirebaseAuth.getInstance().currentUser
        user?.let {
            val userId = user.uid
            val database = FirebaseDatabase.getInstance().getReference("users/$userId")

            database.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    correo = user.email ?: "No disponible"
                    peso = dataSnapshot.child("peso").value?.toString() ?: "0"
                    altura = dataSnapshot.child("altura").value?.toString() ?: "0"
                    imc = dataSnapshot.child("imc").value?.toString()?.toFloatOrNull() ?: 0f
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Error al recuperar datos
                }
            })
        }
    }

    @Preview
    @Composable
    fun PerfilScreenPreview() {
        MyApplicationTheme {
            PerfilScreen()
        }
    }
}

