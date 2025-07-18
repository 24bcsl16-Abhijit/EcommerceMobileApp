package com.example.ecom_assignment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ecom_assignment.ui.theme.PrimaryPurple
import com.example.ecom_assignment.ui.theme.TextBlack
import com.google.firebase.auth.FirebaseAuth


@Composable
fun ForgotPasswordScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp) // Consistent horizontal padding
            .padding(top = 56.dp), // Consistent top padding
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            "Forgot Password",
            style = MaterialTheme.typography.headlineLarge // Apply headlineLarge style
        )

        Spacer(modifier = Modifier.height(32.dp)) // Spacing after title

        InputField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Enter Email Address",
            isPassword = false
        )

        Spacer(modifier = Modifier.height(24.dp)) // Spacing before button

        Button(
            onClick = {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnSuccessListener {
                        navController.navigate("home")
                    }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple) // Use themed primary color
        ) {
            Text("Continue", style = MaterialTheme.typography.titleLarge) // Apply titleLarge style
        }

        Spacer(modifier = Modifier.height(16.dp)) // Spacing before "Back to Sign In"

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center, // Center the row
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Back to Sign In",
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold, color = TextBlack), // Apply bodySmall, bold, black
                modifier = Modifier.clickable {
                    navController.navigate(Screen.Login.route)
                }
            )
        }
    }
}