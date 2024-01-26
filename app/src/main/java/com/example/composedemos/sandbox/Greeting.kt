package com.example.composedemos.sandbox

import android.view.RoundedCorner
import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val names = listOf<String>("Mauro", "Antonio", "Mimmo")

@Composable
fun Greetings(names: List<String>) {
    Column {
        for (name in names) {
            Text("Hello $name")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }
    var extraPadding = if (expanded) 98.dp else 0.dp
    Row(modifier = Modifier
        .padding(5.dp)
        .background(
            color = MaterialTheme.colorScheme.primary,
            shape = RoundedCornerShape(10.dp)
        )
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
        ) {
            Text("Hello, $name", modifier = Modifier.padding(10.dp))
        }
        ElevatedButton(onClick = { expanded = !expanded }, modifier = Modifier.padding(10.dp)) {
            Text(if (expanded) "Show less" else "Show more")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Greeting(name = "Antonio", modifier = Modifier)
}

/**
 * Display a list of names the user can click with a header
 */
@Composable
fun NamePicker(
    header: String,
    names: List<String>,
    onNameClicked: (String) -> Unit
) {
    Column {
        // this will recompose when [header] changes but not wen [name] changes
        Text(header, style = MaterialTheme.typography.bodyLarge)
        Divider()

        LazyColumn {
            items(names) { name ->
                NamePickerItem(name, onNameClicked)
            }
        }
    }
}

@Composable
private fun NamePickerItem(name: String, onClicked: (String) -> Unit) {
    Text(name, Modifier.clickable(onClick = { onClicked(name) }))
}

@Preview(showBackground = true)
@Composable
fun NamePickerPreview() {
    NamePicker(header = "Names", names = names, onNameClicked = {})
}
