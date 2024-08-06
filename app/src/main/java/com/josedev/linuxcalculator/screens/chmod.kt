package com.josedev.linuxcalculator.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.josedev.linuxcalculator.components.SwitchGroup
import com.josedev.linuxcalculator.presentation.ChmodViewModel
import com.josedev.linuxcalculator.repository.ChmodEvent
import com.josedev.linuxcalculator.ui.theme.Purple40
import com.josedev.linuxcalculator.ui.theme.Purple80
import com.josedev.linuxcalculator.utils.Classes

@Composable
fun ChmodScreen(
    modifier: Modifier = Modifier,
    chmodViewModel: ChmodViewModel
) {

    val state by chmodViewModel.state.collectAsState()

    var userReadingState by remember { // 4
        mutableStateOf(false)
    }
    var userWritingState by remember { // 2
        mutableStateOf(false)
    }
    var userExecutingState by remember { // 1
        mutableStateOf(false)
    }
    var groupReadingState by remember { // 4
        mutableStateOf(false)
    }
    var groupWritingState by remember { // 2
        mutableStateOf(false)
    }
    var groupExecutingState by remember { // 1
        mutableStateOf(false)
    }
    var otherReadingState by remember { // 4
        mutableStateOf(false)
    }
    var otherWritingState by remember { // 2
        mutableStateOf(false)
    }
    var otherExecutingState by remember { // 1
        mutableStateOf(false)
    }



    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment  = Alignment.CenterHorizontally,
    ) {
        Text(
            text = " CHMOD PERMISSIONS",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            modifier = Modifier.padding(0.dp, 20.dp),
            color = Color.Green
        )
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ){

            Column (
                modifier = Modifier
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = "Numbers",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(1.dp),
                        color = Color.Green
                    )
                    Text(
                        text = state.user.toString() + state.group.toString() + state.other.toString(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 38.sp,
                        modifier = Modifier.padding(),
                        color = Purple80
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
//                Column (
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ){
//                    Text(
//                        text = "Letters",
//                        fontWeight = FontWeight.ExtraBold,
//                        fontSize = 24.sp,
//                        modifier = Modifier.padding(1.dp)
//                    )
//                    Text(
//                        text = state.lettersCode,
//                        fontWeight = FontWeight.Normal,
//                        fontSize = 24.sp,
//                        modifier = Modifier.padding()
//                    )
//                }
            }

        }
        Spacer(modifier = Modifier.size(10.dp))
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){

            Row {
                Column (
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.7f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = "Users", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp), color = Color.Green)
                    SwitchGroup(
                        modifier = Modifier.fillMaxHeight(),
                        fourthValue = userReadingState,
                        fourthValueFun = {
                            userReadingState = !it
                            chmodViewModel.onEvent(
                                ChmodEvent.PermissionChanged(
                                    Classes.USER,
                                    userReadingState,
                                    userWritingState,
                                    userExecutingState
                                )
                            )
                        },
                        secondValue = userWritingState,
                        secondValueFun = {
                            userWritingState = !it
                            chmodViewModel.onEvent(
                                ChmodEvent.PermissionChanged(
                                    Classes.USER,
                                    userReadingState,
                                    userWritingState,
                                    userExecutingState
                                )
                            )
                        },
                        firstValue = userExecutingState,
                        firstValueFun = {
                            userExecutingState = !it
                            chmodViewModel.onEvent(
                                ChmodEvent.PermissionChanged(
                                    Classes.USER,
                                    userReadingState,
                                    userWritingState,
                                    userExecutingState
                                )
                            )
                        }
                    )

                }
                Column (
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = "Groups", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp), color = Color.Green)
                    SwitchGroup(
                        modifier = Modifier.fillMaxHeight(),
                        fourthValue = groupReadingState,
                        fourthValueFun = {
                            groupReadingState = !it
                            chmodViewModel.onEvent(
                                ChmodEvent.PermissionChanged(
                                    Classes.GROUP,
                                    groupReadingState,
                                    groupWritingState,
                                    groupExecutingState

                                )
                            )
                        },
                        secondValue = groupWritingState,
                        secondValueFun = {
                            groupWritingState = !it
                            chmodViewModel.onEvent(
                                ChmodEvent.PermissionChanged(
                                    Classes.GROUP,
                                    groupReadingState,
                                    groupWritingState,
                                    groupExecutingState

                                )
                            )
                        },
                        firstValue = groupExecutingState,
                        firstValueFun = {
                            groupExecutingState = !it
                            chmodViewModel.onEvent(
                                ChmodEvent.PermissionChanged(
                                    Classes.GROUP,
                                    groupReadingState,
                                    groupWritingState,
                                    groupExecutingState

                                )
                            )
                        }
                    )
                }
                Column (
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = "Others", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(10.dp), color = Color.Green)
                    SwitchGroup(
                        modifier = Modifier.fillMaxHeight(),
                        fourthValue = otherReadingState,
                        fourthValueFun = {
                            otherReadingState = !it
                            chmodViewModel.onEvent(
                                ChmodEvent.PermissionChanged(
                                    Classes.OTHER,
                                    otherReadingState,
                                    otherWritingState,
                                    otherExecutingState

                                )
                            )
                        },
                        secondValue = otherWritingState,
                        secondValueFun = {
                            otherWritingState = !it
                            chmodViewModel.onEvent(
                                ChmodEvent.PermissionChanged(
                                    Classes.OTHER,
                                    otherReadingState,
                                    otherWritingState,
                                    otherExecutingState

                                )
                            )
                        },
                        firstValue = otherExecutingState,
                        firstValueFun = {
                            otherExecutingState = !it
                            chmodViewModel.onEvent(
                                ChmodEvent.PermissionChanged(
                                    Classes.OTHER,
                                    otherReadingState,
                                    otherWritingState,
                                    otherExecutingState

                                )
                            )
                        }
                    )
                }
            }
        }
    }

}



@Preview(showSystemUi = true, showBackground = true
)
@Composable
private fun ChmodScreenPreview() {
    //ChmodScreen()
}