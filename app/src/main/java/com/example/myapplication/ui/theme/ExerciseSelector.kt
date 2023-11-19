package com.example.myapplication.ui.theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.rememberPermissionState
import android.Manifest
import androidx.compose.material3.Button
import androidx.compose.material3.Text



// Define the Exercise data class
data class Exercise(
    val id: Int,
    val name: String,
    val isOutdoor: Boolean
)

// Create a list of exercises
val exercises = listOf(
    Exercise(id = 1, name = "Running", isOutdoor = true),
    Exercise(id = 2, name = "Cycling", isOutdoor = true)
    // Add more exercises as needed
)

@Composable
fun FitnessTrackingScreen() {
    val context = LocalContext.current
    // State to hold the selected exercise
    var selectedExercise by remember { mutableStateOf<Exercise?>(null) }

    // GPS Permission State
    val gpsPermissionState = rememberPermissionState(permission = Manifest.permission.ACCESS_FINE_LOCATION)

    // GPS Tracking function (dummy implementation for illustration)
    val startGpsTracking = {
        // Check permission before starting GPS tracking
        if (gpsPermissionState.hasPermission) {
            // Start GPS tracking logic here
        } else {
            // Request permission if not already granted
            gpsPermissionState.launchPermissionRequest()
        }
    }

    Column {
        LazyColumn {
            items(exercises) { exercise ->
                Button(
                    onClick = { selectedExercise = exercise }
                ) {
                    Text(exercise.name)
                }
            }
        }

        // When an exercise is selected
        selectedExercise?.let { exercise ->
            Text("Selected Exercise: ${exercise.name}")
            Button(
                onClick = {
                    // Log the exercise or start GPS tracking
                    if (exercise.isOutdoor) {
                        startGpsTracking()
                    } else {
                        // Log indoor exercise
                    }
                }
            ) {
                Text(if (exercise.isOutdoor) "Start GPS Tracking" else "Log Exercise")
            }
        }
    }
}
}