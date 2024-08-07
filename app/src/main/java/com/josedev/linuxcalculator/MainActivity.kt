package com.josedev.linuxcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.josedev.linuxcalculator.components.BannerAd
import com.josedev.linuxcalculator.presentation.ChmodViewModel
import com.josedev.linuxcalculator.screens.ChmodScreen
import com.josedev.linuxcalculator.ui.theme.LinuxCalculatorTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.Arrays

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val chmodViewModel by viewModels<ChmodViewModel>()
        setContent {
            MobileAds.initialize(this)
            val testDeviceIds = Arrays.asList("5B298B6B9E4E430B3E0A662F96753A7F")
            val configuration = RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build()
            MobileAds.setRequestConfiguration(configuration)
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
    BannerAd(
        modifier = Modifier.fillMaxWidth(),
        adId = getString(R.string.ad_id)
//        adId = "ca-app-pub-3940256099942544/6300978111"
    )
}



                }
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }

            }
        }
    }
}
