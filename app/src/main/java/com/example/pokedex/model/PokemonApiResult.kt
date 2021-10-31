package com.example.pokedex.model

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val base_experience: Int,
    val height : Int,
    val weight:Int,
    val types: List<PokemonTypeList>,
    val abilities: List<AbilitiesType>
)
