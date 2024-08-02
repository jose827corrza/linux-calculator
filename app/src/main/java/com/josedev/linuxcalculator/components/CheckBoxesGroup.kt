package com.josedev.linuxcalculator.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                })
            Text(
                text = "Reading",
                fontSize = 8.sp
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
                })
            Text(
                text = "Writing",
                fontSize = 8.sp
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
                })
            Text(
                text = "Execution",
                fontSize = 8.sp
            )
        }
        
    }
}

@Preview
@Composable
private fun CheckBoxesGroupPreview() {
//    CheckBoxesGroup()
}