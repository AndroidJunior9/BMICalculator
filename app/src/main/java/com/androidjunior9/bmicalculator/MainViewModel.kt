package com.androidjunior9.bmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var state by mutableStateOf(BmiState())

    private fun calculateBmi(){
        state = if(state.height.isNotBlank() && state.weight.isNotBlank()) {
            val heightInMeters = state.height.toFloat() / 100
            val newBmi = state.weight.toFloat() / (heightInMeters * heightInMeters)
            calculateWeightBounds()
            val cat = findCategory(newBmi)
            state.copy(
                BMI = newBmi,
                category = cat
            )
        }else{
            state.copy(
                BMI = 0f
            )
        }

    }
    private fun calculateWeightBounds(){
        val heightInMeters = state.height.toFloat()/100f
        val lWeight = 18*(heightInMeters*heightInMeters)
        val hWeight = 24*(heightInMeters*heightInMeters)
        state = state.copy(
            lowerWeightBound = lWeight,
            higherWeightBound = hWeight
        )
    }

    private fun findCategory(bmi:Float):Category{
        return if (bmi<=18){
            Category.Underweight
        }else if (bmi<=24){
            Category.Normal
        }else if(bmi<=30){
            Category.Overweight
        }else {
            Category.Obese
        }
    }

    fun changeWeight(weight:String){
        state = state.copy(
            weight = weight
        )
        calculateBmi()
    }
    fun changeHeight(height:String){
        state = state.copy(
            height = height
        )
        calculateBmi()
    }
}