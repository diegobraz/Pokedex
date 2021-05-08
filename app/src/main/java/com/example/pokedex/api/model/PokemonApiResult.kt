package com.example.pokedex.api.model

data class PokemonApiResult(
     val id: Int,
     val name : String,
     val types : List<PokemonTypeList>
)
