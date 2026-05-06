package com.example.androidperformanceoptimization.ui.home

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.work.Logger
import com.example.androidperformanceoptimization.R
import com.example.androidperformanceoptimization.databinding.ActivityLoginActiviyBinding
import com.example.androidperformanceoptimization.model.PopulationCitiesListPojo
import com.example.androidperformanceoptimization.viewmodel.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import retrofit2.http.Url
import kotlin.math.log

class LoginActiviy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_login_activiy)
        val loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        val dataBinding:ActivityLoginActiviyBinding = DataBindingUtil.setContentView(this,R.layout.activity_login_activiy)
        dataBinding.loginviewmodel = loginViewModel
        val composeView = findViewById<ComposeView>(R.id.compose_view)
        composeView.setContent {
            showComposeData()
            showWebView("https://www.google.com/search?q=webview+in+jetpack+compose+android&client=ms-android-oneplus-terr1-rso2&sca_esv=c98b4f30de667057&sxsrf=AE3TifOz6Mew_FoiWMa3PwSu6gqIc4FcPg%3A1762182943311&ei=H8cIab3cEPOPseMP3MW9gQw&oq=webview+in+jetpack+compose&gs_lp=Egxnd3Mtd2l6LXNlcnAiGndlYnZpZXcgaW4gamV0cGFjayBjb21wb3NlKgIIATILEAAYgAQYkQIYigUyBhAAGBYYHjIIEAAYFhgKGB4yBhAAGBYYHjIGEAAYFhgeMgYQABgWGB4yBhAAGBYYHjIIEAAYgAQYogRI0DlQqwVYqy1wAXgBkAEAmAGlAqAB-imqAQcwLjExLjE1uAEDyAEA-AEBmAIboALLK6gCE8ICBxAjGCcY6gLCAhYQIxiCBhiDBhgnGPoFGOoCGO0FGN0FwgIUEAAYgAQYkQIYtAIYigUY6gLYAQHCAhAQABgDGLQCGOoCGI8B2AEBwgIQEC4YAxi0AhjqAhiPAdgBAcICCxAuGIAEGLEDGIMBwgIIEAAYgAQYsQPCAhEQLhiABBixAxjRAxiDARjHAcICDhAAGIAEGLEDGIMBGIoFwgIOEC4YgAQYsQMYgwEYigXCAgsQABiABBixAxiDAcICChAjGIAEGCcYigXCAg0QABiABBixAxhDGIoFwgIKEAAYgAQYQxiKBcICFhAuGIAEGLEDGNEDGEMYgwEYxwEYigXCAhAQABiABBixAxhDGIMBGIoFwgIFEAAYgATCAgcQABiABBgKwgILEC4YgAQYxwEYrwHCAgsQABiABBiGAxiKBZgDDfEFB1iyJhgMk_C6BgYIARABGAGSBwgxLjYuMTkuMaAH5qQBsgcIMC42LjE5LjG4B70rwgcIMC40LjE1LjjIB6MB&sclient=gws-wiz-serp")
        }
        lifecycleScope.launch { coroutineexample() }

    }

    suspend fun coroutineexample()
    {

        lifecycleScope.launch {
            Log.d("loginactivity", "launch")
        }

        var data = lifecycleScope.async(Dispatchers.Default) {
            Log.d("loginactivity", "async 1")
            delay(3000)
            Log.d("loginactivity", "async 2")
           // Toast.makeText(this,"showing",Toast.LENGTH_SHORT).show()
            4 + 9
        }


        data.cancel()
        Log.d("loginactivity", "async 3")
        Log.d("loginactivity",data.await().toString())

        Log.d("loginactivity", "async 4")
    }

    @Composable
    fun showComposeData()
    {
        Surface {
            Text(modifier = Modifier.clickable { Toast.makeText(applicationContext,"click on me",Toast.LENGTH_SHORT).show() },
                text = "Hello Compose"
            )
        }
    }


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @Composable
    fun showWebView(url: String)
    {
        AndroidView(factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient() // Handle URL loading within the WebView
                settings.javaScriptEnabled = true // Enable JavaScript if needed
                loadUrl(url)
                /*findOnBackInvokedDispatcher({
                    if (canGoBack())
                    {
                        goBack()
                    }
                })*/
            }


        }, update = { webView ->
            webView.loadUrl(url) // Update URL if it changes
        })
    }


}