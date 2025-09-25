package com.example.androidperformanceoptimization.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidperformanceoptimization.compose.ui.theme.AndroidPerformanceoptimizationTheme
import com.example.androidperformanceoptimization.ui.home.RecylerViewActivity

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPerformanceoptimizationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Text(
        text = "Hello $name!",
        modifier = Modifier.clickable {  val intent = Intent(context, RecylerViewActivity::class.java)
            intent.apply { this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
            context.startActivity(intent) }.padding(50.dp)
    )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidPerformanceoptimizationTheme {
        Greeting("Android")
    }
}