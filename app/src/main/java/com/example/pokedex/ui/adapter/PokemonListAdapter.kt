package com.example.pokedex.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.domain.Pokemon
import kotlinx.android.synthetic.main.pokemon_detail.view.*

class PokemonListAdapter(
    private val items: List<Pokemon?>,
    private val clickDetail: (pokemon: Pokemon) -> Unit
) : RecyclerView.Adapter<PokemonListAdapter.Viewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_detail, parent, false)
        return Viewholder(view,clickDetail)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        items[position]?.let { holder.bind(it) }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Viewholder(itemView: View, val clickDetail: (pokemon: Pokemon) -> Unit) : RecyclerView.ViewHolder(itemView) {

        fun bind(pokemon: Pokemon) {
//            itemView.cod_pokemon.text = "Nº ${pokemon.number}"
            itemView.name_pokemon.text = pokemon.name.replaceFirstChar { it.uppercase() }
            itemView.type_name.text = pokemon.type?.first()?.name
            when (pokemon.type?.first()?.name) {
                "grass" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.grass
                        )
                    )
                }
                "poison" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.poison
                        )
                    )
                }
                "fire" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.fire
                        )
                    )
                }
                "water" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.water
                        )
                    )
                }
                "bug" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.bug
                        )
                    )
                }
                "normal" -> {

                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.normal
                        )
                    )
                }
                "electric" -> {

                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.electric
                        )
                    )
                }
                "dark" -> {

                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.dark
                        )
                    )
                }
                "ground" -> {

                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.ground
                        )
                    )
                }
                "fairy" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.fairy
                        )
                    )
                }
                "fighting" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.fighting
                        )
                    )
                }
                "psychic" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.psychic
                        )
                    )
                }
                "rock" -> {

                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.rock
                        )
                    )
                }
                "ghost" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.ghost
                        )
                    )
                }
                "dragon" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.dragon
                        )
                    )
                }
                "ice" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.ice
                        )
                    )
                }
                "flying" -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.flying
                        )
                    )
                }
                else -> {
                    itemView.card_pokemon_list.setCardBackgroundColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.fire
                        )
                    )
                }
            }

            if (pokemon.type?.size ?: 0 > 1) {
                itemView.type_second_name.text = pokemon.type?.get(1)?.name ?: ""
                itemView.type_second_name.visibility = View.VISIBLE

            } else {
                itemView.type_second_name.visibility = View.GONE
            }

            Glide.with(itemView.context).load(pokemon.url).into(itemView.image_pokemon)
            onClickListener(pokemon)
        }

        private fun onClickListener(pokemon: Pokemon) {
          itemView.pokemon_detail.setOnClickListener{
              clickDetail(pokemon)
          }
        }
    }
}

