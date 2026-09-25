package com.example.corrutinasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.corrutinasapp.ui.CoroutinesApp
import com.example.corrutinasapp.ui.theme.CorrutinasAppTheme
import com.example.corrutinasapp.viewmodel.MainViewModel
import kotlin.getValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()

        enableEdgeToEdge()
        setContent {
            CorrutinasAppTheme(false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoroutinesApp(
                        viewModel,
                        modifier = Modifier.padding(
                            innerPadding
                        ))
                }
            }
        }
    }
}


