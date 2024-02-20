package com.ericsospedra.pokemonproyect.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.adapters.AlignmentAdapter;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.Alineacion;
import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.ericsospedra.pokemonproyect.models.RestClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlignmentFragment extends Fragment implements View.OnClickListener, IOnClickListener {
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
    private RecyclerView rvPokemonsAliniacion;
    private IOnClickListener listenerMainActivity;
    private IOnClickListener listener;
    private IApiService api;
    private View menuLayout;
    private ImageView ivTrainer;
    private ImageView ivPokedex;
    private ImageView ivBattle;
    private ImageView ivMarket;
    private Stack<ImageView> images;
    private List<ImageView> zona1;
    private List<ImageView> zona2;
    private List<ImageView> zona3;
    private List<ImageView> zona4;
    private List<Pokemon> zona1Pokemons;
    private List<Pokemon> zona2Pokemons;
    private List<Pokemon> zona3Pokemons;
    private List<Pokemon> zona4Pokemons;
    private List<Pokemon> pokemonsAlineados;
    private ImageView ivHome;

    public AlignmentFragment() {
        super(R.layout.aligment_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        images = new Stack<>();
        pokemonsAlineados = new ArrayList<>();
        zona1 = new ArrayList<>();
        zona2 = new ArrayList<>();
        zona3 = new ArrayList<>();
        zona4 = new ArrayList<>();
        zona1Pokemons = new ArrayList<>();
        zona2Pokemons = new ArrayList<>();
        zona3Pokemons = new ArrayList<>();
        zona4Pokemons = new ArrayList<>();
        api = RestClient.getInstance();
        ivZona1Posicion1 = view.findViewById(R.id.ivZona1Posicion1);
        ivZona1Posicion2 = view.findViewById(R.id.ivZona1Posicion2);
        ivZona2Posicion1 = view.findViewById(R.id.ivZona2Posicion1);
        ivZona2Posicion2 = view.findViewById(R.id.ivZona2Posicion2);
        ivZona2Posicion3 = view.findViewById(R.id.ivZona2Posicion3);
        ivZona3Posicion1 = view.findViewById(R.id.ivZona3Posicion1);
        ivZona3Posicion2 = view.findViewById(R.id.ivZona3Posicion2);
        ivZona3Posicion3 = view.findViewById(R.id.ivZona3Posicion3);
        ivZona3Posicion4 = view.findViewById(R.id.ivZona3Posicion4);
        ivZona4Posicion1 = view.findViewById(R.id.ivZona4Posicion1);
        ivZona4Posicion2 = view.findViewById(R.id.ivZona4Posicion2);
        ivPokemonZona1Posicion1 = view.findViewById(R.id.ivPokemonZona1Posicion1);
        ivPokemonZona1Posicion2 = view.findViewById(R.id.ivPokemonZona1Posicion2);
        zona1.add(ivPokemonZona1Posicion1);
        zona1.add(ivPokemonZona1Posicion2);
        ivPokemonZona2Posicion1 = view.findViewById(R.id.ivPokemonZona2Posicion1);
        ivPokemonZona2Posicion2 = view.findViewById(R.id.ivPokemonZona2Posicion2);
        ivPokemonZona2Posicion3 = view.findViewById(R.id.ivPokemonZona2Posicion3);
        zona2.add(ivPokemonZona2Posicion1);
        zona2.add(ivPokemonZona2Posicion2);
        zona2.add(ivPokemonZona2Posicion3);
        ivPokemonZona3Posicion1 = view.findViewById(R.id.ivPokemonZona3Posicion1);
        ivPokemonZona3Posicion2 = view.findViewById(R.id.ivPokemonZona3Posicion2);
        ivPokemonZona3Posicion3 = view.findViewById(R.id.ivPokemonZona3Posicion3);
        ivPokemonZona3Posicion4 = view.findViewById(R.id.ivPokemonZona3Posicion4);
        zona3.add(ivPokemonZona3Posicion1);
        zona3.add(ivPokemonZona3Posicion2);
        zona3.add(ivPokemonZona3Posicion3);
        zona3.add(ivPokemonZona3Posicion4);
        ivPokemonZona4Posicion1 = view.findViewById(R.id.ivPokemonZona4Posicion1);
        ivPokemonZona4Posicion2 = view.findViewById(R.id.ivPokemonZona4Posicion2);
        zona4.add(ivPokemonZona4Posicion1);
        zona4.add(ivPokemonZona4Posicion2);
        rvPokemonsAliniacion = view.findViewById(R.id.rvPokemonsAlineacion);
        menuLayout = view.findViewById(R.id.iMenuAlignment);
        ivHome = menuLayout.findViewById(R.id.ivHome);
        ivTrainer = menuLayout.findViewById(R.id.ivTrainer);
        ivPokedex = menuLayout.findViewById(R.id.ivPokedex);
        ivBattle = menuLayout.findViewById(R.id.ivBattle);
        ivMarket = menuLayout.findViewById(R.id.ivMarket);
        listener = this;
        ivPokemonZona1Posicion1.setOnClickListener(this);
        ivPokemonZona1Posicion2.setOnClickListener(this);
        ivPokemonZona2Posicion1.setOnClickListener(this);
        ivPokemonZona2Posicion2.setOnClickListener(this);
        ivPokemonZona2Posicion3.setOnClickListener(this);
        ivPokemonZona3Posicion1.setOnClickListener(this);
        ivPokemonZona3Posicion2.setOnClickListener(this);
        ivPokemonZona3Posicion3.setOnClickListener(this);
        ivPokemonZona3Posicion4.setOnClickListener(this);
        ivPokemonZona4Posicion1.setOnClickListener(this);
        ivPokemonZona4Posicion2.setOnClickListener(this);
        ivHome.setOnClickListener(this);
        ivTrainer.setOnClickListener(this);
        ivPokedex.setOnClickListener(this);
        ivBattle.setOnClickListener(this);
        ivMarket.setOnClickListener(this);
        api.getTrainerPokemons(1).enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if (response.isSuccessful()) {
                    List<Pokemon> pokemons = response.body();
                    Log.d("INFO ", pokemons.toString());
                    rvPokemonsAliniacion = view.findViewById(R.id.rvPokemonsAlignment);
                    AlignmentAdapter adapter = new AlignmentAdapter(pokemons, listener);
                    rvPokemonsAliniacion.setAdapter(adapter);
                    rvPokemonsAliniacion.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerMainActivity = (IOnClickListener) context;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == ivHome.getId() || v.getId() == ivTrainer.getId() || v.getId() == ivBattle.getId() || v.getId() == ivMarket.getId() || v.getId() == ivPokedex.getId()) {
            Log.d("INFO ", String.valueOf(pokemonsAlineados.size()));
            if (pokemonsAlineados.size() == 11) {
                List<Pokemon> pokemonsAlineados = new ArrayList<>();
                pokemonsAlineados.addAll(zona1Pokemons);
                pokemonsAlineados.addAll(zona2Pokemons);
                pokemonsAlineados.addAll(zona3Pokemons);
                pokemonsAlineados.addAll(zona4Pokemons);
                api.updateAlineacion(pokemonsAlineados).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if(response.isSuccessful()){
                            if(response.body()){
                                listenerMainActivity.onClick(v.getId());
                            }else {
                                Toast.makeText(getContext(), "Esta PUTA MIERDA no va", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
            } else {
                listenerMainActivity.onClick(v.getId());
            }
        } else {
            if (!images.contains((ImageView) v)) {
                if(images.size()<1) {
                    ImageView imageSelected = (ImageView) v;
                    imageSelected.setBackgroundColor(getContext().getColor(R.color.pokemon_selected));
                    images.push((ImageView) v);
                }
            } else {
                ImageView imageSelected = (ImageView) v;
                imageSelected.setBackgroundColor(getContext().getColor(R.color.no_background));
                images.remove((ImageView) v);
            }
        }

    }

    @Override
    public void onClick(int position) {
        if (images.size() != 0) {
            api.getPokemon(position).enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    if (response.isSuccessful()) {
                        Pokemon pokemon = response.body();
                        Log.d("INFO ",pokemon.toString());
                        if (!pokemonsAlineados.contains(pokemon)) {
                            api.getAlineaciones().enqueue(new Callback<List<Alineacion>>() {
                                @Override
                                public void onResponse(Call<List<Alineacion>> call, Response<List<Alineacion>> response) {
                                    List<Alineacion> alineaciones = response.body();
                                    pokemonsAlineados.add(pokemon);
                                    ImageView imageSeleted = images.pop();
                                    if (zona1.contains(imageSeleted)) {
                                        pokemon.setAlineacion(alineaciones.get(0));
                                        zona1Pokemons.add(pokemon);
                                    } else if (zona2.contains(imageSeleted)) {
                                        pokemon.setAlineacion(alineaciones.get(1));
                                        zona2Pokemons.add(pokemon);
                                    } else if (zona3.contains(imageSeleted)) {
                                        pokemon.setAlineacion(alineaciones.get(2));
                                        zona3Pokemons.add(pokemon);
                                    } else {
                                        pokemon.setAlineacion(alineaciones.get(3));
                                        zona4Pokemons.add(pokemon);
                                    }
                                    Picasso.get().load(pokemon.getHiresURL()).into(imageSeleted);
                                    imageSeleted.setBackgroundColor(getContext().getColor(R.color.no_background));
                                }

                                @Override
                                public void onFailure(Call<List<Alineacion>> call, Throwable t) {
                                    Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.d("Error",t.getMessage());
                                }
                            });
                        } else {
                            Toast.makeText(getContext(), pokemon.getName() + " ya esta alineado", Toast.LENGTH_SHORT).show();
                        }

                    }
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    Log.d("Error",t.getMessage());
                }
            });
        } else {
            Toast.makeText(getContext(), "Selecciona donde quieres alinear el pokemon", Toast.LENGTH_SHORT).show();
        }
    }
}
