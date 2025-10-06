package com.example.androidperformanceoptimization.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidperformanceoptimization.R
import com.example.androidperformanceoptimization.compose.ui.theme.AndroidPerformanceoptimizationTheme
import com.example.androidperformanceoptimization.ui.home.RecylerViewActivity

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    containerColor = Color.White) { innerPadding ->
                    Column() {
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
    var searchValue = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxWidth().height(250.dp).background(Color.Red).padding(20.dp),
    ) {

Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

    Text(
        text = "HITACHI",
        modifier = Modifier.clickable {
            val intent = Intent(context, RecylerViewActivity::class.java)
            intent.apply { this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
            context.startActivity(intent)
        }.padding(30.dp),
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 30.sp
    )

    Spacer(modifier = Modifier.height(10.dp))

    Box(modifier = Modifier.clickable {
        val intent = Intent(context, RecylerViewActivity::class.java)
        intent.apply { this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
        context.startActivity(intent)
    }.border(2.dp,Color.White).padding(15.dp)
    ) {


        Text(
            text = "Demo Mode",
            color = Color.White,
            modifier = Modifier.padding(5.dp)
        )
    }

    }

}
    var isEmailSelected = remember { mutableStateOf(true) }
    mailAndNumber(isEmailSelected)
    userNameAndPassword(isEmailSelected)
}


@Composable
fun mailAndNumber(isEmailSelected: MutableState<Boolean>)
{
    var isEmailLineVisible by remember { mutableStateOf(true) }
    var isMobleLineVisible by remember { mutableStateOf(false) }

    Row(modifier = Modifier.fillMaxWidth().height(60.dp).background(Color.Gray)) {

    Column(modifier = Modifier.weight(1f)) {
        Text(
            textAlign = TextAlign.Center,
            text = "Email",
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().fillMaxHeight().clickable {
                if (!isEmailLineVisible) {
                    isEmailLineVisible = true
                    isEmailSelected.value = true
                    isMobleLineVisible = false
                }

            }.padding(10.dp),
            fontSize = 20.sp
        )
        if (isEmailLineVisible) {
            HorizontalDivider(
                modifier = Modifier.padding(top = 0.dp), // Adjust padding as needed
                thickness = 2.dp, // Customize line thickness
                color = Color.Red // Customize line color
            )
        }


    }

        Column(modifier = Modifier.weight(1f)) {
            Text(
                textAlign = TextAlign.Center,
                text = "Mobile No.",
                color = Color.DarkGray,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth().fillMaxHeight().clickable {
                    if (!isMobleLineVisible) {
                        isMobleLineVisible = true
                        isEmailLineVisible = false
                        isEmailSelected.value = false
                    }

                }.padding(10.dp),
                fontSize = 20.sp
            )
            if (isMobleLineVisible) {
                HorizontalDivider(
                    modifier = Modifier.padding(top = 0.dp), // Adjust padding as needed
                    thickness = 2.dp, // Customize line thickness
                    color = Color.Red // Customize line color
                )
            }


        }
}
}


@Composable
fun userNameAndPassword(isEmailSelected: MutableState<Boolean>)
{
    val context = LocalContext.current
    val maxChars = 25
    var userEmailValue = remember { mutableStateOf("") }
    var passwordValue = remember { mutableStateOf("") }
    var mobileValue = remember { mutableStateOf("") }
    var loginButtonEnabled = remember { mutableStateOf(false) }

Column(modifier = Modifier.padding(15.dp)) {

    if (isEmailSelected.value) {
        OutlinedTextField(
            label = { Text("Email") },
            value = userEmailValue.value,
            onValueChange = {
                userEmailValue.value = it
                if (userEmailValue.value.length >= 15 && passwordValue.value.length > 15)
                    loginButtonEnabled.value = true
                else
                    loginButtonEnabled.value = false
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = {
                //            navController.navigateUp()
                // dismissAlertDialogState.value = true
            })
        )
    }
    else {
        OutlinedTextField(
            label = { Text("Mobile") },
            value = mobileValue.value,
            onValueChange = {
                mobileValue.value = it
                if (userEmailValue.value.length >= 15 && mobileValue.value.length > 15)
                    loginButtonEnabled.value = true
                else
                    loginButtonEnabled.value = false
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            singleLine = true,
            keyboardActions = KeyboardActions(onDone = {
                //            navController.navigateUp()
                // dismissAlertDialogState.value = true
            })
        )
    }

    Box(modifier = Modifier.fillMaxWidth().height(80.dp).padding(top = 15.dp).border(2.dp, color = Color.Gray),
    ) {

        Row () {
            TextField(
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, // Background color when focused
                    unfocusedContainerColor = Color.White // Background color when unfocused
                ),

                label = { Text("Password") },
                value = passwordValue.value,
                onValueChange = {
                        newValue ->
                    if (newValue.length <= maxChars) {
                        passwordValue.value = newValue
                    }
                    if (userEmailValue.value.length>=15 && passwordValue.value.length>15 && !isEmailSelected.value)
                        loginButtonEnabled.value = true
                    else if (mobileValue.value.length>=15 && passwordValue.value.length>15 && isEmailSelected.value)
                        loginButtonEnabled.value = true
                    else
                        loginButtonEnabled.value = false
                                },
                modifier = Modifier.background(Color.White).weight(0.7F).fillMaxHeight(),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                singleLine = true,
                keyboardActions = KeyboardActions(onDone = {
                    //            navController.navigateUp()
                    // dismissAlertDialogState.value = true
                })
            )


            Image(
                modifier = Modifier.weight(0.3F).height(50.dp).width(50.dp).padding( start = 10.dp).clickable { passwordValue.value = "" },
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "image"
            )
        }
    }

    Text(
        textAlign = TextAlign.End,
        text = "Forgot Password?",
        modifier = Modifier.fillMaxWidth().clickable {
            val intent = Intent(context, RecylerViewActivity::class.java)
            intent.apply { this.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) }
            context.startActivity(intent)
        }.padding(top = 10.dp),
        fontWeight = FontWeight.Bold,
        color = Color.Red,
        fontSize = 15.sp
    )

    Button(onClick = {
    },
        modifier = Modifier.fillMaxWidth().then(
            if (loginButtonEnabled.value) Modifier.height(80.dp).padding(top = 15.dp) else Modifier.height(80.dp).padding(top = 15.dp)
                .background(Color.Red).alpha(0.7F)
        ),
        colors = ButtonColors(
            Color.Red,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.DarkGray
        ), elevation = ButtonDefaults.buttonElevation(10.dp),
        shape = RectangleShape,
        enabled = loginButtonEnabled.value
        ) {
        Text(text = "Login",
            fontSize = 25.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold)
    }
}
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidPerformanceoptimizationTheme {
        Greeting("Android")
    }
}