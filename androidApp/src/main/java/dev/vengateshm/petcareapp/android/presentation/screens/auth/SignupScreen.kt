package dev.vengateshm.petcareapp.android.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vengateshm.petcareapp.android.presentation.screens.composables.ActionButtonPrimary
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignupScreen(
    viewModel: SignupViewModel = koinViewModel(),
    onSignedUp: () -> Unit,
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val uiState = viewModel.uiState

    val currentSignedUp by rememberUpdatedState(newValue = onSignedUp)

    LaunchedEffect(key1 = uiState) {
        if (uiState.isSignedUp) {
            currentSignedUp()
        }
    }

    SignupScreenContent(
        uiState = { uiState },
        name = { name },
        email = { email },
        password = { password },
        onNameChanged = {
            name = it
        },
        onEmailChanged = {
            email = it
        },
        onPasswordChanged = {
            password = it
        },
        onSignupClicked = {
            viewModel.signup(name, email, password)
        })
}

@Composable
fun SignupScreenContent(
    uiState: () -> SignupUiState,
    name: () -> String,
    email: () -> String,
    password: () -> String,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSignupClicked: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF9FAFB))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.35f)
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color(0xFF4592E8), Color(0xFF4552CB)
                        )
                    )
                )
        )
        Column(
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.10f)
            )
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "Arrow back icon",
                tint = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                fontSize = 32.sp,
                text = "Registration",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                shape = RoundedCornerShape(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 16.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent
                    ),
                    placeholder = { Text(text = "Full name") },
                    value = name(),
                    onValueChange = onNameChanged,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Person,
                            contentDescription = "Full name icon"
                        )
                    },
                    isError = uiState().isNameError
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent
                    ),
                    placeholder = { Text(text = "Email") },
                    value = email(),
                    onValueChange = onEmailChanged,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Email, contentDescription = "Email icon"
                        )
                    },
                    isError = uiState().isEmailError
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        errorContainerColor = Color.Transparent
                    ),
                    placeholder = { Text(text = "Password") },
                    value = password(),
                    onValueChange = onPasswordChanged,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Password,
                            contentDescription = "Password icon"
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    isError = uiState().isPasswordError
                )
                Spacer(modifier = Modifier.height(16.dp))
                ActionButtonPrimary(
                    onClick = { onSignupClicked() },
                    buttonText = { "Sign Up" }
                )
            }
        }
    }
}

@Preview
@Composable
fun SignupScreenPreview() {
    SignupScreenContent(
        uiState = { SignupUiState() },
        name = { "" },
        email = { "" },
        password = { "" },
        onNameChanged = {},
        onEmailChanged = {},
        onPasswordChanged = {},
        onSignupClicked = {}
    )
}