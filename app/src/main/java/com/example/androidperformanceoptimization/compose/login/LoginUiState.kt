package com.example.androidperformanceoptimization.compose.login

data class LoginUiState(
    val loginType: LoginType = LoginType.Email,
    val username: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isLoginSuccessful: Boolean = false
) {
    val canSubmit: Boolean
        get() = username.isNotBlank() && password.isNotBlank() && !isLoading
}
