package com.example.mvi_count

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvi_count.ui.theme.Mvi_countTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val countViewModel: CountViewModel by viewModels()
        setContent {
            Mvi_countTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Count(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = countViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun Count(modifier: Modifier = Modifier, viewModel: CountViewModel) {
    val state = viewModel.state.collectAsState()
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Count: ${state.value.count}",
        )
        Button(onClick = { viewModel.onIntent(CountIntent.Increment) }) {
            Text(text = "Count Up")
        }
        Button(onClick = { viewModel.onIntent(CountIntent.Decrement )}) {
            Text(text = "Count down")
        }
        Button(onClick = { viewModel.onIntent(CountIntent.Reset) }) {
            Text(text = "reset")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val previewViewModel = CountViewModel()
    Mvi_countTheme {
        Count(viewModel = previewViewModel)
    }
}

