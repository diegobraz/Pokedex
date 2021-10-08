package com.example.pokedex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.ui.adapter.PokemonListAdapter
import com.example.pokedex.domain.Pokemon
//import com.example.pokedex.ui.viewModel.ViewModelFactory
import com.example.pokedex.ui.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_splash.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)
            .get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Glide.with(this).asGif().load(R.drawable.picachu).into(pokemon_load)
        viewModel.loadPokemons()
        viewModel.pokemons.observe(this, Observer {
            when {
                it.isEmpty() -> {
                    pokemon_load.visibility = View.VISIBLE
                }

                it.isNotEmpty() -> {
                    pokemon_load.visibility = View.GONE
                }
            }
            loadReclycleView(it)
        })
    }

    private fun loadReclycleView(pokemons: List<Pokemon?>) {
        val recyclerView = findViewById<RecyclerView>(R.id.poke_list)
        recyclerView.post {
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = PokemonListAdapter(pokemons)
        }
    }
}