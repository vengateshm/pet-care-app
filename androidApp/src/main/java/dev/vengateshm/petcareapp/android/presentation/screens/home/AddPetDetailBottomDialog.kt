package dev.vengateshm.petcareapp.android.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.vengateshm.petcareapp.android.presentation.screens.composables.PrimaryButton
import dev.vengateshm.petcareapp.android.presentation.screens.composables.SecondaryButton
import dev.vengateshm.petcareapp.android.ui.theme.AppBlue
import dev.vengateshm.petcareapp.android.ui.theme.AppYellow
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@androidx.compose.runtime.Composable
fun AddPetDetailBottomDialog(
    onDismiss: () -> Unit,
    onAddPetDetailClicked: () -> Unit,
    onNoLaterClicked: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    var openBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        delay(2000L)
        openBottomSheet = true
    }

    if (openBottomSheet) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                openBottomSheet = false
                onDismiss()
            },
            dragHandle = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BottomSheetDefaults.DragHandle()
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                    ) {
                        Icon(
                            modifier = Modifier.clickable {
                                scope.launch {
                                    sheetState.hide()
                                }.invokeOnCompletion {
                                    if (!sheetState.isVisible) {
                                        openBottomSheet = false
                                        onDismiss()
                                    }
                                }
                            },
                            imageVector = Icons.Rounded.Close,
                            contentDescription = "Close Icon",
                            tint = AppBlue
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Add pet detail",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(AddPetDetailPrompt.list) { item ->
                    AddPetDetailPromptItem(title = item.title)
                }
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                PrimaryButton(
                    modifier = Modifier.weight(weight = 1f),
                    onClick = {
                        openBottomSheet = false
                        onAddPetDetailClicked()
                    },
                    buttonText = {
                        "Add"
                    })
                SecondaryButton(
                    modifier = Modifier.weight(weight = 1f),
                    onClick = {
                        openBottomSheet = false
                        onNoLaterClicked()
                    },
                    buttonText = {
                        "No, later"
                    })
            }
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Composable
fun AddPetDetailPromptItem(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
            ),
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(AppYellow)
                .padding(top = 4.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

data class AddPetDetailPrompt(val title: String) {
    companion object {
        val list = listOf(
            AddPetDetailPrompt(
                title = "Faster check-in at appointment."
            ),
            AddPetDetailPrompt(
                title = "Schedule of vaccination, haircuts, inspections etc."
            ),
            AddPetDetailPrompt(
                title = "Reminder of the upcoming events with your pet."
            ),
        )
    }
}