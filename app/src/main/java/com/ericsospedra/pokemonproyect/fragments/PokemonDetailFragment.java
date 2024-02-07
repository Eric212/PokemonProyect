package com.ericsospedra.pokemonproyect.fragments;

import androidx.fragment.app.Fragment;

import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.Pokemon;

public class PokemonDetailFragment extends Fragment {
    private Pokemon pokemon;
    private IOnClickListener listener;

    public PokemonDetailFragment() {
        super();
    }
}
