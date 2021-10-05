package com.example.pokedex.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.domain.Pokemon
import kotlinx.android.synthetic.main.pokemon_detail.view.*

class PokemonListAdapter(
    private val items: List<Pokemon?>
) : RecyclerView.Adapter<PokemonListAdapter.Viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_detail, parent, false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        items[position]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(pokemon: Pokemon) {
            itemView.cod_pokemon.text = "Nº ${pokemon.number}"
            itemView.name_pokemon.text = pokemon.name
            itemView.type_name.text = pokemon.type?.first()?.name
            when(pokemon.type?.first()?.name){
                "grass"->{
                    itemView.type_name.setBackgroundResource(R.color.grass)
                }
                "poison" -> {
                    itemView.type_name.setBackgroundResource(R.color.poison)
                }
                "fire" -> {
                    itemView.type_name.setBackgroundResource(R.color.fire)
                }
                "water" -> {
                    itemView.type_name.setBackgroundResource(R.color.water)
                }
                "bug" -> {
                    itemView.type_name.setBackgroundResource(R.color.bug)
                }
                "normal" -> {
                    itemView.type_name.setBackgroundResource(R.color.normal)
                }
                "electric" -> {
                    itemView.type_name.setBackgroundResource(R.color.electric)
                }
                "dark" -> {
                    itemView.type_name.setBackgroundResource(R.color.dark)
                }
                "ground" -> {
                    itemView.type_name.setBackgroundResource(R.color.ground)
                }
                "fairy" -> {
                    itemView.type_name.setBackgroundResource(R.color.fairy)
                }
                "fighting" -> {
                    itemView.type_name.setBackgroundResource(R.color.fighting)
                }
                "psychic" -> {
                    itemView.type_name.setBackgroundResource(R.color.psychic)
                }
                "rock" -> {
                    itemView.type_name.setBackgroundResource(R.color.rock)
                }
                "ghost" -> {
                    itemView.type_name.setBackgroundResource(R.color.ghost)
                }
                "dragon" -> {
                    itemView.type_name.setBackgroundResource(R.color.dragon)
                }
                "ice" -> {
                    itemView.type_name.setBackgroundResource(R.color.ice)
                }
                "flying" -> {
                    itemView.type_name.setBackgroundResource(R.color.flying)
                }
                else -> {
                    itemView.type_name.setBackgroundColor(Color.RED)
                }
            }

            if (pokemon.type?.size ?: 0 > 1) {
                itemView.type_second_name.text = pokemon.type?.get(1)?.name ?: ""
                itemView.type_second_name.visibility = View.VISIBLE
                when (pokemon.type?.get(1)?.name) {
                    "grass" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.grass)
                    }
                    "poison" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.poison)
                    }
                    "fire" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.fire)
                    }
                    "water" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.water)
                    }
                    "bug" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.bug)
                    }
                    "normal" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.normal)
                    }
                    "electric" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.electric)
                    }
                    "dark" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.dark)
                    }
                    "ground" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.ground)
                    }
                    "fairy" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.fairy)
                    }
                    "fighting" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.fighting)
                    }
                    "psychic" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.psychic)
                    }
                    "rock" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.rock)
                    }
                    "ghost" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.ghost)
                    }
                    "dragon" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.dragon)
                    }
                    "ice" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.ice)
                    }
                    "flying" -> {
                        itemView.type_second_name.setBackgroundResource(R.color.flying)
                    }
                    else -> {
                        itemView.type_second_name.setBackgroundColor(Color.RED)
                    }
                }
            } else {
                itemView.type_second_name.visibility = View.GONE
            }

            Glide.with(itemView.context).load(pokemon.url).into(itemView.image_pokemon)
        }
    }
}

