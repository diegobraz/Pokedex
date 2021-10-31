package com.example.pokedex.domain


import java.io.Serializable


data class Pokemon(
    val number: Int? = null,
    val name: String,
    val baseExperience: Int,
    val height: Int,
    val weight:Int,
    val type: List<PokemonType>? = null,
    val Abilities : List<Ability>? = null,
    val formattedNumber: String = number.toString().padStart(3, '0'),
    val url: String = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"

):Serializable