package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.adapter.PokemonListAdapter
import com.example.pokedex.api.PokeRespositore
import com.example.pokedex.api.domain.Pokemon
import com.example.pokedex.api.domain.PokemonType
import com.example.pokedex.api.model.PokemonsApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        Thread(Runnable {
            loadPokemons()

        }).start()

    }

    private fun loadPokemons() {

        val pokemonsApiResult = PokeRespositore.listPokemons()

        pokemonsApiResult?.results?.let {


            val pokemon: List<Pokemon?> = it.map { pokemonResult ->
                val  number = pokemonResult.url.replace("https://pokeapi.co/api/v2/pokemon/","")
                    .replace("/","").trim().toInt()
               val pokemoResult = PokeRespositore.getPokemon(number)


                pokemoResult?.let {

                    Pokemon(
                        pokemoResult.id,
                        pokemoResult.name,
                        pokemoResult.types.map {
                            it.type
                        }


                    )
                }


            }

            val recyclerView = findViewById<RecyclerView>(R.id.poke_list)
            recyclerView.post{
                val layoutManager = LinearLayoutManager(this)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PokemonListAdapter(pokemon)

            }

        }



    }
}