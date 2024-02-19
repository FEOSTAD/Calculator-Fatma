package com.example.mathcalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mathcalculator.ui.theme.CalculatorButton
import com.example.mathcalculator.ui.theme.ColorButtonPrimary
import com.example.mathcalculator.ui.theme.ColorButtonTop
import com.example.mathcalculator.ui.theme.ColorOrange

@Composable
fun Calculator(
    state: State,
    buttonSpacing: Dp,
    modifier: Modifier = Modifier,
    onAction: (Actions) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.calcOperations?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 100.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "AC",
                    modifier = Modifier
                        .background(ColorButtonTop)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Clear)
                    }
                )
                CalculatorButton(symbol = "⌫",
                    modifier = Modifier
                        .background(ColorButtonTop)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Delete)
                    }
                )
                CalculatorButton(symbol = "%",
                    modifier = Modifier
                        .background(ColorButtonTop)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.CalcOperations(Operations.Modulo))
                    }
                )
                CalculatorButton(symbol = "÷",
                    modifier = Modifier
                        .background(ColorOrange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.CalcOperations(Operations.Divide))
                    }
                )

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "7",
                    modifier = Modifier
                        .background(ColorButtonPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(number = 7))
                    }
                )
                CalculatorButton(symbol = "8",
                    modifier = Modifier
                        .background(ColorButtonPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(number = 8))
                    }
                )
                CalculatorButton(symbol = "9",
                    modifier = Modifier
                        .background(ColorButtonPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(number = 9))
                    }
                )
                CalculatorButton(symbol = "X",
                    modifier = Modifier
                        .background(ColorOrange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.CalcOperations(Operations.Multiply))
                    }
                )

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "4",
                    modifier = Modifier
                        .background(ColorButtonPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(number = 4))
                    }
                )
                CalculatorButton(symbol = "5",
                    modifier = Modifier
                        .background(ColorButtonPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(number = 5))
                    }
                )
                CalculatorButton(symbol = "6",
                    modifier = Modifier
                        .background(ColorButtonPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(number = 6))
                    }
                )
                CalculatorButton(symbol = "-",
                    modifier = Modifier
                        .background(ColorOrange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.CalcOperations(Operations.Subtract))
                    }
                )

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "1",
                    modifier = Modifier
                        .background(ColorButtonPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(number = 1))
                    }
                )
                CalculatorButton(symbol = "2",
                    modifier = Modifier
                        .background(ColorButtonPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(number = 2))
                    }
                )
                CalculatorButton(symbol = "3",
                    modifier = Modifier
                        .background(ColorButtonPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Number(number = 3))
                    }
                )
                CalculatorButton(symbol = "+",
                    modifier = Modifier
                        .background(ColorOrange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.CalcOperations(Operations.Add))
                    }
                )

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(symbol = "0",
                    modifier = Modifier
                        .background(ColorButtonPrimary)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(Actions.Number(number = 0))
                    }
                )
                CalculatorButton(symbol = ".",
                    modifier = Modifier
                        .background(ColorButtonPrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Decimal)
                    }
                )
                CalculatorButton(symbol = "=",
                    modifier = Modifier
                        .background(ColorOrange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(Actions.Calculate)
                    }
                )

            }


        }
    }
}