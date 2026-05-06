package com.example.androidperformanceoptimization.compose.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginComposeViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onLoginTypeChanged(loginType: LoginType) {
        _uiState.update {
            it.copy(
                loginType = loginType,
                username = "",
                errorMessage = null,
                isLoginSuccessful = false
            )
        }
    }

    fun onUsernameChanged(username: String) {
        _uiState.update {
            it.copy(
                username = when (it.loginType) {
                    LoginType.Email -> username
                    LoginType.Mobile -> username.filter(Char::isDigit).take(10)
                },
                errorMessage = null,
                isLoginSuccessful = false
            )
        }
    }

    fun onPasswordChanged(password: String) {
        _uiState.update {
            it.copy(
                password = password.take(24),
                errorMessage = null,
                isLoginSuccessful = false
            )
        }
    }

    fun onPasswordVisibilityChanged() {
        _uiState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    fun onLoginClicked() {
        val currentState = _uiState.value
        if (!currentState.canSubmit) {
            _uiState.update { it.copy(errorMessage = "Please fill all required fields.") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null, isLoginSuccessful = false) }

            when (
                val result = loginRepository.login(
                    currentState.loginType,
                    currentState.username,
                    currentState.password
                )
            ) {
                LoginResult.Success -> {
                    _uiState.update { it.copy(isLoading = false, isLoginSuccessful = true) }
                }

                is LoginResult.Error -> {
                    _uiState.update {
                        it.copy(isLoading = false, errorMessage = result.message)
                    }
                }
            }
        }
    }

    fun onLoginNavigationHandled() {
        _uiState.update { it.copy(isLoginSuccessful = false) }
    }
}
