package com.example.pokemonapp2.data.retrofit.api

import com.example.pokemonapp2.models.Pokemon
import com.example.pokemonapp2.utils.END_POINT
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET(END_POINT)
    suspend fun getAllPokemons(): Response<Pokemon>
}