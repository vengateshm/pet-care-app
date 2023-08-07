package dev.vengateshm.petcareapp.android.presentation.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import dev.vengateshm.petcareapp.android.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeOut: () -> Unit) {
    val currentTimeOut by rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(key1 = true) {
        delay(2000L)
        currentTimeOut()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(listOf(Color(0xFF4592E8), Color(0xFF4552CB)))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.path),
            contentDescription = null,
            tint = Color.White
        )
        Icon(
            painter = painterResource(id = R.drawable.path),
            contentDescription = null,
            tint = Color.White
        )
        Icon(
            painter = painterResource(id = R.drawable.path),
            contentDescription = null,
            tint = Color.White
        )
        Icon(
            painter = painterResource(id = R.drawable.path),
            contentDescription = null,
            tint = Color.White
        )
        Icon(
            painter = painterResource(id = R.drawable.path),
            contentDescription = null,
            tint = Color.White
        )
    }
}