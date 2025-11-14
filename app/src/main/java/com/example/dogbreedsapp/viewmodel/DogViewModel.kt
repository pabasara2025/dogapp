package com.example.dogbreedsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedsapp.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DogUiState(isLoading = true))
    val uiState: StateFlow<DogUiState> = _uiState

    init {
        fetchDogs()
    }

    private fun fetchDogs() {
        viewModelScope.launch {
            try {
                _uiState.value = DogUiState(isLoading = true)
                val response = RetrofitClient.apiService.getRandomDogs()
                _uiState.value = DogUiState(isLoading = false, dogs = response.message)
            } catch (e: Exception) {
                _uiState.value = DogUiState(isLoading = false, error = e.localizedMessage)
            }
        }
    }
}
