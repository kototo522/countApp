package com.example.mvi_count

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvi_count.ui.theme.Mvi_countTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mvi_countTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Count(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Count(modifier: Modifier = Modifier) {
    Column() {
        Text(
            text = "Count: ",
            modifier = modifier
        )
        Button(onClick = {  }) {
            Text(text = "Count Up")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Mvi_countTheme {
        Count()
    }
}

