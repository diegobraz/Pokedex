package com.example.pokedex.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.api.PokeRespositore
import com.example.pokedex.domain.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    var pokemons = MutableLiveData<List<Pokemon?>>()

    fun init() {

        Thread(Runnable {

            loadPokemons()

        }).start()

    }

    private fun loadPokemons() {
//
//        val pokemonsApiResult = PokeRespositore.listPokemons()
//
//        pokemonsApiResult?.results?.let {
//
//            pokemons.postValue(it.map { pokemonResult ->
//                val number = pokemonResult.url.replace("https://pokeapi.co/api/v2/pokemon/", "")
//                    .replace("/", "").trim().toInt()
//                val pokemoResult = PokeRespositore.getPokemon(number)
//
//                pokemoResult?.let {
//
//                    Pokemon(
//                        pokemoResult.id,
//                        pokemoResult.name,
//                        pokemoResult.types.map {
//                            it.type
//                        }
//                    )
//                }
//            }
//            )
//        }
    }
}