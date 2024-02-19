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
import com.ericsospedra.pokemonproyect.models.Alineacion;
import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.ericsospedra.pokemonproyect.models.RestClient;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlineacionAdapter extends RecyclerView.Adapter<AlineacionAdapter.AlieacionViewHolder> {

    private List<Pokemon> alineacion;

    public AlineacionAdapter(List<Pokemon> alineacion) {
        this.alineacion = alineacion;
    }

    @NonNull
    @Override
    public AlineacionAdapter.AlieacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlieacionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_welcome_alineacion, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlineacionAdapter.AlieacionViewHolder holder, int position) {
        holder.onBindAlineacion(alineacion.get(position));
    }

    @Override
    public int getItemCount() {
        return alineacion.size();
    }

    public class AlieacionViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPokemon;
        private ImageView ivBackground;
        private TextView tvAlineacion;
        private ProgressBar pbLifeAlineacion;

        public AlieacionViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPokemon = itemView.findViewById(R.id.ivPokemonAlineacion);
            ivBackground = itemView.findViewById(R.id.ivBackground);
            tvAlineacion = itemView.findViewById(R.id.tvAlineacion);
            pbLifeAlineacion = itemView.findViewById(R.id.pbLifeAlineacion);
        }

        public void onBindAlineacion(Pokemon pokemon) {
            Picasso.get().load(pokemon.getHiresURL()).into(ivPokemon);
            RestClient.getInstance().getAlineacion(pokemon.getAlineacion().getId()).enqueue(new Callback<Alineacion>() {
                @Override
                public void onResponse(Call<Alineacion> call, Response<Alineacion> response) {
                    if (response.isSuccessful()) {
                        tvAlineacion.setText(response.body().getZona());
                    }
                }

                @Override
                public void onFailure(Call<Alineacion> call, Throwable t) {

                }
            });
            pbLifeAlineacion.setProgress(pokemon.getHp());

        }
    }
}
