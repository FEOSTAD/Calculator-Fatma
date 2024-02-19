package com.example.mathcalculator

sealed class Actions {
    data class Number(val number: Int) : Actions()
    object Clear : Actions()
    object Decimal : Actions()
    object Calculate : Actions()
    object Delete : Actions()
    data class CalcOperations(val operation: Operations) : Actions()
}
