// Main activity for the sign up screen
package com.example.myapplication
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpView() {

            }
        }
    }
}