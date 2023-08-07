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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.Alignment
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
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onLoggedIn: () -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val uiState = viewModel.uiState

    val currentLoggedIn by rememberUpdatedState(newValue = onLoggedIn)

    LaunchedEffect(key1 = uiState) {
        if (uiState.isLoggedIn) {
            currentLoggedIn()
        }
    }

    LoginScreenContent(
        uiState = { uiState },
        email = { email },
        password = { password },
        onEmailChanged = {
            email = it
        },
        onPasswordChanged = {
            password = it
        },
        onSignInClicked = {
            viewModel.login(email, password)
        }
    )
}

@Composable
fun LoginScreenContent(
    uiState: () -> LoginUiState,
    email: () -> String,
    password: () -> String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSignInClicked: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF9FAFB))
    ) {
        if (uiState().isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.BottomCenter))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.35f)
                .background(
                    brush = Brush.linearGradient(
                        listOf(
                            Color(0xFF4592E8),
                            Color(0xFF4552CB)
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
                text = "Sign In",
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
                    placeholder = { Text(text = "Email") },
                    value = email(),
                    onValueChange = onEmailChanged,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Email,
                            contentDescription = "Email icon"
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
                            contentDescription = "Email icon"
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    isError = uiState().isPasswordError
                )
                Spacer(modifier = Modifier.height(16.dp))
                ActionButtonPrimary(
                    onClick = { onSignInClicked() },
                    buttonText = { "Sign In" })
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreenContent(
        uiState = { LoginUiState() },
        email = { "" },
        password = { "" },
        onEmailChanged = {},
        onPasswordChanged = {},
        onSignInClicked = {}
    )
}