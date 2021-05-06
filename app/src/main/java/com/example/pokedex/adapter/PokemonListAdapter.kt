package com.example.pokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.api.domain.Pokemon

class PokemonListAdapter(
      private  val items : List<Pokemon>
        ) : RecyclerView.Adapter<PokemonListAdapter.Viewholder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_detail,parent,false)
        return Viewholder(view)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind (pokemon: Pokemon) {


        }


    }
}

