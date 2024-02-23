package com.ericsospedra.pokemonproyect.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.dto.PokemonDTO;
import com.ericsospedra.pokemonproyect.interfaces.IOnLongClickListener;
import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TrainerPokemonAdapter extends RecyclerView.Adapter<TrainerPokemonAdapter.TrainerPokemonViewHolder> {
    private List<PokemonDTO> pokemons;
    private IOnLongClickListener listener;
    public TrainerPokemonAdapter(List<PokemonDTO> pokemons, IOnLongClickListener listener) {
        this.pokemons = pokemons;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TrainerPokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TrainerPokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trainer,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TrainerPokemonViewHolder holder, int position) {
        holder.onBindPokemon(pokemons.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public class TrainerPokemonViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private ImageView ivPokemon;
        private ImageView ivBackground;
        private TextView tvAlineacion;
        private ProgressBar pbLifeAlineacion;

        public TrainerPokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPokemon = itemView.findViewById(R.id.ivPokemonAlineacion);
            ivBackground = itemView.findViewById(R.id.ivBackground);
            tvAlineacion = itemView.findViewById(R.id.tvAlineacion);
            pbLifeAlineacion = itemView.findViewById(R.id.pbLifeAlineacion);
            itemView.setOnLongClickListener(this);
        }

        public void onBindPokemon(PokemonDTO pokemon) {
            Picasso.get().load(pokemon.getHiresURL()).into(ivPokemon);
            tvAlineacion.setText(pokemon.getName());
            pbLifeAlineacion.setProgress(pokemon.getHp());

        }

        @Override
        public boolean onLongClick(View v) {
            listener.onLongClick(pokemons.get(getAdapterPosition()));
            return true;
        }
    }

}
