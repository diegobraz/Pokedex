package com.example.pokedex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.domain.Pokemon
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import kotlinx.android.synthetic.main.pokemon_detail.view.*

class PokemonDetail : AppCompatActivity() {
    lateinit var pokemon: Pokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        pokemon = intent.getSerializableExtra("pokemon") as Pokemon
        Glide.with(this).load(pokemon.url).into(pokemon_teste)
        pokemon_name.text = pokemon.name
        pokemon_number.text = pokemon.formattedNumber
    }
}