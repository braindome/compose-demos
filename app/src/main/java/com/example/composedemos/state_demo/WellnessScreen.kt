package com.example.composedemos.state_demo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    // WaterCounter(modifier)
    StatefulCounter()
    // WellnessTaskList()

    /**
     * now using the list from the view model
     */

    // val list = remember { getWellnessTasks().toMutableStateList() }
    WellnessTaskList(
        list = wellnessViewModel.tasks,
        onCheckedTask = { task, checked ->
            wellnessViewModel.changeTaskChecked(task, checked)
        },
        onCloseTask = { task ->
            wellnessViewModel.remove(task)
        }
    )
}

// fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task nr $i") }
