package com.josedev.linuxcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.josedev.linuxcalculator.presentation.ChmodViewModel
import com.josedev.linuxcalculator.screens.ChmodScreen
import com.josedev.linuxcalculator.ui.theme.LinuxCalculatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val chmodViewModel by viewModels<ChmodViewModel>()
        setContent {
            LinuxCalculatorTheme {
                Surface (
                    color = MaterialTheme.colorScheme.background
                ){

Column {
    ChmodScreen(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        chmodViewModel = chmodViewModel
    )
}



                }
            }
        }
    }
}
