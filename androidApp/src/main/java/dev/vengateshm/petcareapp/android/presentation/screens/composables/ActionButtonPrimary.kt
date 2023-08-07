package dev.vengateshm.petcareapp.android.presentation.screens.composables

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.vengateshm.petcareapp.android.ui.theme.Button1

@Composable
fun ColumnScope.ActionButtonPrimary(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonText: () -> String,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .align(Alignment.CenterHorizontally),
        colors = ButtonDefaults.buttonColors(containerColor = Button1),
        shape = RoundedCornerShape(25.dp),
        onClick = {
            onClick()
        }) {
        Text(
            text = buttonText(),
            color = contentColorFor(
                Button1
            )
        )
    }
}