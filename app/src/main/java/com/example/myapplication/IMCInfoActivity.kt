package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class IMCInfoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                IMCInfoScreen()
            }
        }
    }

    @Composable
    fun IMCInfoScreen() {
        val context = LocalContext.current

        val backgroundColor = colorResource(id = R.color.backgroundcolorviews)
        val secundaryColor = colorResource(id = R.color.secundary)
        val principalColor = colorResource(id = R.color.principal)
        val imageResId = R.drawable.logoconstia

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(backgroundColor), // Set the background color of the column
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "INFORMACION IMC",
                style = MaterialTheme.typography.headlineMedium.copy(color = principalColor), // Set the color of the headline
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(8.dp)

            )

            Spacer(modifier = Modifier.height(16.dp))

            val imcData = listOf(
                Triple("Menos de 18.5", "Bajo peso", "Sería recomendable acudir a un nutricionista."),
                Triple("18.5 - 24.9", "Normal", "Mantén una dieta equilibrada."),
                Triple("25 - 29.9", "Sobrepeso", "Considera hacer más ejercicio."),
                Triple("30 o más", "Obesidad", "Consulta a un especialista.")
            )

            imcData.forEach { data ->
                Text(text = data.first, color = secundaryColor) // Set the color of the text
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "${data.second}, ${data.third}", color = principalColor) // Set the color of the text
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    @Preview
    @Composable
    fun IMCInfoScreenPreview() {
        MyApplicationTheme {
            IMCInfoScreen()
        }
    }
}



