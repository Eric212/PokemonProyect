package com.ericsospedra.pokemonproyect.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.squareup.picasso.Picasso;

public class PokemonDetailFragment extends Fragment {
    public interface IOnAttach{
        Pokemon getPokemon();
    }
    private Pokemon pokemon;
    private IOnClickListener listener;

    public PokemonDetailFragment() {
        super(R.layout.pokemon_detail_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(pokemon.getType().equalsIgnoreCase("grass")) {
            view.setBackgroundResource(R.drawable.grass);
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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttach iOnAttach = (IOnAttach) context;
        pokemon = iOnAttach.getPokemon();
    }
}
