package com.example.pokedex.repository

import com.example.pokedex.api.PokemonService
import com.example.pokedex.data.PokemonDataSouce
import com.example.pokedex.model.PokemonApi
import com.example.pokedex.model.PokemonApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonServiceImpl @Inject constructor(
   private val pokemonService: PokemonService
):PokemonDataSouce
{
    override suspend fun listPokemons(dispatcher: CoroutineDispatcher, limit : Int): PokemonApi? {
        val result = withContext(dispatcher) {
            val call = pokemonService.listPokemons(limit)
            return@withContext call.execute().body()
        }
        return  result
    }

    override suspend fun getPokemons(dispatcher: CoroutineDispatcher, id: Int): PokemonApiResult? {
         val result =  withContext(dispatcher){
            val call = pokemonService.getPokemons(id)
             return@withContext call.execute().body()
        }
        return result
    }
}