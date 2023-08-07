package dev.vengateshm.petcareapp.android.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.vengateshm.petcareapp.android.presentation.screens.composables.GoogleIcon
import dev.vengateshm.petcareapp.android.presentation.screens.composables.SocialSignupButton

@Composable
fun SignupLandingScreen(
    onRegisterWithEmailClicked: () -> Unit,
    onSignInClicked: () -> Unit,
) {
    SignupLandingScreenContent(
        onRegisterWithEmailClicked = onRegisterWithEmailClicked,
        onSignInClicked = onSignInClicked
    )
}

@Composable
fun SignupLandingScreenContent(
    onRegisterWithEmailClicked: () -> Unit,
    onSignInClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(listOf(Color(0xFF4592E8), Color(0xFF4552CB)))
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        /*
        // Overlapping issue
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White, fontSize = 42.sp)) {
                    append("Welcome\nto ")
                }
                withStyle(style = SpanStyle(color = Color(0xFFFFCF6F), fontSize = 42.sp)) {
                    append("Pet Care")
                }
            },
        )*/
        ConstraintLayout {
            val (firstText, secondText, thirdText) = createRefs()
            Text(
                text = "Welcome",
                fontSize = 42.sp,
                color = Color.White,
                modifier = Modifier.constrainAs(firstText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
            )
            Text(
                text = "to",
                fontSize = 42.sp,
                color = Color.White,
                modifier = Modifier.constrainAs(secondText) {
                    top.linkTo(firstText.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                }
            )
            Text(
                text = "Pet Care",
                fontSize = 42.sp,
                color = Color(0xFFFFCF6F),
                modifier = Modifier.constrainAs(thirdText) {
                    top.linkTo(secondText.top)
                    start.linkTo(secondText.end, margin = 16.dp)
                }
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        SocialSignupButton(icon = Icons.Rounded.Facebook, name = "Facebook")
        Spacer(modifier = Modifier.height(12.dp))
        SocialSignupButton(icon = GoogleIcon, name = "Google")
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Register with Email",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onRegisterWithEmailClicked()
                }
                .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(25.dp))
                .padding(8.dp),
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onSignInClicked()
                },
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.White)) {
                    append("Already have an Account?")
                }
                withStyle(style = SpanStyle(color = Color.White)) {
                    append("Sign In")
                }
            },
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun SignupLandingScreenPreview() {
    SignupLandingScreenContent(
        onRegisterWithEmailClicked = {},
        onSignInClicked = {}
    )
}