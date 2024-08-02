package com.josedev.linuxcalculator.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CheckBoxesGroup(
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
            Checkbox(checked = fourthValue, onCheckedChange = {
                fourthValueFun(fourthValue)
            })
            Text(text = "Reading")
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(checked = secondValue, onCheckedChange = { secondValueFun(secondValue) })
            Text(text = "Writing")
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(checked = firstValue, onCheckedChange = { firstValueFun(firstValue) })
            Text(text = "Execution")
        }
        
    }
}

@Preview
@Composable
private fun CheckBoxesGroupPreview() {
//    CheckBoxesGroup()
}