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
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlignmentAdapter extends RecyclerView.Adapter<AlignmentAdapter.PokemonAlignmentDetailViewHolder> {
    private List<Pokemon> pokemons;
    private IOnClickListener listener;
    public AlignmentAdapter(List<Pokemon> pokemons, IOnClickListener listener) {
        this.pokemons = pokemons;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PokemonAlignmentDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonAlignmentDetailViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alignment,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAlignmentDetailViewHolder holder, int position) {
        holder.onBindPokemonAlignmentDetail(pokemons.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public class PokemonAlignmentDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivPokemonAlignmentDetail;
        private TextView tvPokemonNameAlignment;
        private ProgressBar pbLifeAlignment;
        private ProgressBar pbAttackAlignment;
        private ProgressBar pbDefenseAlignment;
        private ProgressBar pbSpeedAlignment;
        public PokemonAlignmentDetailViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPokemonAlignmentDetail = itemView.findViewById(R.id.ivPokemonAlineacionDetalle);
            tvPokemonNameAlignment = itemView.findViewById(R.id.tvPokemonNameAlignment);
            pbLifeAlignment = itemView.findViewById(R.id.pbLifeAlignment);
            pbAttackAlignment = itemView.findViewById(R.id.pbAttackAlignment);
            pbDefenseAlignment = itemView.findViewById(R.id.pbDefenseAlignment);
            pbSpeedAlignment = itemView.findViewById(R.id.pbSpeedAlignment);
            itemView.setOnClickListener(this);
        }

        public void onBindPokemonAlignmentDetail(Pokemon pokemon) {
            Picasso.get().load(pokemon.getHiresURL()).into(ivPokemonAlignmentDetail);
            tvPokemonNameAlignment.setText(pokemon.getName());
            pbLifeAlignment.setProgress(pokemon.getHp());
            pbAttackAlignment.setProgress(pokemon.getAttack());
            pbDefenseAlignment.setProgress(pokemon.getDefence());
            pbSpeedAlignment.setProgress(pokemon.getSpeed());
        }

        @Override
        public void onClick(View v) {
            listener.onClick(pokemons.get(getAdapterPosition()).getId());
        }
    }
}
