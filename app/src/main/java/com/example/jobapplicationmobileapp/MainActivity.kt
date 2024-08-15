package com.example.jobapplicationmobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jobapplicationmobileapp.screens.LoginScreen
import com.example.jobapplicationmobileapp.ui.theme.JOBAPPLICATIONMOBILEAPPTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        enableEdgeToEdge()
        setContent {
            JOBAPPLICATIONMOBILEAPPTheme {
                LoginScreen()
            }
        }
    }
}

@Composable

@Preview(showBackground = true)
fun GreetingPreview() {
    JOBAPPLICATIONMOBILEAPPTheme {
    }
}