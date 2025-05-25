package com.example.mvi_count

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountViewModel @Inject constructor(
    private val repository: CountRepository
) : ViewModel() {
    private val _state = MutableStateFlow(CountState())
    val state: StateFlow<CountState> = _state

    init {
        viewModelScope.launch {
            val count = repository.getCount()
            _state.value = _state.value.copy(count = count)
        }
    }

    fun onIntent(intent: CountIntent) {
        when (intent) {
            is CountIntent.Increment -> {
                val newCount = _state.value.count + 1
                _state.value = _state.value.copy(count = newCount)
                viewModelScope.launch { repository.saveCount(newCount) }
            }
            is CountIntent.Decrement -> {
                val newCount = _state.value.count - 1
                _state.value = _state.value.copy(count = newCount)
                viewModelScope.launch { repository.saveCount(newCount) }
            }
            is CountIntent.Reset -> {
                _state.value = _state.value.copy(count = 0)
                viewModelScope.launch { repository.saveCount(0) }
            }
        }
    }
}
