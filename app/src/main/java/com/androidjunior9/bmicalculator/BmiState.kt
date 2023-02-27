package com.androidjunior9.bmicalculator

data class BmiState(
    val category: Category = Category.Underweight,
    val weight:String = "",
    val height:String = "",
    val BMI:Float = 0f,
    val lowerWeightBound:Float = 0f,
    val higherWeightBound:Float = 0f
)
