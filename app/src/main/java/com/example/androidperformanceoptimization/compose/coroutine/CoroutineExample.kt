package com.example.composepractise.coroutine

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composepractise.navigationdrawer.createAppBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun coroutineEffect(drawerState: DrawerState,navController: NavController)
{
    var counter = remember { mutableStateOf<Int>(0) }
    val coroutineScope = rememberCoroutineScope()

  //  launchedEffect(counter)
    disposalEffect(counter)
Scaffold(topBar = { createAppBar("Coroutine",drawerState) }) {
    Surface(modifier = Modifier.padding(it)) {
        Column {
            TextButton(onClick = {
                coroutineScope.launch {
                      delay(3000)
                    counter.value = counter.value + 1
                }
            }) {
                Text(text = "click on Me")
            }
            Text(text = "counter = ${counter.value}")
        }
} }
}

@Composable
fun launchedEffect(counter: MutableState<Int>) {
    Surface(modifier = Modifier.padding(300.dp)) {
        Text(text = "lunched effects")
    }
    LaunchedEffect(counter.value) {
        delay(5000)
    }
}

@Composable
fun disposalEffect(counter: MutableState<Int>)
{
DisposableEffect(counter) {
    onDispose { }
}
}
