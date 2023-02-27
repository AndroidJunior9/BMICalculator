package com.androidjunior9.bmicalculator

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.math.RoundingMode
import java.text.DecimalFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier:Modifier = Modifier,
    viewModel: MainViewModel
){
    val state = viewModel.state
    val weight = state.weight
    val height = state.height
    val bmi = state.BMI
    val lWeight = state.lowerWeightBound
    val hWeight = state.higherWeightBound
    val context = LocalContext.current
    val category = state.category
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.DOWN
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Box(Modifier.padding(vertical = 16.dp), contentAlignment = Alignment.Center) {
            Text(
                text = "Calculate BMI",
                color = Color.Green,
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium
            )
        }


        Row(
            verticalAlignment = Alignment.Bottom
        ) {


            TextField(
                value = height,
                onValueChange = {
                    if (state.height.isBlank() && it == ".") {
                        Toast.makeText(
                            context, "Error", Toast.LENGTH_LONG
                        ).show()
                    } else
                        viewModel.changeHeight(it)
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Green,
                    fontWeight = FontWeight.Bold
                ),
                label = {
                    Text(
                        "Height",
                        color = Color.White
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Green,
                    unfocusedIndicatorColor = Color.White,
                    containerColor = Color.Black
                )
            )
            Spacer(
                modifier = Modifier.width(6.dp)
            )
            Text(
                text = "cm",
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Light
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.Bottom) {
            TextField(
                value = weight,
                onValueChange = {
                    if (state.weight.isBlank() && it == ".") {
                        Toast.makeText(
                            context, "Error", Toast.LENGTH_LONG
                        ).show()
                    } else
                        viewModel.changeWeight(it)
                },
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Green,
                    fontWeight = FontWeight.Bold
                ),
                label = {
                    Text(
                        "Weight",
                        color = Color.White
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Green,
                    unfocusedIndicatorColor = Color.White,
                    containerColor = Color.Black
                )
            )
            Spacer(
                modifier = Modifier.width(6.dp)
            )
            Text(
                text = "kg",
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Light
            )
        }



        Box(Modifier.padding(vertical = 16.dp), contentAlignment = Alignment.Center) {
            Text(
                text = category.name,
                color = category.color,
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // Circular Progress bar with text in the center Custom Box
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 64.dp)
                .size(250.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if(bmi>100) ">100" else df.format(bmi),
                color = Color.White,
                fontSize = 64.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
            )
            CircularProgressIndicator(
                progress = getProgress(bmi),
                color = category.color,
                strokeWidth = 16.dp,
                modifier = Modifier.fillMaxSize(),
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Text(
                "Normal Weight",
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                "${lWeight.toInt()} - ${hWeight.toInt()}",
                fontSize = 16.sp,
                color = Color.White
            )


        }

    }
}
fun getProgress(
    bmi: Float
): Float {
    var progress = 0f
    if (bmi==0f){
        progress = 0f
    }
    else if (bmi < 18.5) {
        progress = .1f
    } else if (bmi >= 18.5 && bmi < 24.9) {
        progress = .5f
    } else if (bmi >= 24.9 && bmi < 30) {
        progress = .75f
    } else if (bmi >= 30) {
        progress = 1f
    }
    return progress
}

