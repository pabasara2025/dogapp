package com.example.dogbreedsapp.viewmodel

data class DogUiState(
    val isLoading: Boolean = false,
    val dogs: List<String> = emptyList(),
    val error: String? = null
)
