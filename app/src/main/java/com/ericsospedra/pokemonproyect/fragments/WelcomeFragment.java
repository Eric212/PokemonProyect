package com.ericsospedra.pokemonproyect.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.adapters.AlineacionAdapter;
import com.ericsospedra.pokemonproyect.dto.EntrenadorDTO;
import com.ericsospedra.pokemonproyect.dto.PokemonDTO;
import com.ericsospedra.pokemonproyect.dto.UsuarioDTO;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.Entrenador;
import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.ericsospedra.pokemonproyect.models.RestClient;
import com.ericsospedra.pokemonproyect.models.Usuario;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeFragment extends Fragment implements View.OnClickListener {
    private IApiService api;
    private RecyclerView rvPokemons;
    TextView tvWarning;
    private ImageView ivTrainer;
    private ImageView ivPokedex;
    private ImageView ivBattle;
    private ImageView ivMarket;

    private View menuLayout;
    private IOnClickListener listener;
    SharedPreferences sharedPreferences;
    private ImageView ivHome;

    public WelcomeFragment() {
        super(R.layout.welcome_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        api = RestClient.getInstance();
        api.getPokemonsAlineados(1).enqueue(new Callback<List<PokemonDTO>>() {
            @Override
            public void onResponse(Call<List<PokemonDTO>> call, Response<List<PokemonDTO>> response) {
                if (response.isSuccessful()) {
                    List<PokemonDTO> pokemonsAlineados = response.body();
                    rvPokemons = view.findViewById(R.id.rvPokemonsAlineacion);
                    if(pokemonsAlineados.size()!=0) {
                        AlineacionAdapter adapter = new AlineacionAdapter(pokemonsAlineados);
                        rvPokemons.setAdapter(adapter);
                    }else {
                        rvPokemons.setVisibility(View.GONE);
                        tvWarning = view.findViewById(R.id.tvWarning);
                        tvWarning.setVisibility(View.VISIBLE);
                        tvWarning.setText("No tienes pokemons alineados");
                        tvWarning.setTextSize(40f);
                        tvWarning.setTextColor(ContextCompat.getColor(view.getContext(), R.color.pokemon_letters));
                        tvWarning.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.pokemon_background));
                    }
                    rvPokemons.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
                }
            }
            @Override
            public void onFailure(Call<List<PokemonDTO>> call, Throwable t) {
                Log.e(" Error ","Que no le da la gana ir");
            }
        });
        menuLayout = view.findViewById(R.id.iMenuWelcome);
        ivHome = menuLayout.findViewById(R.id.ivHome);
        ivTrainer = menuLayout.findViewById(R.id.ivTrainer);
        ivPokedex = menuLayout.findViewById(R.id.ivPokedex);
        ivBattle = menuLayout.findViewById(R.id.ivBattle);
        ivMarket = menuLayout.findViewById(R.id.ivMarket);
        api.findUserByName(sharedPreferences.getString("username",""))  .enqueue(new Callback<UsuarioDTO>() {
            @Override
            public void onResponse(Call<UsuarioDTO> call, Response<UsuarioDTO> response) {
                if(response.isSuccessful()){
                    Log.d("INFO ",response.body().toString());
                    api.recuperarEntrenadorPorUsuario(response.body().getId()).enqueue(new Callback<EntrenadorDTO>() {
                        @Override
                        public void onResponse(Call<EntrenadorDTO> call, Response<EntrenadorDTO> response) {
                            EntrenadorDTO entrenador = response.body();
                            Log.d("INFO ",entrenador.toString());
                            if(entrenador.isGenero()){
                                ivTrainer.setImageResource(view.getContext().getResources().getIdentifier("girl_trainer","drawable",view.getContext().getPackageName()));
                            }else{
                                ivTrainer.setImageResource(view.getContext().getResources().getIdentifier("boy_trainer","drawable",view.getContext().getPackageName()));
                            }
                        }

                        @Override
                        public void onFailure(Call<EntrenadorDTO> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<UsuarioDTO> call, Throwable t) {

            }
        });
        ivHome.setOnClickListener(this);
        ivTrainer.setOnClickListener(this);
        ivPokedex.setOnClickListener(this);
        ivBattle.setOnClickListener(this);
        ivMarket.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IOnClickListener) context;
        sharedPreferences = context.getSharedPreferences("login",0);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == ivHome.getId() || v.getId() == ivTrainer.getId() || v.getId() == ivBattle.getId() || v.getId() == ivMarket.getId() || v.getId() == ivPokedex.getId()) {
            listener.onClick(v.getId());
        }
    }
}
