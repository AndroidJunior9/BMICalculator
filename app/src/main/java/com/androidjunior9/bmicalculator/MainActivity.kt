package com.androidjunior9.bmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import com.androidjunior9.bmicalculator.ui.theme.BMICalculatorTheme
import com.androidjunior9.bmicalculator.ui.theme.BackGround
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorTheme {
                val viewModel = MainViewModel()
                val systemUiController = rememberSystemUiController()

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = BackGround, //Your color
                        darkIcons = false
                    )
                }
                MainScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = BackGround),
                    viewModel = viewModel
                )
            }
        }
    }
}

