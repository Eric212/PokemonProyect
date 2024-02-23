package com.ericsospedra.pokemonproyect.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.dto.PokemonDTO;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.ericsospedra.pokemonproyect.models.RestClient;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetailFragment extends Fragment implements View.OnClickListener {
    private View menuLayout;
    private ImageView ivHome;
    private ImageView ivTrainer;
    private ImageView ivPokedex;
    private ImageView ivBattle;
    private ImageView ivMarket;

    private IOnClickListener listener;

    public interface IOnAttach{
        int getPokemonId();
    }
    private IApiService api;
    private int pokemonId;

    public PokemonDetailFragment() {
        super(R.layout.pokemon_detail_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        api = RestClient.getInstance();
        menuLayout = view.findViewById(R.id.iMenuPokemonDetail);
        ivHome = menuLayout.findViewById(R.id.ivHome);
        ivTrainer = menuLayout.findViewById(R.id.ivTrainer);
        ivPokedex = menuLayout.findViewById(R.id.ivPokedex);
        ivBattle = menuLayout.findViewById(R.id.ivBattle);
        ivMarket = menuLayout.findViewById(R.id.ivMarket);
        ivHome.setOnClickListener(this);
        ivTrainer.setOnClickListener(this);
        ivPokedex.setOnClickListener(this);
        ivBattle.setOnClickListener(this);
        ivMarket.setOnClickListener(this);
        api.getPokemon(pokemonId).enqueue(new Callback<PokemonDTO>() {
            @Override
            public void onResponse(Call<PokemonDTO> call, Response<PokemonDTO> response) {
                PokemonDTO pokemon = response.body();
                if(pokemon.getType().equalsIgnoreCase("grass")) {
                    view.setBackgroundResource(R.drawable.grass);
                }else if(pokemon.getType().equalsIgnoreCase("fire")){
                    view.setBackgroundResource(R.drawable.fire);
                }else if(pokemon.getType().equalsIgnoreCase("water")){
                    view.setBackgroundResource(R.drawable.water);
                }else if(pokemon.getType().equalsIgnoreCase("bug")){
                    view.setBackgroundResource(R.drawable.bug);
                }else if(pokemon.getType().equalsIgnoreCase("normal")){
                    view.setBackgroundResource(R.drawable.normal);
                }else if(pokemon.getType().equalsIgnoreCase("poison")){
                    view.setBackgroundResource(R.drawable.posion);
                }else if(pokemon.getType().equalsIgnoreCase("electric")){
                    view.setBackgroundResource(R.drawable.electric);
                }else if(pokemon.getType().equalsIgnoreCase("ground")){
                    view.setBackgroundResource(R.drawable.ground);
                }else if(pokemon.getType().equalsIgnoreCase("fairy")){
                    view.setBackgroundResource(R.drawable.fairy);
                }else if(pokemon.getType().equalsIgnoreCase("fighting")){
                    view.setBackgroundResource(R.drawable.fighting);
                }else if(pokemon.getType().equalsIgnoreCase("psychic")){
                    view.setBackgroundResource(R.drawable.psychic);
                }else if(pokemon.getType().equalsIgnoreCase("rock")){
                    view.setBackgroundResource(R.drawable.rock);
                }else if(pokemon.getType().equalsIgnoreCase("ghost")){
                    view.setBackgroundResource(R.drawable.ghost);
                }else if(pokemon.getType().equalsIgnoreCase("Ice")){
                    view.setBackgroundResource(R.drawable.ice);
                }else{//dragon
                    view.setBackgroundResource(R.drawable.dragon);
                }
                ImageView ivPokemon = view.findViewById(R.id.ivPokemonDetail);
                TextView tvPokemonName = view.findViewById(R.id.tvPokemonName);
                TextView tvType = view.findViewById(R.id.tvType);
                TextView tvLevel = view.findViewById(R.id.tvLevel);
                TextView tvLife = view.findViewById(R.id.tvLife);
                TextView tvAttack =view.findViewById(R.id.tvAttack);
                TextView tvDefence =view.findViewById(R.id.tvDefence);
                TextView tvSpeed =view.findViewById(R.id.tvSpeed);
                ProgressBar pbLife = view.findViewById(R.id.pbLife);
                ProgressBar pbAttack = view.findViewById(R.id.pbAttack);
                ProgressBar pbDefence = view.findViewById(R.id.pbDefence);
                ProgressBar pbSpeed = view.findViewById(R.id.pbSpeed);
                Picasso.get().load(pokemon.getHiresURL()).into(ivPokemon);
                tvPokemonName.setText(pokemon.getName());
                tvType.setText(pokemon.getType());
                tvLevel.setText(String.valueOf(pokemon.getLevel()));
                tvLife.setText(String.valueOf(pokemon.getHp()));
                tvAttack.setText(String.valueOf(pokemon.getAttack()));
                tvDefence.setText(String.valueOf(pokemon.getDefence()));
                tvSpeed.setText(String.valueOf(pokemon.getSpeed()));
                pbLife.setMax(100);
                pbLife.setProgress(pokemon.getHp());
                pbAttack.setProgress(pokemon.getAttack());
                pbDefence.setProgress(pokemon.getDefence());
                pbSpeed.setProgress(pokemon.getSpeed());
            }

            @Override
            public void onFailure(Call<PokemonDTO> call, Throwable t) {
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttach iOnAttach = (IOnAttach) context;
        listener = (IOnClickListener)context;
        pokemonId = iOnAttach.getPokemonId();
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == ivHome.getId() || v.getId() == ivTrainer.getId() || v.getId() == ivBattle.getId() || v.getId() == ivMarket.getId() || v.getId() == ivPokedex.getId()) {
            listener.onClick(v.getId());
        }
    }
}
