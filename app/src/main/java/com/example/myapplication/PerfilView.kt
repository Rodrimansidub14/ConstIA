package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Mostrar correo del usuario
            Text(text = "Correo: $correo", style = MaterialTheme.typography.headlineMedium)

            // Mostrar peso del usuario
            Text(text = "Peso: $peso kg", style = MaterialTheme.typography.headlineMedium)

            // Mostrar altura del usuario
            Text(text = "Altura: $altura m", style = MaterialTheme.typography.headlineMedium)

            // Mostrar IMC del usuario
            Text(text = "IMC: $imc", style = MaterialTheme.typography.headlineMedium)

            // Mostrar mensaje basado en el IMC
            // Mostrar mensaje basado en el IMC
            when {
                imc < 18f -> Text(text = "Bajo peso", style = MaterialTheme.typography.headlineMedium)
                imc in 18f..24.9f -> Text(text = "Peso normal", style = MaterialTheme.typography.headlineMedium)
                imc in 25f..29.9f -> Text(text = "Sobrepeso", style = MaterialTheme.typography.headlineMedium)
                imc >= 30f -> Text(text = "Obesidad", style = MaterialTheme.typography.headlineMedium)
                else -> Text(text = "Valor de IMC no válido", style = MaterialTheme.typography.headlineMedium)
            }

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
