package dev.vengateshm.petcareapp.android.presentation.screens.home

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.vengateshm.petcareapp.android.ui.theme.AppBlue
import dev.vengateshm.petcareapp.android.ui.theme.ScreenBg
import dev.vengateshm.petcareapp.domain.entity.Physician
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinViewModel(),
    specializationId: String,
) {
    val screenState = viewModel.screenState.value

    LaunchedEffect(true) {
        if (specializationId.isNotEmpty()) {
            val sId = specializationId.toInt()
            if (sId > 0) {
                viewModel.getPhysiciansBySpecializationId(sId)
            }
        }
    }
    SearchScreenContent(screenState = screenState)
}

@Composable
fun SearchScreenContent(
    screenState: SearchScreenState,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ScreenBg)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.clickable {

                },
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "Close Icon",
                tint = AppBlue
            )
        }
        if (screenState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (screenState.errorMessage.isNotBlank()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Couldn't load Veterinarians")
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(horizontal = 12.dp)
            ) {
                items(screenState.physicians) { physician ->
                    PhysicianItem(physician = physician)
                }
            }
        }
    }
}

@Composable
fun PhysicianItem(physician: Physician) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .clip(RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data("https://images.pexels.com/photos/6749778/pexels-photo-6749778.jpeg?auto=compress&cs=tinysrgb&w=600")
                .crossfade(true)
                .build(),
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = physician.name,
                fontSize = 16.sp
            )
            Text(
                text = physician.specializationName ?: "",
                fontSize = 14.sp
            )
        }
    }
}