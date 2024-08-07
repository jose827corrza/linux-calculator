package com.josedev.linuxcalculator.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import java.util.Arrays

@Composable
fun BannerAd(modifier: Modifier = Modifier, adId: String) {
            AndroidView(
                modifier = modifier.fillMaxWidth().background(Color.Black),
                factory = { contextId ->
                    AdView(contextId).apply {
                        setAdSize(AdSize.BANNER)
                        adUnitId = adId

                        // Requesting an ad
                        loadAd(AdRequest.Builder().build())
                    }
                })
}