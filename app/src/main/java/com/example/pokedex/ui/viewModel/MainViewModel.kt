package com.example.pokedex.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.PokemonDataSouce
import com.example.pokedex.di.IoDispatcher
import com.example.pokedex.domain.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val pokemonDataSource: PokemonDataSouce,
    @IoDispatcher val dispatcher: CoroutineDispatcher
) : ViewModel() {
    var pokemons = MutableLiveData<List<Pokemon?>>()

    fun loadPokemons() {
        viewModelScope.launch(dispatcher) {
            val pokemonsApiResult = pokemonDataSource.listPokemons(dispatcher, 150)

            pokemonsApiResult?.results?.let { it ->
                pokemons.postValue(it.map { pokemonResult ->
                    val number = pokemonResult.url
                        .replace("https://pokeapi.co/api/v2/pokemon/", "")
                        .replace("/", "").trim().toInt()

                    val pokemomResult = pokemonDataSource.getPokemons(dispatcher, number)

                    pokemomResult?.let {
                        Pokemon(
                            pokemomResult.id,
                            pokemomResult.name,
                            pokemomResult.base_experience,
                            pokemomResult.height,
                            pokemomResult.weight,
                            pokemomResult.types.map {
                                it.type
                            },
                            pokemomResult.abilities.map {
                                it.ability
                            }
                        )
                    }
                })
            }
        }
    }
}