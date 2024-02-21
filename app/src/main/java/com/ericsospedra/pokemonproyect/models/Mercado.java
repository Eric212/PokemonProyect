package com.ericsospedra.pokemonproyect.models;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

    private int id;

    private String fecha;

    private List<Pokemon> pokemons = new ArrayList<>();

    public Mercado(int id, String fecha, List<Pokemon> pokemons) {
        this.id = id;
        this.fecha = fecha;
        this.pokemons = pokemons;
    }

    public Mercado(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }
}
