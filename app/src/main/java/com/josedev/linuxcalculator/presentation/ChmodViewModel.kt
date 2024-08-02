package com.josedev.linuxcalculator.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.josedev.linuxcalculator.domain.ChmodState
import com.josedev.linuxcalculator.repository.ChmodEvent
import com.josedev.linuxcalculator.utils.Classes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class ChmodViewModel: ViewModel() {

    private val _state = MutableStateFlow(ChmodState())
    val state: StateFlow<ChmodState> = _state.asStateFlow()

// Use the replaceRange to update the strings
    fun onEvent(event: ChmodEvent) {
        when (event) {
            is ChmodEvent.PermissionChanged -> {
//                _state.value.lettersCode.replaceRange(1,2,"w")
                when (event.group) {
                    Classes.USER -> {
                        
                    }
                    Classes.GROUP -> {

                    }
                    Classes.OTHER -> {

                    }
                }

            }
        }
    }
}