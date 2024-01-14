package com.example.composedemos.state_demo

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.withContext


@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id }
        ) { task ->
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckedChange = { checked ->  onCheckedTask(task, checked) },
                onClose = { onCloseTask(task) }
            )
        }
    }

}