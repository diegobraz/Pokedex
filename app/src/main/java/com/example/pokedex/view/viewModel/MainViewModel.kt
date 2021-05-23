package com.example.pokedex.view.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.adapter.PokemonListAdapter
import com.example.pokedex.api.PokeRespositore
import com.example.pokedex.api.domain.Pokemon

class MainViewModel: ViewModel() {


    var pokemons = MutableLiveData<List<Pokemon?>>()


    fun init(){

        Thread(Runnable {

            loadPokemons()

        }).start()


    }




    private fun loadPokemons() {

        val pokemonsApiResult = PokeRespositore.listPokemons()

        pokemonsApiResult?.results?.let {

            pokemons.postValue( it.map { pokemonResult ->
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
            )



        }



    }
}