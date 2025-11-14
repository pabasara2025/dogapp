package com.example.dogbreedsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dogbreedsapp.ui.DogScreen
import com.example.dogbreedsapp.ui.theme.DogbreedsappTheme
import com.example.dogbreedsapp.viewmodel.DogViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            DogbreedsappTheme {
                val dogViewModel: DogViewModel = viewModel()
                DogScreen(
                    viewModel = dogViewModel,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
