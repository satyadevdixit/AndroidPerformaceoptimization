package com.example.androidperformanceoptimization

import com.example.androidperformanceoptimization.viewmodel.LoginViewModel
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class LoginViewModelTest {

   private lateinit var  loginViewModel: LoginViewModel

  @Before
  fun setUpfortest()
  {
     val appContext = RuntimeEnvironment.getApplication()
      loginViewModel = LoginViewModel(appContext)
  }

    @Test
    fun validLoginCredentialsMatchOrNot()
    {
        val result = loginViewModel.validateLoginCredentials("gmail.com","password")
        assertEquals(true,result)
    }

    @Test
    fun validateLoginCredentialsEmptyOrNot() {
       val result = loginViewModel.validateLoginCredentialsEmpty("","")
        assertEquals(true,result)
    }
}
