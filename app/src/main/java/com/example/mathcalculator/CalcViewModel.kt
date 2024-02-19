package com.example.mathcalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcViewModel : ViewModel() {
    var state by mutableStateOf(State())
        private set

    fun onAction(action: Actions) {
        when (action) {
            is Actions.Number -> enterNumber(action.number)
            is Actions.Decimal -> enterDecimal()
            is Actions.Delete -> delete()
            is Actions.Clear -> state = State()
            is Actions.CalcOperations -> enterOperation(action.operation)
            is Actions.Calculate -> performCalculation()
        }
    }

    private fun delete() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 = state.number2.dropLast(1)
            )

            state.calcOperations != null -> state = state.copy(
                calcOperations = null
            )

            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    private fun enterNumber(number: Int) {

        if (state.calcOperations == null) {
            if (state.number1.length >= 8) {
                return
            }

            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= 8) {
            return
        }
        state = state.copy(number2 = state.number2 + number)

    }

    private fun enterDecimal() {
        if (state.calcOperations == null && !state.number1.contains(".") && state.number1.isNotBlank()) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()) {
            state = state.copy(
                number1 = state.number2 + "."
            )
            return
        }


    }

    private fun enterOperation(calcOperations: Operations) {
        if (state.number1.isNotBlank()) {
            state = state.copy(calcOperations = calcOperations)
        }
    }

    private fun performCalculation() {

        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.calcOperations) {
                is Operations.Add -> number1 + number2
                is Operations.Subtract -> number1 - number2
                is Operations.Multiply -> number1 * number2
                is Operations.Divide -> number1 / number2
                is Operations.Modulo -> number1 % number2
                null -> return
            }
            state = state.copy(
                number1 = result.toString().take(15),
                number2 = "",
                calcOperations = null
            )
        }
    }
}