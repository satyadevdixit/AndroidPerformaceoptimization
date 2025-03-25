package com.example.androidperformanceoptimization.viewmodel

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {

    @Mock
   lateinit var  loginViewModel:LoginViewModel

  @Before
  fun setUpfortest()
  {
      MockitoAnnotations.initMocks(this)
      Mockito.`when`(loginViewModel.validateLoginCredentials("gmail.com","password")).thenReturn(true)
      //loginViewModel = LoginViewModel(ApplicationProvider.getApplicationContext())
  }

/*   companion object {
       @BeforeClass
       @JvmStatic
       fun  setUp()
       {
            loginViewModel = LoginViewModel(ApplicationProvider.getApplicationContext())
       }
   }*/

    @Test
    fun validLoginCredentialsMatchOrNot()
    {
        val result = loginViewModel.validateLoginCredentials("gmail.com","password")
        assertTrue(result)
    }

    @Test
    fun validateLoginCredentialsEmptyOrNot() {
       val result = loginViewModel.validateLoginCredentialsEmpty("","")
        assertTrue(result)
    }
}
