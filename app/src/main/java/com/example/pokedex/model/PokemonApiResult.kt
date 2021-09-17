package com.example.pokedex.model

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeList>
)
