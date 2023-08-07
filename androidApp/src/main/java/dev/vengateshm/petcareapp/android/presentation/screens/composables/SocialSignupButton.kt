package dev.vengateshm.petcareapp.android.presentation.screens.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vengateshm.petcareapp.android.ui.theme.Button1

@Composable
fun ColumnScope.SocialSignupButton(modifier: Modifier = Modifier, icon: ImageVector, name: String) {
    Row(
        modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(25.dp))
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = icon, contentDescription = "",
            tint = Color(0xFF4552CB)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFF4552CB))) {
                    append("Continue with ")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color(0xFF4552CB),
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(name)
                }
            },
            fontSize = 16.sp,
        )
    }
}

@Preview
@Composable
fun SocialSignupButtonPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Button1)
    ) {
        SocialSignupButton(
            icon = Icons.Rounded.Facebook,
            name = "Facebook"
        )
    }
}