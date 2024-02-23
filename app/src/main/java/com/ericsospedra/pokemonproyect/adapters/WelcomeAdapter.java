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
import com.squareup.picasso.Picasso;

import java.util.List;

public class WelcomeAdapter extends RecyclerView.Adapter<WelcomeAdapter.WelcomeViewHolder> {
    private final List<PokemonDTO> pokemonsAlineados;

    public WelcomeAdapter(List<PokemonDTO> pokemonsAlineados) {
        this.pokemonsAlineados = pokemonsAlineados;
    }

    @NonNull
    @Override
    public WelcomeAdapter.WelcomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WelcomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_welcome_alineacion,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull WelcomeAdapter.WelcomeViewHolder holder, int position) {
        holder.onBindWelcome(pokemonsAlineados.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonsAlineados.size();
    }

    public class WelcomeViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPokemonAlineacion;
        private TextView tvAlineacion;
        private ProgressBar pbLifeAlineacion;
        public WelcomeViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPokemonAlineacion = itemView.findViewById(R.id.ivPokemonAlineacion);
            tvAlineacion = itemView.findViewById(R.id.tvAlineacion);
            pbLifeAlineacion = itemView.findViewById(R.id.pbLifeAlineacion);
        }

        public void onBindWelcome(PokemonDTO pokemonDTO) {
            Picasso.get().load(pokemonDTO.getHiresURL()).into(ivPokemonAlineacion);
            tvAlineacion.setText(pokemonDTO.getName());
            pbLifeAlineacion.setProgress(pokemonDTO.getHp());
        }
    }
}
