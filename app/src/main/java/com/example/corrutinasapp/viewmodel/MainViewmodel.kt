package com.example.corrutinasapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var resultState: String by mutableStateOf("")
        private set
    var countTime by mutableIntStateOf(0)
        private set
    var countTime2 by mutableIntStateOf(0)
        private set
    var countN by mutableStateOf(2)
        private set
    var isRunning by mutableStateOf(false)
        private set
    private var job: Job? = null

    fun fetchData() {
        viewModelScope.launch {
            for (i in 1..5) {
                delay(1000)
                countTime = i
            }
        }
        viewModelScope.launch {
            delay(5000)
            resultState = "Respuesta obtenida de la Web"
        }
    }

    fun fetchDataTimer() {
        job = viewModelScope.launch {
            isRunning = true

            for (i in 1..countN) {
                delay(1000)
                countTime = i
            }

            for (i in 1..countN) {
                delay(1000)
                countTime2 = i
            }

            resultState = "Respuesta obtenida de la Web"
            countN++
            isRunning = false
        }
    }

    fun cancelarProceso() {
        job?.cancel()
        isRunning = false
        resultState = "Proceso cancelado"
    }

    fun limpiarContadores() {
        job?.cancel()
        resultState = ""
        countN = 2
        countTime = 0
        countTime2 = 0
        isRunning = false
    }
}