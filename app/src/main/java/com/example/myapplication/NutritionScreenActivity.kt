package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class NutritionScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutritionScreen()
        }
    }

    @Composable
    fun NutritionScreen() {
        val context = LocalContext.current
        val imageResId = R.drawable.logoconstia

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Texto con Tipografia
            Text(
                text = "NUTRICION",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(8.dp)
            )

            // Botón para Calculador de IMC
            Button(
                onClick = {
                    // Crear un Intent para iniciar la nueva actividad
                    val intent = Intent(context, IMCActivity::class.java)

                    // Iniciar la nueva actividad
                    context.startActivity(intent)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(bottom = 8.dp)
            ) {
                Text(text = "Calculador de IMC")
            }

            // Botón para Valores nutricionales
            Button(
                onClick = {
                    val intent = Intent(context, FoodSearchActivity::class.java)
                    startActivity(intent) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(bottom = 8.dp)
            ) {
                Text(text = "Valores nutricionales")
            }



        }
    }

    @Preview
    @Composable
    fun NutritionScreenPreview() {
        MyApplicationTheme {
            NutritionScreen()
        }
    }
}
