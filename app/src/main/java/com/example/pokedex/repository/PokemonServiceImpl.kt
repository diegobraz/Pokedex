package com.example.pokedex.repository

import com.example.pokedex.api.PokemonService
import com.example.pokedex.data.PokemonDataSouce
import com.example.pokedex.model.PokemonApi
import com.example.pokedex.model.PokemonApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonServiceImpl @Inject constructor(
   private val pokemonService: PokemonService
):PokemonDataSouce
{
    override suspend fun listPokemons(dispatcher: CoroutineDispatcher, limit : Int): PokemonApi? {
        val call = pokemonService.listPokemons(limit)

        val response = withContext(dispatcher){
            call.execute().body()
        }

        return  response
    }

    override suspend fun getPokemons(dispatcher: CoroutineDispatcher, id: Int): PokemonApiResult? {

        val call = pokemonService.getPokemons(id)
        val response = withContext(dispatcher){
            call.execute().body()
        }
        return response
    }
}