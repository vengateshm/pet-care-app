package dev.vengateshm.petcareapp.android.presentation.screens.pet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.vengateshm.petcareapp.android.ui.theme.AppBlue
import dev.vengateshm.petcareapp.android.ui.theme.AppGray1
import dev.vengateshm.petcareapp.android.ui.theme.ScreenBg
import dev.vengateshm.petcareapp.domain.entity.Pet
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyPetsScreen(
    viewModel: MyPetsViewModel = koinViewModel(),
) {
    val uiState: MyPetsScreenState = viewModel.uiState
    MyPetsScreenContent(
        uiState = { uiState }
    )
}

@Composable
fun MyPetsScreenContent(
    uiState: () -> MyPetsScreenState,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = ScreenBg)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.clickable {

                    },
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Close Icon",
                    tint = AppBlue
                )
                Text(
                    text = "My pets",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color.White,
                        )
                        .padding(vertical = 16.dp)
                )
            }

            LazyColumn(
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(uiState().petList) { pet ->
                    MyPetItem(pet = pet)
                }
            }
        }
        Button(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(containerColor = AppGray1),
            shape = RoundedCornerShape(25.dp),
            onClick = {

            }) {
            Icon(imageVector = Icons.Rounded.Add, contentDescription = "", tint = AppBlue)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Add another pet",
                color = AppBlue
            )
        }
    }
}

@Composable
fun MyPetItem(pet: Pet) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(if (pet.speciesTypeId == 1) "https://images.pexels.com/photos/1741205/pexels-photo-1741205.jpeg?auto=compress&cs=tinysrgb&w=600" else "https://images.pexels.com/photos/5122188/pexels-photo-5122188.jpeg?auto=compress&cs=tinysrgb&w=600")
                .crossfade(true)
                .build(),
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = pet.name,
            fontSize = 18.sp
        )
        Text(
            text = pet.breedName ?: "",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}