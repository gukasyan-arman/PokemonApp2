package com.example.pokemonapp2.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp2.R
import com.example.pokemonapp2.databinding.FragmentMainBinding
import com.example.pokemonapp2.models.Data
import com.example.pokemonapp2.models.Pokemon
import com.example.pokemonapp2.utils.MainAdapter
import com.example.pokemonapp2.viewmodels.MainViewModel

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.getAllPokemons()
        recyclerView = binding.mainRv
        recyclerView.adapter = adapter
        viewModel.pokemons.observe(this, {
             adapter.setList(it.body()!!)
        })

    }

}