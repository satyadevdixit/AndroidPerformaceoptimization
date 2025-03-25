package com.example.androidperformanceoptimization

import android.app.Application
import com.example.androidperformanceoptimization.viewmodel.LoginViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {

  //  @Mock
    lateinit var  loginViewModel: LoginViewModel
    @Mock
    lateinit var  context: Application

    @Before
    fun setUpfortest()
    {
        MockitoAnnotations.initMocks(this)
      //  Mockito.`when`(loginViewModel.validateLoginCredentials("gmail.com1","password")).thenReturn(true)
        loginViewModel = LoginViewModel(context)
    }


    @Test
    fun validLoginCredentialsMatchOrNot()
    {
        val result = loginViewModel.validateLoginCredentials("gmail.com","password")
        assertEquals(true,result)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}