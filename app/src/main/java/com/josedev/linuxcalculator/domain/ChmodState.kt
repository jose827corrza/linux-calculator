package com.josedev.linuxcalculator.domain

data class ChmodState(
    val numberCode: String = "000",
    val lettersCode: String = "---------", // 0..9
    val userR: Number = 0,
    val userW: Number = 0,
    val userE: Number = 0
)
