package com.example.composepractise.listexample

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun showingCompleteList() {

val listViewModel = viewModel(ListViewModel::class.java)
    var name by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    Column(Modifier.padding(10.dp)) {
        enterDetails(name, address,{
            name = it })
        {
            address = it
        }
        Button(onClick = {listViewModel.addItemInList(name+"="+ address)
        }) { Text("click me") }
        LazyColumn {
            itemsIndexed(
                items = listViewModel.getLanguageList(),
                key = { index, item -> "$index-$item" }
            ) { _, item ->
                Surface(
                    onClick = { listViewModel.removeItemInList(item) },
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(item)
                }
            }
        }

    }

}


@Composable
fun enterDetails(
    name:String,
    address:String,
    nameMethod: (String) -> Unit,
    addressMethod:(String)->Unit)
{
    Column(modifier = Modifier.padding(10.dp)) {
        TextField(value = name, onValueChange = {
            nameMethod(it)})
    //    HorizontalDivider(modifier = Modifier,10.dp)
        TextField(value = address, onValueChange = {addressMethod(it)},Modifier.padding(0.dp,10.dp,0.dp,0.dp))
    }

}


