package com.example.composedemos.state_demo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*

class WellnessTask(val id: Int, val label: String, initialChecked: Boolean = false) {
    var checked by mutableStateOf(initialChecked)
}