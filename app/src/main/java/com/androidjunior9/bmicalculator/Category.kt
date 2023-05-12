package com.androidjunior9.bmicalculator

import androidx.compose.ui.graphics.Color
import com.androidjunior9.bmicalculator.ui.theme.Blue
import com.androidjunior9.bmicalculator.ui.theme.Green
import com.androidjunior9.bmicalculator.ui.theme.Orange
import com.androidjunior9.bmicalculator.ui.theme.Red

enum class Category(val color: Color) {
    Underweight(Blue),
    Normal(Green),
    Overweight(Orange),
    Obese(Red),
}