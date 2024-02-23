package com.ericsospedra.pokemonproyect.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.dto.CombateDTO;
import com.ericsospedra.pokemonproyect.dto.PokemonDTO;
import com.ericsospedra.pokemonproyect.dto.RondaDTO;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.models.RestClient;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FightFragment extends Fragment {


    public interface IOnAttach {
        int getContrincante();
    }

    private int idContrincante;
    private IApiService api;
    private List<PokemonDTO> pokemonsAPelearJugador;
    private List<PokemonDTO> pokemonsAPelearContrincantes;
    private TextView tvCaraDado;
    private TextView tvPokemonJugador;
    private TextView tvPokemonContrincante;
    private ProgressBar pbLifePokemonJugador;
    private ProgressBar pbLifePokemonBot;
    private ImageView ivPokeballZona1Posicion1Jugador;
    private ImageView ivPokeballZona1Posicion2Jugador;
    private ImageView ivPokeballZona2Posicion1Jugador;
    private ImageView ivPokeballZona2Posicion2Jugador;
    private ImageView ivPokeballZona2Posicion3Jugador;
    private ImageView ivPokeballZona3Posicion1Jugador;
    private ImageView ivPokeballZona3Posicion2Jugador;
    private ImageView ivPokeballZona3Posicion3Jugador;
    private ImageView ivPokeballZona3Posicion4Jugador;
    private ImageView ivPokeballZona4Posicion1Jugador;
    private ImageView ivPokeballZona4Posicion2Jugador;
    private ImageView ivPokeballZona1Posicion1Bot;
    private ImageView ivPokeballZona1Posicion2Bot;
    private ImageView ivPokeballZona2Posicion1Bot;
    private ImageView ivPokeballZona2Posicion2Bot;
    private ImageView ivPokeballZona2Posicion3Bot;
    private ImageView ivPokeballZona3Posicion1Bot;
    private ImageView ivPokeballZona3Posicion2Bot;
    private ImageView ivPokeballZona3Posicion3Bot;
    private ImageView ivPokeballZona3Posicion4Bot;
    private ImageView ivPokeballZona4Posicion1Bot;
    private ImageView ivPokeballZona4Posicion2Bot;
    private List<ImageView> pokeballsJugador;
    private List<ImageView> pokeballsBot;
    private int rondasGanasJugador;
    private int rondasGanasContrincante;
    private List<RondaDTO> resultadosRondas;
    private List<PokemonDTO> pokemonsEliminadosJugador;
    private List<PokemonDTO> pokemonsEliminadosContrincante;
    private PokemonDTO pokemonJugador;
    private PokemonDTO pokemonContrincante;
    private ImageView ivPokemonJugador;
    private ImageView ivPokemonContrincante;
    private int resultadoDado;

    public FightFragment() {
        super(R.layout.fight_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        api = RestClient.getInstance();
        pokeballsJugador = new ArrayList<>();
        pokeballsBot = new ArrayList<>();
        ivPokemonJugador = view.findViewById(R.id.ivPokemonJugador);
        ivPokemonContrincante = view.findViewById(R.id.ivPokemonContrincanten);
        tvPokemonJugador = view.findViewById(R.id.tvPokemonJugador);
        tvPokemonContrincante = view.findViewById(R.id.tvPokemonContrincante);
        pbLifePokemonJugador = view.findViewById(R.id.pbLifePokemonJugador);
        pbLifePokemonBot = view.findViewById(R.id.pbLifePokemonBot);
        ivPokeballZona1Posicion1Jugador = view.findViewById(R.id.ivPokeballZona1Posicion1Jugador);
        pokeballsJugador.add(ivPokeballZona1Posicion1Jugador);
        ivPokeballZona1Posicion2Jugador = view.findViewById(R.id.ivPokeballZona1Posicion2Jugador);
        pokeballsJugador.add(ivPokeballZona1Posicion2Jugador);
        ivPokeballZona2Posicion1Jugador = view.findViewById(R.id.ivPokeballZona2Posicion1Jugador);
        pokeballsJugador.add(ivPokeballZona2Posicion1Jugador);
        ivPokeballZona2Posicion2Jugador = view.findViewById(R.id.ivPokeballZona2Posicion2Jugador);
        pokeballsJugador.add(ivPokeballZona2Posicion2Jugador);
        ivPokeballZona2Posicion3Jugador = view.findViewById(R.id.ivPokeballZona2Posicion3Jugador);
        pokeballsJugador.add(ivPokeballZona2Posicion3Jugador);
        ivPokeballZona3Posicion1Jugador = view.findViewById(R.id.ivPokeballZona3Posicion1Jugador);
        pokeballsJugador.add(ivPokeballZona3Posicion1Jugador);
        ivPokeballZona3Posicion2Jugador = view.findViewById(R.id.ivPokeballZona3Posicion2Jugador);
        pokeballsJugador.add(ivPokeballZona3Posicion2Jugador);
        ivPokeballZona3Posicion3Jugador = view.findViewById(R.id.ivPokeballZona3Posicion3Jugador);
        pokeballsJugador.add(ivPokeballZona3Posicion3Jugador);
        ivPokeballZona3Posicion4Jugador = view.findViewById(R.id.ivPokeballZona3Posicion4Jugador);
        pokeballsJugador.add(ivPokeballZona3Posicion4Jugador);
        ivPokeballZona4Posicion1Jugador = view.findViewById(R.id.ivPokeballZona4Posicion1Jugador);
        pokeballsJugador.add(ivPokeballZona4Posicion1Jugador);
        ivPokeballZona4Posicion2Jugador = view.findViewById(R.id.ivPokeballZona4Posicion2Jugador);
        pokeballsJugador.add(ivPokeballZona4Posicion2Jugador);
        ivPokeballZona1Posicion1Bot = view.findViewById(R.id.ivPokeballZona1Posicion1Bot);
        pokeballsBot.add(ivPokeballZona1Posicion1Bot);
        ivPokeballZona1Posicion2Bot = view.findViewById(R.id.ivPokeballZona1Posicion2Bot);
        pokeballsBot.add(ivPokeballZona1Posicion2Bot);
        ivPokeballZona2Posicion1Bot = view.findViewById(R.id.ivPokeballZona2Posicion1Bot);
        pokeballsBot.add(ivPokeballZona2Posicion1Bot);
        ivPokeballZona2Posicion2Bot = view.findViewById(R.id.ivPokeballZona2Posicion2Bot);
        pokeballsBot.add(ivPokeballZona2Posicion2Bot);
        ivPokeballZona2Posicion3Bot = view.findViewById(R.id.ivPokeballZona2Posicion3Bot);
        pokeballsBot.add(ivPokeballZona2Posicion3Bot);
        ivPokeballZona3Posicion1Bot = view.findViewById(R.id.ivPokeballZona3Posicion1Bot);
        pokeballsBot.add(ivPokeballZona3Posicion1Bot);
        ivPokeballZona3Posicion2Bot = view.findViewById(R.id.ivPokeballZona3Posicion2Bot);
        pokeballsBot.add(ivPokeballZona3Posicion2Bot);
        ivPokeballZona3Posicion3Bot = view.findViewById(R.id.ivPokeballZona3Posicion3Bot);
        pokeballsBot.add(ivPokeballZona3Posicion3Bot);
        ivPokeballZona3Posicion4Bot = view.findViewById(R.id.ivPokeballZona3Posicion4Bot);
        pokeballsBot.add(ivPokeballZona3Posicion4Bot);
        ivPokeballZona4Posicion1Bot = view.findViewById(R.id.ivPokeballZona4Posicion1Bot);
        pokeballsBot.add(ivPokeballZona4Posicion1Bot);
        ivPokeballZona4Posicion2Bot = view.findViewById(R.id.ivPokeballZona4Posicion2Bot);
        pokeballsBot.add(ivPokeballZona4Posicion2Bot);
        tvCaraDado = view.findViewById(R.id.tvCaraDado);
        resultadosRondas = new ArrayList<>();
        pokemonsEliminadosJugador = new ArrayList<>();
        pokemonsEliminadosContrincante = new ArrayList<>();
        api.getPokemonsAlineados(1).enqueue(new Callback<List<PokemonDTO>>() {
            @Override
            public void onResponse(Call<List<PokemonDTO>> call, Response<List<PokemonDTO>> response) {
                if (response.isSuccessful()) {
                    pokemonsAPelearJugador = response.body();
                    api.getPokemonsAlineados(idContrincante).enqueue(new Callback<List<PokemonDTO>>() {
                        @Override
                        public void onResponse(Call<List<PokemonDTO>> call, Response<List<PokemonDTO>> response) {
                            pokemonsAPelearContrincantes = response.body();
                            boolean batalla = true;
                            while (batalla) {
                                RondaDTO rondaDTO = new RondaDTO();
                                Collections.shuffle(pokemonsAPelearJugador);
                                pokemonJugador = pokemonsAPelearJugador.get(0);
                                while (pokemonsEliminadosJugador.contains(pokemonJugador)) {
                                    Collections.shuffle(pokemonsAPelearJugador);
                                    pokemonJugador = pokemonsAPelearJugador.get(0);
                                }
                                tvPokemonJugador.setText(pokemonJugador.getName());
                                Picasso.get().load(pokemonJugador.getHiresURL()).into(ivPokemonJugador);
                                pbLifePokemonJugador.setProgress(pokemonJugador.getHp());
                                pokemonContrincante = null;
                                for (PokemonDTO pokemonDTO : pokemonsAPelearContrincantes) {
                                    if (!pokemonsEliminadosContrincante.contains(pokemonDTO)) {
                                        pokemonContrincante = pokemonDTO;
                                        break;
                                    }
                                }
                                tvPokemonContrincante.setText(pokemonContrincante.getName());
                                Picasso.get().load(pokemonContrincante.getHiresURL()).into(ivPokemonContrincante);
                                pbLifePokemonBot.setProgress(pokemonContrincante.getHp());
                                int turno = 0;
                                while (turno < 2) {
                                    if (pokemonJugador.getSpeed() > pokemonContrincante.getSpeed()) {
                                        resultadoDado = (new Random().nextInt(20) + 1) * (new Random().nextInt(pokemonJugador.getLevel() + 1));
                                        tvCaraDado.setText(String.valueOf(resultadoDado));
                                        rondaDTO.setDadoUsuario(resultadoDado);
                                        if (pokemonContrincante.getHp() - resultadoDado > 0) {
                                            pokemonContrincante.setHp(pokemonContrincante.getHp() - resultadoDado);
                                        } else {
                                            pokemonsEliminadosContrincante.add(pokemonContrincante);
                                        }

                                    } else {
                                        tvCaraDado.setText(String.valueOf(resultadoDado));
                                        rondaDTO.setDadoJugador(resultadoDado);
                                        if (pokemonContrincante.getHp() - resultadoDado > 0) {
                                            pokemonContrincante.setHp(pokemonContrincante.getHp() - resultadoDado);
                                        } else {

                                            pokemonsEliminadosJugador.add(pokemonJugador);
                                        }

                                    }
                                    resultadosRondas.add(rondaDTO);
                                    if (pokemonsEliminadosJugador.size() == 11 || pokemonsEliminadosContrincante.size() == 11) {
                                        batalla = false;
                                    }
                                    turno++;
                                }
                            }

                            CombateDTO combateDTO = new CombateDTO();
                            if (rondasGanasJugador > rondasGanasContrincante) {
                                combateDTO.setUsuarioWinner(1);
                            } else if (rondasGanasContrincante > rondasGanasJugador) {
                                combateDTO.setJugadorWinner(idContrincante);
                            } else {
                                combateDTO.setUsuarioWinner(1);
                                combateDTO.setJugadorWinner(idContrincante);
                            }
                            combateDTO.setFecha(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss", Locale.US).format(new Date()));
                            combateDTO.setEntrenadorId(idContrincante);
                            combateDTO.setUsuarioId(1);
                            api.mandarCombate(combateDTO).enqueue(new Callback<Boolean>() {
                                @Override
                                public void onResponse (Call<Boolean> call, Response<Boolean> response) {
                                    if (response.isSuccessful()) {
                                        Toast.makeText(getContext(), "Acaba", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<Boolean> call, Throwable t) {

                                }
                            });
                        }

                        @Override
                        public void onFailure(Call<List<PokemonDTO>> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<PokemonDTO>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttach iOnAttach = (IOnAttach) context;
        idContrincante = iOnAttach.getContrincante();
    }
}
