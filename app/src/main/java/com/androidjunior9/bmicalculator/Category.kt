package com.androidjunior9.bmicalculator

import androidx.compose.ui.graphics.Color
import com.androidjunior9.bmicalculator.ui.theme.NeonOrange

enum class Category(val color: Color) {
    Underweight(Color.Cyan),
    Normal(Color.Green),
    Overweight(NeonOrange),
    Obese(Color.Red),
}