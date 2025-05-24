package com.example.mvi_count

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CountViewModel : ViewModel() {
    private val _state = MutableStateFlow(CountState())
    val state: StateFlow<CountState> = _state

    fun onIntent(intent: CountIntent) {
        when (intent) {
            is CountIntent.Increment -> {
                _state.value = _state.value.copy(count = _state.value.count + 1)
            }
        }
    }
}

