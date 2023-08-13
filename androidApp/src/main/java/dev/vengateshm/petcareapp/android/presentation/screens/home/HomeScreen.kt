package dev.vengateshm.petcareapp.android.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.vengateshm.petcareapp.android.presentation.imageVectors.SearchIcon
import dev.vengateshm.petcareapp.android.presentation.screens.AppScreen
import dev.vengateshm.petcareapp.android.ui.theme.AppBlue
import dev.vengateshm.petcareapp.android.ui.theme.ScreenBg
import dev.vengateshm.petcareapp.domain.entity.Specialization
import org.koin.androidx.compose.koinViewModel

val welcomeTextSize = 24.sp
val gridSpacing = 2.dp

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    navController: NavController,
    navigateToSearchScreen: (Specialization) -> Unit,
) {
    val uiState = viewModel.uiState
    val specializationDialogState = viewModel.specializationDialogState
    HomeScreenContent(
        uiState = {
            uiState
        },
        showSpecializationDialog = {
            specializationDialogState.showDialog
        },
        specializationList = {
            specializationDialogState.specializations
        },
        onSearchIconClicked = {
            viewModel.getAllSpecializations()
        },
        onAddPetDetailClicked = {
            navController.navigate(AppScreen.AddPetDetail.route)
        },
        onNoLaterClicked = {

        },
        onSpecialityDialogDismissed = {
            viewModel.dismissSpecializationDialog()
        },
        onSpecialityItemClicked = {
            navigateToSearchScreen(it)
        })
}

@Composable
fun HomeScreenContent(
    uiState: () -> HomeScreenState,
    showSpecializationDialog: () -> Boolean,
    specializationList: () -> List<Specialization>,
    onSearchIconClicked: () -> Unit,
    onAddPetDetailClicked: () -> Unit,
    onNoLaterClicked: () -> Unit,
    onSpecialityDialogDismissed: () -> Unit,
    onSpecialityItemClicked: (Specialization) -> Unit,
) {
    val context = LocalContext.current

    AddPetDetailBottomDialog(
        onDismiss = { },
        onAddPetDetailClicked = { onAddPetDetailClicked() },
        onNoLaterClicked = { onNoLaterClicked() }
    )

    if (showSpecializationDialog()) {
        SelectSpecialityBottomDialog(
            specializationList = specializationList(),
            onDismiss = { onSpecialityDialogDismissed() },
            onItemClicked = {
                onSpecialityItemClicked(it)
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ScreenBg)
            .padding(16.dp)
    ) {
        Icon(modifier = Modifier
            .clickable {
                onSearchIconClicked()
            }
            .align(Alignment.End),
            imageVector = SearchIcon,
            contentDescription = "Search Icon",
            tint = AppBlue)
        ConstraintLayout {
            val (firstText, secondText, thirdText) = createRefs()
            Text(text = "What are you",
                fontSize = welcomeTextSize,
                color = Color.Black,
                modifier = Modifier.constrainAs(firstText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })
            Text(text = "looking for,",
                fontSize = welcomeTextSize,
                color = Color.Black,
                modifier = Modifier.constrainAs(secondText) {
                    top.linkTo(firstText.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                })
            Text(text = "${uiState().userName.ifEmpty { "" }}?",
                fontSize = welcomeTextSize,
                color = Color(0xFFFFCF6F),
                modifier = Modifier.constrainAs(thirdText) {
                    /*top.linkTo(secondText.top)
                    start.linkTo(secondText.end, margin = 16.dp)
                    end.linkTo(parent.end)*/
                    top.linkTo(secondText.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                })
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(gridSpacing),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(gridSpacing)
        ) {
            items(uiState().appServiceList) { item ->
                Column(
                    modifier = Modifier
                        .background(
                            color = Color.White, shape = RoundedCornerShape(16.dp)
                        )
                        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context).data(item.imgUrl).crossfade(true)
                            .build(),
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        contentDescription = null
                    )
                    Text(
                        text = item.name, fontSize = 12.sp
                    )
                }
            }
        }
    }
}
