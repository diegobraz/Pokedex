package com.example.pokedex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.ui.adapter.PokemonListAdapter
import com.example.pokedex.api.domain.Pokemon
import com.example.pokedex.ui.viewModel.ViewModelFactory
import com.example.pokedex.ui.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this, ViewModelFactory())
            .get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.init()
        viewModel.pokemons.observe(this, Observer {
            when {
                it.isEmpty() -> {
                    main_progress_bar.visibility = View.VISIBLE
                }

                it.isNotEmpty() -> {
                    main_progress_bar.visibility = View.GONE
                }
            }
            loadReclycleView(it)
        }
        )
    }

    private fun loadReclycleView(pokemons: List<Pokemon?>) {
        val recyclerView = findViewById<RecyclerView>(R.id.poke_list)
        recyclerView.post {
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = PokemonListAdapter(pokemons)
        }
    }
}