package com.example.composedemos.state_demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {

        /**
         * 'remember' retains state across recompositions
         * 'rememberSaveable' retains it across configuration changes
         * (i.e. after screen rotation)
         */

        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

/**
 * Stateful and stateless
 */

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

/**
 * StatefulCounter owns the state. It holds the count state and modifies
 * it when calling the StatelessCounter function
 */

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }
    StatelessCounter(count = count, onIncrement = { count++ }, modifier)
}


/*
@Composable
fun WaterCounter(modifier: Modifier = Modifier) {

    
    Column(modifier = Modifier.padding(16.dp)) {
        var count by remember { mutableIntStateOf(0) }
        if (count > 0){
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(taskName = "Have you taken your 15 minute walk today?", onClose = { showTask = false })
            }
            Text(text = "You've had $count glasses")
        }
        Row(Modifier.padding(top = 8.dp)) {
            Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
                Text(text = "Add one")
            }
            Button(onClick = { count = 0 }, Modifier.padding(start = 8.dp)) {
                Text(text = "Clear water count")
            }
        }

    }
}


*/

