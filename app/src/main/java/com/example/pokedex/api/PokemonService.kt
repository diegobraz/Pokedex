package com.example.pokedex.api

import com.example.pokedex.model.PokemonApiResult
import com.example.pokedex.model.PokemonApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
   suspend fun listPokemons(@Query("limit") limit: Int): Call<PokemonApi>

    @GET("pokemon/{number}")
   suspend fun getPokemons(@Path("number") number: Int): Call<PokemonApiResult>
}