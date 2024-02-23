package com.ericsospedra.pokemonproyect.adapters;

import static com.ericsospedra.pokemonproyect.utils.AvatarRecovery.recuperarAvatarParaBot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.dto.EntrenadorDTO;
import com.ericsospedra.pokemonproyect.dto.PokemonDTO;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class OponentAdapter extends RecyclerView.Adapter<OponentAdapter.OponentViewHolder> {
    private List<EntrenadorDTO> oponentes;
    private IOnClickListener listener;
    public OponentAdapter(List<EntrenadorDTO> oponentes, IOnClickListener listener) {
        this.oponentes = oponentes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public OponentAdapter.OponentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OponentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_battle,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OponentAdapter.OponentViewHolder holder, int position) {
        holder.onBindOponent(oponentes.get(position));
    }

    @Override
    public int getItemCount() {
        return oponentes.size();
    }

    public class OponentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivOponent;
        private TextView tvNameOponent;
        private TextView tvSurnameOponent;
        private TextView tvVictories;
        private RecyclerView rvPokemonsOponent;
        public OponentViewHolder(@NonNull View itemView) {
            super(itemView);
            ivOponent = itemView.findViewById(R.id.ivOponent);
            tvNameOponent = itemView.findViewById(R.id.tvNameOponent);
            tvSurnameOponent = itemView.findViewById(R.id.tvSurnameOponent);
            tvVictories = itemView.findViewById(R.id.tvVictories);
            rvPokemonsOponent = itemView.findViewById(R.id.rvPokemonsOponent);
            itemView.setOnClickListener(this);
        }

        public void onBindOponent(EntrenadorDTO entrenadorDTO) {
            ivOponent.setImageResource(recuperarAvatarParaBot(itemView.getContext()));
            tvNameOponent.setText(entrenadorDTO.getNombre());
            tvSurnameOponent.setText(entrenadorDTO.getApellido());
            RestClient.getInstance().getTrainerPokemons(entrenadorDTO.getId()).enqueue(new Callback<List<PokemonDTO>>() {
                @Override
                public void onResponse(Call<List<PokemonDTO>> call, Response<List<PokemonDTO>> response) {
                    if(response.isSuccessful()){
                        List<PokemonDTO> pokemonsDTO = response.body();
                        PokemonOponentAdapter adapter = new PokemonOponentAdapter(pokemonsDTO);
                        rvPokemonsOponent.setAdapter(adapter);
                        rvPokemonsOponent.setLayoutManager(new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false));
                    }
                }

                @Override
                public void onFailure(Call<List<PokemonDTO>> call, Throwable t) {

                }
            });
        }

        @Override
        public void onClick(View v) {
            listener.onClick(oponentes.get(getAdapterPosition()).getId());
        }
    }
}
