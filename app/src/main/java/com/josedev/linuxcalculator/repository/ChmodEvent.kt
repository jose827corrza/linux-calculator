package com.josedev.linuxcalculator.repository

import com.josedev.linuxcalculator.utils.Classes

sealed interface ChmodEvent {
//    data class PermissionChanged(val group: String, val value: Number): ChmodEvent
    data class PermissionChanged(
    val group: Classes,
    val reading: Boolean,
    val writing: Boolean,
    val execute: Boolean
        ): ChmodEvent
}