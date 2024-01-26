package com.example.composedemos.sandbox

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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

@Composable
fun CardDemo() {
    Column {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            modifier = Modifier
                .size(width = 240.dp, height = 200.dp)
                .padding(16.dp)
        ) {
            Text(
                text = "Heewwwoooo",
                modifier = Modifier
                    .padding(16.dp),
                textAlign = TextAlign.Center)
        }
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .size(width = 240.dp, height = 200.dp)
                .padding(16.dp)
        ) {
            Text(
                text = "Elevated",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier
                .size(width = 240.dp, height = 100.dp)
                .padding(16.dp)
        ) {
            Text(
                text = "Outlined",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ScaffoldDemo() {


    val colors = listOf(
        Color(0xFFffd7d7.toInt()),
        Color(0xFFffe9d6.toInt()),
        Color(0xFFfffbd0.toInt()),
        Color(0xFFe3ffd9.toInt()),
        Color(0xFFd0fff8.toInt())
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Scaffold Demo") },
                navigationIcon = {
                    IconButton(
                        onClick = { /* "Open nav drawer" */ }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "Description")    
                    }
                }
            
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { /*TODO*/ }
            ) {
                Text("Inc")
            }
        },
        content = {innerPadding ->
            LazyColumn(
                modifier = Modifier.consumeWindowInsets(innerPadding),
                contentPadding = innerPadding
            ) {
                items(count = 100) {
                    Box(modifier = Modifier.fillMaxWidth().height(50.dp).background(colors[it % colors.size]))
                }
            }
        }
    )
}

@Preview
@Composable
fun CardDemoPreview() {
    CardDemo()
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
