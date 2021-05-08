package com.example.pokedex.api

import android.util.Log
import android.widget.Toast
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

    fun listPokemons(limit: Int = 200 ) {
       val call =  service.listPokemons(limit)

        call.enqueue(object: Callback<PokemonsApi>{
            override fun onResponse(call: Call<PokemonsApi>, response: Response<PokemonsApi>) {
                Log.d("POKEMON_API","pokemon api loaded.")
                if (response.isSuccessful){
                    val body  = response.body()

                    body?.results?.let {
                       it.forEach {
                           Log.d("POKEMON_API",it.name)
                       }
                    }
                }

            }

            override fun onFailure(call: Call<PokemonsApi>, t: Throwable) {
                Log.e("POKEMON_API","Erro during pokemon api load.",t)
            }

        })

    }

}