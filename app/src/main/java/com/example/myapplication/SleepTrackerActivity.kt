package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme


class SleepTrackerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SleepTracker()
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
}