package com.josedev.linuxcalculator.domain

data class ChmodState(
    val numberCode: String = "000",
    val lettersCode: String = "---------", // 0..9
    val user: Number = 0,
    val group: Number = 0,
    val other: Number = 0
)
