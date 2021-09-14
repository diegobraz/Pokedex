package com.example.pokedex.api.model

import com.example.pokedex.api.domain.PokemonType

data class PokemonTypeList(
    val slot: Int,
    val type: PokemonType
)