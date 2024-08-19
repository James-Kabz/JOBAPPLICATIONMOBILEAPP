package com.example.jobapplicationmobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.navigation.NavHostController
import com.example.jobapplicationmobileapp.ui.theme.JOBAPPLICATIONMOBILEAPPTheme
import com.example.jobapplicationmobileapp.utilis.SharedViewModel
import androidx.compose.material3.Surface
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.jobapplicationmobileapp.nav.NavGraph
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var navController:NavHostController
    private  val sharedViewModel:SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        FirebaseApp.initializeApp(this)
        enableEdgeToEdge()
        setContent {
            JOBAPPLICATIONMOBILEAPPTheme {
                LoginScreen()
//                Card(
//                    modifier = Modifier.fillMaxSize(),
//                    colors = CardDefaults.cardColors(containerColor = Color.White),
////                    color = MaterialTheme.colors.background
//                ) {
//                    navController = rememberNavController()
//
//                    NavGraph(navController = navController, sharedViewModel = sharedViewModel)
//
//
//                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JOBAPPLICATIONMOBILEAPPTheme {
        LoginScreen()
    }
}