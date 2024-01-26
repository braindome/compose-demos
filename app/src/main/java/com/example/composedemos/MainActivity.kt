package com.example.composedemos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.composedemos.sandbox.CardDemo
import com.example.composedemos.sandbox.Greeting
import com.example.composedemos.sandbox.Greetings
import com.example.composedemos.sandbox.ScaffoldDemo
import com.example.composedemos.ui.theme.ComposeDemosTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val nameList = listOf("Antonio", "Maurizio", "Giovanni")
            ComposeDemosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // GMaps
                    // POIScreen()

                    // State demo
                    //WellnessScreen()

                    // Sandbox
                    //Greetings(names = nameList )
                    // Greeting(name = "Mimmuz", modifier = Modifier)
                    /*
                    Column {

                        Greeting(name = "Mimmuz", modifier = Modifier)
                        Greeting(name = "Mimmuz", modifier = Modifier)
                    }

                    */

                    // Card
                    // CardDemo()

                    // Layouts
                    // 1. Scaffold
                    ScaffoldDemo()
                }
            }
        }
    }
}

