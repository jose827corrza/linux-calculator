package com.josedev.linuxcalculator.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwitchGroup(
    modifier: Modifier = Modifier,
    fourthValueFun: (Boolean) -> Unit,
    fourthValue: Boolean,
    secondValueFun: (Boolean) -> Unit,
    secondValue: Boolean,
    firstValueFun: (Boolean) -> Unit,
    firstValue: Boolean
) {

    
    Column (modifier = modifier){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Switch(
                checked = fourthValue,
                modifier = Modifier.padding(5.dp, 10.dp),
                onCheckedChange = {
                fourthValueFun(fourthValue)
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Green,
                    checkedBorderColor = Color.Green,
                    checkedTrackColor = Color.hsl(139f, 0.25f, 0.24f),
                    uncheckedThumbColor = Color.hsl(360f, 1.00f, 0.6f),
                    uncheckedTrackColor = Color.hsl(360f, 0.25f, 0.3f),
                ),
                thumbContent = {
                    if (fourthValue) Icon(imageVector = Icons.Filled.Check, contentDescription = "ON")
                }
            )
            Text(
                text = "Reading",
                fontSize = 10.sp,
                color = Color.Green
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Switch(
                checked = secondValue,
                modifier = Modifier.padding(5.dp, 10.dp),
                onCheckedChange = {
                secondValueFun(secondValue)
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Green,
                    checkedBorderColor = Color.Green,
                    checkedTrackColor = Color.hsl(139f, 0.25f, 0.24f),
                    uncheckedThumbColor = Color.hsl(360f, 1.00f, 0.6f),
                    uncheckedTrackColor = Color.hsl(360f, 0.25f, 0.3f),
                ),
                thumbContent = {
                    if (secondValue) Icon(imageVector = Icons.Filled.Check, contentDescription = "ON")
                }
            )
            Text(
                text = "Writing",
                fontSize = 10.sp,
                color = Color.Green
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Switch(
                checked = firstValue,
                modifier = Modifier.padding(5.dp, 10.dp),
                onCheckedChange = {
                firstValueFun(firstValue)
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.Green,
                    checkedBorderColor = Color.Green,
                    checkedTrackColor = Color.hsl(139f, 0.25f, 0.24f),
                    uncheckedThumbColor = Color.hsl(360f, 1.00f, 0.6f),
                    uncheckedTrackColor = Color.hsl(360f, 0.25f, 0.3f),
                ),
                thumbContent = {
                    if (firstValue) Icon(imageVector = Icons.Filled.Check, contentDescription = "ON")
                }
            )
            Text(
                text = "Execution",
                fontSize = 10.sp,
                color = Color.Green
            )
        }
        
    }
}

@Preview
@Composable
private fun CheckBoxesGroupPreview() {
//    CheckBoxesGroup()
}