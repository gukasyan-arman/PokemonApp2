package com.example.pokemonapp2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp2.data.retrofit.RetrofitRepository
import com.example.pokemonapp2.models.PokemonsResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {
    val repository = RetrofitRepository()
    val pokemons: MutableLiveData<Response<PokemonsResponse>> = MutableLiveData()

    fun getAllPokemons() {
        viewModelScope.launch {
            pokemons.value = repository.getAllPokemons()
        }
    }

}