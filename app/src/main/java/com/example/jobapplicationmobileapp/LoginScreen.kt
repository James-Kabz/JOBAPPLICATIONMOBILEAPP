package com.example.jobapplicationmobileapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


private lateinit var auth: FirebaseAuth
@Composable

fun LoginScreen ()
{
    auth = FirebaseAuth.getInstance()
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("") }
//    var showError by remember { mutableStateOf(false) }
    var showError by remember { mutableStateOf<String?>(null) }
    var successMessage by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
            .padding( 20.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Card(
            modifier =  Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(20.dp)
        )
        {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {

                TextButton(onClick = { /*TODO*/ }) {
                    Text("Create Account" , color = Color.Black)
                }


                Spacer(modifier = Modifier.height(16.dp))

//                person logo
                Image(painter = painterResource(id = R.drawable.baseline_person_24),
                    contentDescription = "Person Logo",
                    modifier = Modifier.size(100.dp)
                    )
                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = { email =it },
                    label =  { Text("Email",color = Color.Black)},
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Email),

                    )
                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = {password = it},
                    label = { Text("password", color = Color.Black)},
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation =  PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                )

                Spacer(modifier = Modifier.height(8.dp))

                TextButton(onClick = { /*TODO*/ } ,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Forgot Password" , color = Color.Black)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { signUp(email, password, { user -> successMessage = "Welcome ${user?.email}" }, { error -> showError = error }) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Sign Up")
                }

                Spacer(modifier = Modifier.height(16.dp))


                showError?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }


                if (successMessage.isNotEmpty())
                {
                    Text(
                        text = successMessage,
                        color = Color.Green,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }
}

private fun signUp(email: String, password: String, onSuccess: (FirebaseUser?) -> Unit, onFailure: (String) -> Unit) {
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess(auth.currentUser)
            } else {
                onFailure(task.exception?.message ?: "Sign up failed")
            }
        }
}