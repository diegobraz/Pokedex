package com.example.pokedex.api.model

data class PokemonsApi (
    val count : Int,
    val next :String?,
    val previous : String?,
    val results: List<PokemonResult>
)