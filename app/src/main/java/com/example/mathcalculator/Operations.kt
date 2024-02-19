package com.example.mathcalculator

sealed class Operations(val symbol: String) {
    object Add : Operations(symbol = "+")
    object Subtract : Operations(symbol = "-")
    object Multiply : Operations(symbol = "×")
    object Divide : Operations(symbol = "÷")
    object Modulo : Operations(symbol = "%")
}