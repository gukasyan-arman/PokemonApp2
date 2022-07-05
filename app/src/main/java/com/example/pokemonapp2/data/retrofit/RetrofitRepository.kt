package com.example.pokemonapp2.data.retrofit

import com.example.pokemonapp2.data.retrofit.api.RetrofitInstance
import com.example.pokemonapp2.models.Pokemon
import retrofit2.Response

class RetrofitRepository {
    suspend fun getAllPokemons(): Response<Pokemon> {
        return RetrofitInstance.api.getAllPokemons()
    }
}