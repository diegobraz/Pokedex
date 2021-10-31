package com.example.pokedex.utils


import com.example.pokedex.R

fun selectColor(type: String): Int {
    when (type) {
        "grass" -> {
            return R.color.grass
        }
        "poison" -> {
            return R.color.poison
        }
        "fire" -> {
            return R.color.fire
        }
        "water" -> {
            return R.color.water
        }
        "bug" -> {
            return R.color.bug
        }
        "normal" -> {
            return R.color.normal
        }
        "electric" -> {
            return R.color.electric
        }
        "dark" -> {
            return R.color.dark
        }
        "ground" -> {
            return R.color.ground
        }
        "fairy" -> {
            return R.color.fairy
        }
        "fighting" -> {
            return R.color.fighting
        }
        "psychic" -> {
            return R.color.psychic
        }
        "rock" -> {
            return R.color.rock
        }
        "ghost" -> {
            return R.color.ghost
        }
        "dragon" -> {
            return R.color.dragon
        }
        "ice" -> {
            return R.color.ice
        }
        "flying" -> {
            return R.color.flying
        }
        else -> {
            return R.color.fire
        }
    }
}