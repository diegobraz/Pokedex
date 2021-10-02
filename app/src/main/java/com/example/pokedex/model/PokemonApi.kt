package com.example.pokedex.model

data class PokemonApi(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)