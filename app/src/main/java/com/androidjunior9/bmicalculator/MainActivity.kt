package com.androidjunior9.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.androidjunior9.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorTheme {
                val viewModel = MainViewModel()
                MainScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Black),
                    viewModel = viewModel
                )
            }
        }
    }
}

