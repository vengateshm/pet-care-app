package dev.vengateshm.petcareapp.android.presentation.screens.composables

import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

@Composable
fun GoogleSignInManager(
    state: GoogleSignInManagerState,
    onComplete: () -> Unit,
    onIdToken: (String) -> Unit,
) {
    val activity = LocalContext.current as Activity

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        onComplete()
        if (result.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.getResult(ApiException::class.java)
                Log.d("GoogleSignIn", "Account name: ${account.displayName}")
                Log.d("GoogleSignIn", "Account email: ${account.email}")
                val idToken = GoogleSignIn.getLastSignedInAccount(activity)?.idToken ?: ""
                if (idToken.isNotEmpty())
                    onIdToken(idToken)
            } catch (e: ApiException) {
                Log.e("GoogleSignIn", "Google sign in failed", e)
            }
        }
    }

    LaunchedEffect(state.startSignIn) {
        if (state.startSignIn) {
            getClient(activity).signInIntent.also {
                launcher.launch(it)
            }
        }
    }
}

@Composable
fun rememberGoogleSignInManagerState(): GoogleSignInManagerState {
    return remember {
        GoogleSignInManagerState()
    }
}

class GoogleSignInManagerState {
    var startSignIn by mutableStateOf(false)
}

//const val CLIENT_ID = "585119232809-5jf3l9i25882tp8387sprmc4eo4l3d34.apps.googleusercontent.com"
const val CLIENT_ID = "585119232809-lsuh2viqn4jga1tu94r0ecda4db35vqm.apps.googleusercontent.com"

fun getClient(context: Activity): GoogleSignInClient {
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(CLIENT_ID)
        .requestEmail()
        .requestProfile()
        .build()
    return GoogleSignIn.getClient(context, gso)
}