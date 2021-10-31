package com.example.pokedex.model

import com.example.pokedex.domain.Ability

data class AbilitiesType(
    val is_hidden: Boolean,
    val slot : Int,
    val ability: Ability
)
