package com.example.pokemonapp2.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemonapp2.R
import com.example.pokemonapp2.databinding.PokemonItemBinding
import com.example.pokemonapp2.models.Pokemon

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var pokemons = mutableListOf<Pokemon>()

    fun setList(list: List<Pokemon>) {
        pokemons.clear()
        pokemons.addAll(list)
        notifyDataSetChanged()
    }

//    private var pokemons = emptyList<Pokemon>()

//    fun setList(list: List<Pokemon>) {
//        pokemons = list
//        notifyDataSetChanged()
//    }

    class MainViewHolder(val binding: PokemonItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PokemonItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.binding.pokemonName.text = pokemon.name
        holder.binding.pokemonRare.text = pokemon.rarity
        Glide.with(holder.itemView.context)
            .load(pokemon.images.small)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.binding.pokemonAvatar)
    }

    override fun getItemCount() = pokemons.size

}