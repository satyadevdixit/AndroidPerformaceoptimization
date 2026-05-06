package com.example.androidperformanceoptimization.compose.login

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class LoginRepositoryTest {

    private val repository = LoginRepository()

    @Test
    fun login_withValidEmailAndPassword_returnsSuccess() = runTest {
        val result = repository.login(
            loginType = LoginType.Email,
            username = "user@example.com",
            password = "password"
        )

        assertEquals(LoginResult.Success, result)
    }

    @Test
    fun login_withInvalidEmail_returnsError() = runTest {
        val result = repository.login(
            loginType = LoginType.Email,
            username = "invalid-email",
            password = "password"
        )

        assertTrue(result is LoginResult.Error)
        assertEquals("Please enter a valid email.", (result as LoginResult.Error).message)
    }

    @Test
    fun login_withInvalidMobile_returnsError() = runTest {
        val result = repository.login(
            loginType = LoginType.Mobile,
            username = "12345",
            password = "password"
        )

        assertTrue(result is LoginResult.Error)
        assertEquals("Please enter a valid mobile.", (result as LoginResult.Error).message)
    }

    @Test
    fun login_withShortPassword_returnsError() = runTest {
        val result = repository.login(
            loginType = LoginType.Email,
            username = "user@example.com",
            password = "12345"
        )

        assertTrue(result is LoginResult.Error)
        assertEquals("Password must be at least 6 characters.", (result as LoginResult.Error).message)
    }
}
