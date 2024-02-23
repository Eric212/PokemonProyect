package com.ericsospedra.pokemonproyect.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.adapters.WelcomeAdapter;
import com.ericsospedra.pokemonproyect.dto.EntrenadorDTO;
import com.ericsospedra.pokemonproyect.dto.PokemonDTO;
import com.ericsospedra.pokemonproyect.dto.UsuarioDTO;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WelcomeFragment extends Fragment implements View.OnClickListener {
    private ImageView ivZona1Posicion1;
    private ImageView ivZona1Posicion2;
    private ImageView ivZona2Posicion1;
    private ImageView ivZona2Posicion2;
    private ImageView ivZona2Posicion3;
    private ImageView ivZona3Posicion1;
    private ImageView ivZona3Posicion2;
    private ImageView ivZona3Posicion3;
    private ImageView ivZona3Posicion4;
    private ImageView ivZona4Posicion1;
    private ImageView ivZona4Posicion2;
    private ImageView ivPokemonZona1Posicion1;
    private ImageView ivPokemonZona1Posicion2;
    private ImageView ivPokemonZona2Posicion1;
    private ImageView ivPokemonZona2Posicion2;
    private ImageView ivPokemonZona2Posicion3;
    private ImageView ivPokemonZona3Posicion1;
    private ImageView ivPokemonZona3Posicion2;
    private ImageView ivPokemonZona3Posicion3;
    private ImageView ivPokemonZona3Posicion4;
    private ImageView ivPokemonZona4Posicion1;
    private ImageView ivPokemonZona4Posicion2;
    private ProgressBar pbHp1;
    private ProgressBar pbHp2;
    private ProgressBar pbHp3;
    private ProgressBar pbHp4;
    private ProgressBar pbHp5;
    private ProgressBar pbHp6;
    private ProgressBar pbHp7;
    private ProgressBar pbHp8;
    private ProgressBar pbHp9;
    private ProgressBar pbHp10;
    private ProgressBar pbHp11;
    private IApiService api;
    private TextView tvWarning;
    private ImageView ivHome;
    private ImageView ivTrainer;
    private ImageView ivPokedex;
    private ImageView ivBattle;
    private ImageView ivMarket;
    private View menuLayout;
    private IOnClickListener listener;
    private SharedPreferences sharedPreferences;
    private RecyclerView rvPokemonsAlineados1;
    private RecyclerView rvPokemonsAlineados2;
    private RecyclerView rvPokemonsAlineados3;
    private RecyclerView rvPokemonsAlineados4;

    public WelcomeFragment() {
        super(R.layout.welcome_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        api = RestClient.getInstance();
        rvPokemonsAlineados1 = view.findViewById(R.id.rvPokemonsAlineados1);
        rvPokemonsAlineados2 = view.findViewById(R.id.rvPokemonsAlineados2);
        rvPokemonsAlineados3 = view.findViewById(R.id.rvPokemonsAlineados3);
        rvPokemonsAlineados4 = view.findViewById(R.id.rvPokemonsAlineados4);
        api.getPokemonsAlineados(1).enqueue(new Callback<List<PokemonDTO>>() {
            @Override
            public void onResponse(Call<List<PokemonDTO>> call, Response<List<PokemonDTO>> response) {
                if (response.isSuccessful()) {
                    List<PokemonDTO> pokemonsAlineados = response.body();
                    if (pokemonsAlineados.size() != 0) {
                        WelcomeAdapter adapter1 = new WelcomeAdapter(pokemonsAlineados.subList(0,2));
                        WelcomeAdapter adapter2 = new WelcomeAdapter(pokemonsAlineados.subList(2,5));
                        WelcomeAdapter adapter3 = new WelcomeAdapter(pokemonsAlineados.subList(5,9));
                        WelcomeAdapter adapter4 = new WelcomeAdapter(pokemonsAlineados.subList(9,11));
                        rvPokemonsAlineados1.setAdapter(adapter1);
                        rvPokemonsAlineados1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                        rvPokemonsAlineados2.setAdapter(adapter2);
                        rvPokemonsAlineados2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                        rvPokemonsAlineados3.setAdapter(adapter3);
                        rvPokemonsAlineados3.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                        rvPokemonsAlineados4.setAdapter(adapter4);
                        rvPokemonsAlineados4.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                    }
                } else {
                    tvWarning = view.findViewById(R.id.tvWarning);
                    tvWarning.setVisibility(View.VISIBLE);
                    tvWarning.setText("No tienes pokemons alineados");
                    tvWarning.setTextSize(40f);
                    tvWarning.setTextColor(ContextCompat.getColor(view.getContext(), R.color.pokemon_letters));
                    tvWarning.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.pokemon_background));
                }

            }

            @Override
            public void onFailure(Call<List<PokemonDTO>> call, Throwable t) {
                Log.e(" Error ", "Que no le da la gana ir");
            }
        });
        menuLayout = view.findViewById(R.id.iMenuWelcome);
        ivHome = menuLayout.findViewById(R.id.ivHome);
        ivTrainer = menuLayout.findViewById(R.id.ivTrainer);
        ivPokedex = menuLayout.findViewById(R.id.ivPokedex);
        ivBattle = menuLayout.findViewById(R.id.ivBattle);
        ivMarket = menuLayout.findViewById(R.id.ivMarket);
        api.findUserByName(sharedPreferences.getString("username", "")).enqueue(new Callback<UsuarioDTO>() {
            @Override
            public void onResponse(Call<UsuarioDTO> call, Response<UsuarioDTO> response) {
                if (response.isSuccessful()) {
                    Log.d("INFO ", response.body().toString());
                    api.recuperarEntrenadorPorUsuario(response.body().getId()).enqueue(new Callback<EntrenadorDTO>() {
                        @Override
                        public void onResponse(Call<EntrenadorDTO> call, Response<EntrenadorDTO> response) {
                            EntrenadorDTO entrenador = response.body();
                            Log.d("INFO ", entrenador.toString());
                            if (entrenador.isGenero()) {
                                ivTrainer.setImageResource(view.getContext().getResources().getIdentifier("girl_trainer", "drawable", view.getContext().getPackageName()));
                            } else {
                                ivTrainer.setImageResource(view.getContext().getResources().getIdentifier("boy_trainer", "drawable", view.getContext().getPackageName()));
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
        sharedPreferences = context.getSharedPreferences("login", 0);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == ivHome.getId() || v.getId() == ivTrainer.getId() || v.getId() == ivBattle.getId() || v.getId() == ivMarket.getId() || v.getId() == ivPokedex.getId()) {
            listener.onClick(v.getId());
        }
    }
}
