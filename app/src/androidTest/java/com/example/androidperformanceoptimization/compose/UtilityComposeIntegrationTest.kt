package com.example.androidperformanceoptimization.compose

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.composepractise.utility.showAlertDialog
import com.example.composepractise.utility.showBottomSheet
import com.example.composepractise.utility.showFabButton
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Rule
import org.junit.Test

class UtilityComposeIntegrationTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun alertDialog_confirmButtonDismissesDialogAndDropdown() {
        val dismissAlertState = mutableStateOf(true)
        val dropDownExpand = mutableStateOf(true)

        composeRule.setContent {
            showAlertDialog(dismissAlertState, dropDownExpand)
        }

        composeRule.onNodeWithText("title Dialog").assertIsDisplayed()
        composeRule.onNodeWithText("Confirm").performClick()

        assertFalse(dismissAlertState.value)
        assertFalse(dropDownExpand.value)
    }

    @Test
    fun bottomSheet_buttonDismissesSheet() {
        val bottomSheetState = mutableStateOf(true)

        composeRule.setContent {
            showBottomSheet(bottomSheetState)
        }

        composeRule.onNodeWithText("Bottom Sheet").assertIsDisplayed()
        composeRule.onNodeWithText("click on me").performClick()

        assertFalse(bottomSheetState.value)
    }

    @Test
    fun fabButton_invokesClickCallback() {
        var clickCount = 0

        composeRule.setContent {
            showFabButton { clickCount++ }
        }

        composeRule.onNodeWithContentDescription("Fab click").performClick()

        assertEquals(1, clickCount)
    }
}
