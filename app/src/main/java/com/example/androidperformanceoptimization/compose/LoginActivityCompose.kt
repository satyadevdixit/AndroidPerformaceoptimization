package com.example.androidperformanceoptimization.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidperformanceoptimization.compose.login.LoginComposeViewModel
import com.example.androidperformanceoptimization.compose.login.LoginScreen
import com.example.androidperformanceoptimization.compose.login.LoginRoute
import com.example.androidperformanceoptimization.compose.login.LoginUiState
import com.example.androidperformanceoptimization.compose.ui.theme.AndroidPerformanceoptimizationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : ComponentActivity() {
    private val loginViewModel: LoginComposeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPerformanceoptimizationTheme {
                LoginRoute(viewModel = loginViewModel)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidPerformanceoptimizationTheme {
        LoginScreen(
            uiState = LoginUiState(),
            onLoginTypeChanged = {},
            onUsernameChanged = {},
            onPasswordChanged = {},
            onPasswordVisibilityChanged = {},
            onLoginClicked = {}
        )
    }
}
