package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedex.R
import com.example.pokedex.api.domain.Pokemon
import kotlinx.android.synthetic.main.pokemon_detail.view.*

class PokemonListAdapter(
    private  val items : List<Pokemon?>
    ) : RecyclerView.Adapter<PokemonListAdapter.Viewholder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_detail,parent,false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        items[position]?.let { holder.bind(it) }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind (pokemon: Pokemon) {
            itemView.cod_pokemon.text = "Nº ${pokemon.number}"
            itemView.name_pokemon.text = pokemon.name
            itemView.type_name.text = pokemon.type?.first()?.name

            if (pokemon.type?.size ?: 0 > 1){
                itemView.type_second_name.text = pokemon.type?.get(1)?.name ?: ""
                itemView.type_second_name.visibility = View.VISIBLE
            }
            else{
                itemView.type_second_name.visibility = View.GONE
            }

            Glide.with(itemView.context).load(pokemon.url).into(itemView.image_pokemon)

        }


    }
}

