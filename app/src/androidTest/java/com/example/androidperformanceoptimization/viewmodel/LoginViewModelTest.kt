package com.example.androidperformanceoptimization.viewmodel

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginViewModelTest {

   lateinit var  loginViewModel:LoginViewModel

  @Before
  fun setUpfortest()
  {
      loginViewModel = LoginViewModel(ApplicationProvider.getApplicationContext())
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
    //  val  loginViewModel = LoginViewModel(ApplicationProvider.getApplicationContext())
        val result = loginViewModel.validateLoginCredentials("gmail.com","password")
        assertTrue(result)
    }

    @Test
    fun validateLoginCredentialsEmptyOrNot() {

       val result = loginViewModel.validateLoginCredentialsEmpty("","")
        assertTrue(result)
    }
}