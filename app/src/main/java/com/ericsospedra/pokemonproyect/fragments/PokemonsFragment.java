package com.ericsospedra.pokemonproyect.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.adapters.PokemonAdapter;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.Pokemon;

import java.util.List;

public class PokemonsFragment extends Fragment {
    public interface IOnAttach{
        List<Pokemon> getPokemons();
    }

    private List<Pokemon> pokemons;
    private IOnClickListener listener;

    public PokemonsFragment() {
        super(R.layout.pokemons_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvPokemons = view.findViewById(R.id.rvPokemons);
        PokemonAdapter adapter = new PokemonAdapter(pokemons,listener);
        rvPokemons.setAdapter(adapter);
        rvPokemons.setLayoutManager(new GridLayoutManager(view.getContext(),3,GridLayoutManager.VERTICAL,false));
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IOnAttach iOnAttach = (IOnAttach) context;
        pokemons = iOnAttach.getPokemons();
        listener = (IOnClickListener) context;
    }
}