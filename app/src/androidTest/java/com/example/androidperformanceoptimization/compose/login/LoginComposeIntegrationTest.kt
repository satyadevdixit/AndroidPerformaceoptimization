package com.example.androidperformanceoptimization.compose.login

import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.androidperformanceoptimization.compose.ComposeActivity
import org.junit.Rule
import org.junit.Test

class LoginComposeIntegrationTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<ComposeActivity>()

    @Test
    fun loginScreen_initialState_disablesLoginButton() {
        composeRule.onNodeWithText("Welcome back").assertExists()
        composeRule.onNodeWithTag("login_button").assertIsNotEnabled()
    }

    @Test
    fun loginScreen_invalidEmail_showsValidationErrorFromRepository() {
        composeRule.onNodeWithTag("login_username").performTextInput("wrong")
        composeRule.onNodeWithTag("login_password").performTextInput("password")
        composeRule.onNodeWithTag("login_button").assertIsEnabled()
        composeRule.onNodeWithTag("login_button").performClick()

        composeRule.waitUntil(timeoutMillis = 2_000) {
            composeRule
                .onAllNodesWithText("Please enter a valid email.")
                .fetchSemanticsNodes()
                .isNotEmpty()
        }
    }

    @Test
    fun loginScreen_mobileMode_acceptsMobileInput() {
        composeRule.onNodeWithTag("login_type_Mobile").performClick()
        composeRule.onNodeWithTag("login_username").performTextInput("9876543210")
        composeRule.onNodeWithTag("login_password").performTextInput("password")

        composeRule.onNodeWithTag("login_button").assertIsEnabled()
    }
}
