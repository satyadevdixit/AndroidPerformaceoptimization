package com.example.androidperformanceoptimization.compose.login

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoginComposeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val viewModel = LoginComposeViewModel(LoginRepository())

    @Test
    fun usernameChanged_whenMobileSelected_keepsOnlyTenDigits() {
        viewModel.onLoginTypeChanged(LoginType.Mobile)
        viewModel.onUsernameChanged("98abc765432101")

        assertEquals("9876543210", viewModel.uiState.value.username)
    }

    @Test
    fun loginClicked_withBlankFields_setsRequiredFieldError() {
        viewModel.onLoginClicked()

        assertEquals("Please fill all required fields.", viewModel.uiState.value.errorMessage)
        assertFalse(viewModel.uiState.value.isLoginSuccessful)
    }

    @Test
    fun loginClicked_withInvalidEmail_setsRepositoryError() = runTest {
        viewModel.onUsernameChanged("wrong")
        viewModel.onPasswordChanged("password")

        viewModel.onLoginClicked()
        advanceUntilIdle()

        assertEquals("Please enter a valid email.", viewModel.uiState.value.errorMessage)
        assertFalse(viewModel.uiState.value.isLoginSuccessful)
    }

    @Test
    fun loginClicked_withValidCredentials_marksLoginSuccessful() = runTest {
        viewModel.onUsernameChanged("user@example.com")
        viewModel.onPasswordChanged("password")

        viewModel.onLoginClicked()
        advanceUntilIdle()

        assertTrue(viewModel.uiState.value.isLoginSuccessful)
        assertFalse(viewModel.uiState.value.isLoading)
    }
}
