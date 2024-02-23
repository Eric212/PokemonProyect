package com.ericsospedra.pokemonproyect.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.dto.PokemonDTO;
import com.squareup.picasso.Picasso;

import java.util.List;

import kotlin.jvm.internal.Lambda;

public class PokemonOponentAdapter extends RecyclerView.Adapter<PokemonOponentAdapter.PokemonViewHolder> {
    private List<PokemonDTO> pokemonsDTO;

    public PokemonOponentAdapter(List<PokemonDTO> pokemonsDTO) {
        this.pokemonsDTO = pokemonsDTO;
    }

    @NonNull
    @Override
    public PokemonOponentAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_oponent_pokemon_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonOponentAdapter.PokemonViewHolder holder, int position) {
        holder.onBindPokemon(pokemonsDTO.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonsDTO.size();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPokemonOponent;
        private ProgressBar pbLife;
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPokemonOponent = itemView.findViewById(R.id.ivPokemonOponent);
            pbLife = itemView.findViewById(R.id.pbLifePokemonOponent);
        }

        public void onBindPokemon(PokemonDTO pokemonDTO) {
            Picasso.get().load(pokemonDTO.getHiresURL()).into(ivPokemonOponent);
            pbLife.setProgress(pokemonDTO.getHp());
        }
    }
}
