package com.example.dogbreedsapp.network

import com.example.dogbreedsapp.model.Dog
import retrofit2.http.GET

interface ApiService {
    @GET("breeds/image/random/10")
    suspend fun getRandomDogs(): Dog
}
