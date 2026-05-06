package com.example.androidperformanceoptimization.compose.login

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidperformanceoptimization.compose.ui.theme.AndroidPerformanceoptimizationTheme
import com.example.androidperformanceoptimization.ui.home.RecylerViewActivity

@Composable
fun LoginRoute(viewModel: LoginComposeViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    LaunchedEffect(uiState.isLoginSuccessful) {
        if (uiState.isLoginSuccessful) {
            context.startActivity(Intent(context, RecylerViewActivity::class.java))
            viewModel.onLoginNavigationHandled()
        }
    }

    LoginScreen(
        uiState = uiState,
        onLoginTypeChanged = viewModel::onLoginTypeChanged,
        onUsernameChanged = viewModel::onUsernameChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onPasswordVisibilityChanged = viewModel::onPasswordVisibilityChanged,
        onLoginClicked = viewModel::onLoginClicked
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onLoginTypeChanged: (LoginType) -> Unit,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onPasswordVisibilityChanged: () -> Unit,
    onLoginClicked: () -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .imePadding()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = "Welcome back",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Sign in with your email or mobile number.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        LoginType.entries.forEach { loginType ->
                            FilterChip(
                                selected = uiState.loginType == loginType,
                                onClick = { onLoginTypeChanged(loginType) },
                                modifier = Modifier.testTag("login_type_${loginType.name}"),
                                label = { Text(loginType.label) }
                            )
                        }
                    }

                    OutlinedTextField(
                        value = uiState.username,
                        onValueChange = onUsernameChanged,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("login_username"),
                        label = { Text(uiState.loginType.label) },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = when (uiState.loginType) {
                                LoginType.Email -> KeyboardType.Email
                                LoginType.Mobile -> KeyboardType.Phone
                            },
                            imeAction = ImeAction.Next
                        )
                    )

                    OutlinedTextField(
                        value = uiState.password,
                        onValueChange = onPasswordChanged,
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("login_password"),
                        label = { Text("Password") },
                        singleLine = true,
                        visualTransformation = if (uiState.isPasswordVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        trailingIcon = {
                            TextButton(onClick = onPasswordVisibilityChanged) {
                                Text(if (uiState.isPasswordVisible) "Hide" else "Show")
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(onDone = { onLoginClicked() })
                    )

                    uiState.errorMessage?.let { message ->
                        Text(
                            text = message,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Button(
                        onClick = onLoginClicked,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .testTag("login_button"),
                        enabled = uiState.canSubmit
                    ) {
                        if (uiState.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.height(22.dp),
                                strokeWidth = 2.dp,
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        } else {
                            Text(
                                text = "Login",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Forgot password?",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    AndroidPerformanceoptimizationTheme {
        LoginScreen(
            uiState = LoginUiState(username = "user@gmail.com", password = "password"),
            onLoginTypeChanged = {},
            onUsernameChanged = {},
            onPasswordChanged = {},
            onPasswordVisibilityChanged = {},
            onLoginClicked = {}
        )
    }
}
