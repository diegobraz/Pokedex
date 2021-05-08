package com.example.pokedex.api

import android.util.Log
import android.widget.Toast
import com.example.pokedex.api.model.PokemonApiResult
import com.example.pokedex.api.model.PokemonsApi
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object PokeRespositore {
    // "https://pokeapi.co/api/v2/pokemon/?offset=200&limit=200"
    private val service : PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 200 ): PokemonsApi? {
       val call =  service.listPokemons(limit)

       return call.execute().body()


    }

    fun getPokemon(number: Int): PokemonApiResult? {
        val call =  service.getPokemons(number)
            return call.execute().body()


    }

}