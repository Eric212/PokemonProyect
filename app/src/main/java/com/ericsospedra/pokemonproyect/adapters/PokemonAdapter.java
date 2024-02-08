package com.ericsospedra.pokemonproyect.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.Pokemon;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    private List<Pokemon> pokemons;
    private IOnClickListener listener;
    public PokemonAdapter(List<Pokemon> pokemons, IOnClickListener listener) {
        this.pokemons = pokemons;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PokemonAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemons,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.PokemonViewHolder holder, int position) {
        holder.onBindPokemon(pokemons.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivPokemon;
        private TextView tvPokemon;
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPokemon = itemView.findViewById(R.id.ivPokemon);
            tvPokemon = itemView.findViewById(R.id.tvPokemon);
            itemView.setOnClickListener(this);
        }

        public void onBindPokemon(Pokemon pokemon) {
            ivPokemon.setImageResource(itemView.getContext().getResources().getIdentifier("_"+pokemon.getHiresURL(),"drawable",itemView.getContext().getPackageName()));
            ivPokemon.getLayoutParams().width = 430;
            ivPokemon.getLayoutParams().height = 430;
            tvPokemon.setText(pokemon.getName());
        }

        @Override
        public void onClick(View v) {
            listener.onClick(getAdapterPosition());
        }
    }
}
