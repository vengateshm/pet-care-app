package dev.vengateshm.petcareapp.android.presentation.screens.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dev.vengateshm.petcareapp.android.presentation.screens.composables.ActionButtonPrimary
import dev.vengateshm.petcareapp.android.ui.theme.Button1
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(
    onSignInClicked: () -> Unit,
    onGetStartedClicked: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val items = remember { welcomeDataList }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        val pagerState = rememberPagerState(pageCount = { items.size })
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Sign In",
            color = Button1,
            modifier = Modifier
                .align(Alignment.End)
                .clickable {
                    onSignInClicked()
                }
                .padding(8.dp)
        )
        HorizontalPager(
            state = pagerState,
            pageSpacing = 20.dp
        ) { index ->
            Column(
                Modifier
                    .fillMaxWidth()
            ) {
                AsyncImage(
                    model = items[index].imageRes,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop,
                    contentDescription = ""
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp),
                    text = items[index].title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp),
                    text = items[index].description,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                ActionButtonPrimary(
                    onClick = {
                        if (index < 2) {
                            scope.launch {
                                pagerState.animateScrollToPage(index + 1)
                            }
                        } else {
                            onGetStartedClicked()
                        }
                    },
                    buttonText = {
                        if (index != 2) "Next" else "Get Started"
                    })
            }
        }
    }
}