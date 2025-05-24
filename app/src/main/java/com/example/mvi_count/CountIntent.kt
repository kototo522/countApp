package com.example.mvi_count

sealed class CountIntent {
    object Increment : CountIntent()
    object Decrement : CountIntent()
    object Reset : CountIntent()
}

