package com.example.pokedex.data

import com.example.pokedex.model.PokemonApi
import com.example.pokedex.model.PokemonApiResult
import kotlinx.coroutines.CoroutineDispatcher

interface PokemonDataSouce {

 suspend fun listPokemons(dispatcher: CoroutineDispatcher, limit : Int): PokemonApi?

 suspend fun getPokemons(dispatcher: CoroutineDispatcher, id : Int ): PokemonApiResult?

}