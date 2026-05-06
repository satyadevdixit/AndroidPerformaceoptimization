package com.example.androidperformanceoptimization.compose.login

import kotlinx.coroutines.delay
import javax.inject.Inject

class LoginRepository @Inject constructor() {

    suspend fun login(loginType: LoginType, username: String, password: String): LoginResult {
        delay(600)

        val trimmedUsername = username.trim()
        if (trimmedUsername.isEmpty() || password.isEmpty()) {
            return LoginResult.Error("Please enter your ${loginType.label.lowercase()} and password.")
        }

        val isUsernameValid = when (loginType) {
            LoginType.Email -> trimmedUsername.contains("@") && trimmedUsername.contains(".")
            LoginType.Mobile -> trimmedUsername.length == 10 && trimmedUsername.all { it.isDigit() }
        }

        if (!isUsernameValid) {
            return LoginResult.Error("Please enter a valid ${loginType.label.lowercase()}.")
        }

        if (password.length < 6) {
            return LoginResult.Error("Password must be at least 6 characters.")
        }

        return LoginResult.Success
    }
}

enum class LoginType(val label: String) {
    Email("Email"),
    Mobile("Mobile")
}

sealed interface LoginResult {
    data object Success : LoginResult
    data class Error(val message: String) : LoginResult
}
