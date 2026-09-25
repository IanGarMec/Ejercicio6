package com.example.corrutinasapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.corrutinasapp.R
import com.example.corrutinasapp.ui.theme.CorrutinasAppTheme
import com.example.corrutinasapp.viewmodel.MainViewModel

@Composable
fun CoroutinesApp(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    CoroutinesAppContent(
        resultState = viewModel.resultState,
        onFetchData = { viewModel.fetchDataTimer() },
        reset = { viewModel.limpiarContadores() },
        onCancel = { viewModel.cancelarProceso() },
        timer = viewModel.countTime,
        timer2 = viewModel.countTime2,
        isRunning = viewModel.isRunning,
        modifier = modifier
    )
}

@Composable
fun CoroutinesAppContent(
    resultState: String,
    onFetchData: () -> Unit,
    reset: () -> Unit,
    onCancel: () -> Unit,
    timer: Int,
    timer2: Int,
    isRunning: Boolean,
    modifier: Modifier = Modifier
){
    var changeColor by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {
                changeColor = !changeColor
            },
            colors = ButtonDefaults.buttonColors(
                if (changeColor) Color.Red else Color.Blue
            )
        ) {
            Text(stringResource(R.string.cambio_de_color))
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text("Contador 1: $timer [s]")
        Text("Contador 2: $timer2 [s]")
        Spacer(modifier = Modifier.height(20.dp))
        Text(resultState)
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                onFetchData()
            },
            enabled = !isRunning
        ) {
            Text(stringResource(R.string.realizar_consulta))
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = onCancel
        ) {
            Text("Cancelar Proceso")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = reset,
            colors = ButtonDefaults.buttonColors(Color.DarkGray)
        ) {
            Text("Reset")
        }
    }
}

@Preview
@Composable
fun CoroutinesAppPreview() {
    CorrutinasAppTheme(darkTheme = false) {
        CoroutinesAppContent(
            resultState = "Respuesta de la Web",
            onFetchData = {},
            reset = {},
            onCancel = {},
            timer = 4,
            timer2 = 2,
            isRunning = true
        )
    }
}


/*
@Preview
@Composable
fun CoroutinesAppPreview(){
    CorrutinasApp2027ITheme(darkTheme = false) {
        CoroutinesApp()
    }
}
*/













