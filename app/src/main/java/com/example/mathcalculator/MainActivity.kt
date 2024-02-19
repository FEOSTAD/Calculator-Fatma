package com.example.mathcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mathcalculator.ui.theme.MathCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MathCalculatorTheme {
                val viewModel = viewModel<CalcViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                Calculator(
                    state = state,
                    buttonSpacing = buttonSpacing,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.DarkGray)
                        .padding(16.dp)

                )
            }
        }
    }
}
