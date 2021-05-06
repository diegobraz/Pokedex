package com.example.pokedex.api.domain

data class Pokemon(
        val imageUrL : String? = null,
        val cod : Int? = null,
        val name: String? = null,
        val type : List<PokemonType>
)
