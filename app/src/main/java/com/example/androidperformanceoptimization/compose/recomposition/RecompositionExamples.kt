package com.example.composepractise.recomposition

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@SuppressLint("RememberReturnType")
@Composable
fun recompositionExample()
{
//recompositionWithStableParameters()
    var countData = remember { mutableStateOf(0) }
    var count = remember {
        countData.value+1}
    checkRememberFunctionality(count,countData.value,click = {
countData.value = it
    })
}


@Composable
fun recompositionWithStableParameters()
{
    var checked = remember { mutableStateOf(true) }
    var contactDetails = remember {  mutableStateOf(ContactDetails("dixit sahab",31))  }
  //  var contactDetails = remember {  ContactDetails("dixit sahab",31)  }
   // contactDetails.age = 89

    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        showContactDetails(contactDetails.value.age,"Hello")
        showToggleButton(
            checked.value,
            onStateChanged = {
                contactDetails.value.age = contactDetails.value.age +1
                checked.value = it
            }
        )
    }
}

@Composable
fun recompositionWithUnStableParameters()
{

}

@Composable
fun recomposableWithRemember()
{

}

@Composable
fun showToggleButton(selected: Boolean, onStateChanged: (Boolean) -> Unit) {
    Switch(checked = selected, onCheckedChange = {
        onStateChanged(it)
    })
}


@Composable
fun showContactDetails(contact: Int,dataVal:String) {
    Text(text = "Name: ${contact}, Age: ${contact}")
}


@SuppressLint("RememberReturnType")
@Composable
fun checkRememberFunctionality(count: Int,countData: Int,click:(Int)->Unit)
{
    checkMethodComposition(count,countData)
 Surface(modifier = Modifier.padding(50.dp)) {
     Row(modifier = Modifier.fillMaxWidth()) {
         Text(text = "count 1: = ${count}")
         Spacer(modifier = Modifier.width(10.dp))
         Text(text = "countData 2: = ${countData}")
         Button(onClick = { click(countData + 1) }) { Text(text = "click me") }
     }
 }

}

@Composable
fun checkMethodComposition(count:Int,countData:Int)
{
    Surface(modifier = Modifier.padding(top = 250.dp, start = 100.dp)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = "count: = ${count}")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "countData: = ${countData}")
        }
    }
}