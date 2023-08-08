package dev.vengateshm.petcareapp.android.presentation.screens.auth

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.DisposableEffect
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import dev.vengateshm.petcareapp.android.R
import dev.vengateshm.petcareapp.android.presentation.screens.composables.ActionButtonPrimary
import dev.vengateshm.petcareapp.android.presentation.screens.composables.GoogleSignInManager
import dev.vengateshm.petcareapp.android.presentation.screens.composables.rememberGoogleSignInManagerState
import dev.vengateshm.petcareapp.android.ui.theme.Button1
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onLoggedIn: () -> Unit,
    onSignUpClicked: () -> Unit,
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

    var isGoogleSignInProgress by remember { mutableStateOf(false) }

    val activity = LocalContext.current as Activity
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_RESUME -> {
                    isGoogleSignInProgress = false
                }

                else -> Log.i("OBSERVER", "Lifecycle: ${event.name}")
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    val signInManagerState = rememberGoogleSignInManagerState()
    GoogleSignInManager(
        state = signInManagerState,
        onComplete = {
            isGoogleSignInProgress = false
        },
        onIdToken = { idToken ->
            viewModel.signinWithGoogle(idToken)
        }
    )

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
        },
        onGoogleSignInClicked = {
            isGoogleSignInProgress = true
            signInManagerState.startSignIn = true
        },
        onSignUpClicked = {
            onSignUpClicked()
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
    onGoogleSignInClicked: () -> Unit,
    onSignUpClicked: () -> Unit,
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
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "or continue with",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .size(48.dp)
                        .clickable { },
                    painter = painterResource(id = R.drawable.fb_signin),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    modifier = Modifier
                        .size(48.dp)
                        .clickable {
                            onGoogleSignInClicked()
                        },
                    painter = painterResource(id = R.drawable.google_signin),
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.weight(weight = 1f))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onSignUpClicked()
                    }
                    .padding(vertical = 16.dp),
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append("Don't have an account yet?")
                    }
                    withStyle(style = SpanStyle(color = Button1)) {
                        append("Registration")
                    }
                },
                textAlign = TextAlign.Center,
            )
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
        onSignInClicked = {},
        onGoogleSignInClicked = {},
        onSignUpClicked = {}
    )
}