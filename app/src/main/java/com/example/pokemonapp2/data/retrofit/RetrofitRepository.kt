package com.example.pokemonapp2.data.retrofit

import com.example.pokemonapp2.data.retrofit.api.RetrofitInstance
import com.example.pokemonapp2.models.PokemonsResponse
import retrofit2.Response

class RetrofitRepository {
    suspend fun getAllPokemons(): Response<PokemonsResponse> {
        return RetrofitInstance.api.getAllPokemons()
    }
}