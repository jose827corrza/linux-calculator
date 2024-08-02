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
                        var userR = 0
                        var userW = 0
                        var userE = 0
                        if (event.reading) {
                            userR = 4
                        }
                        if(event.writing){
                            userW = 2
                        }
                        if(event.execute){
                            userE = 1
                        }
                        _state.update { it.copy( user = userR + userW + userE) }
                    }
                    Classes.GROUP -> {
                        var groupR = 0
                        var groupW = 0
                        var groupE = 0
                        if (event.reading) {
                            groupR = 4
                        }
                        if(event.writing) {
                            groupW = 2
                        }
                        if (event.execute){
                            groupE = 1
                        }
                        _state.update { it.copy( group = groupR + groupW + groupE) }
                    }
                    Classes.OTHER -> {
                        var otherR = 0
                        var otherW = 0
                        var otherE = 0
                        if (event.reading) {
                            otherR = 4
                        }
                        if(event.writing) {
                            otherW = 2
                        }
                        if (event.execute){
                            otherE = 1
                        }
                        _state.update { it.copy( other = otherR + otherW + otherE) }
                    }
                }

            }
        }
    }
}