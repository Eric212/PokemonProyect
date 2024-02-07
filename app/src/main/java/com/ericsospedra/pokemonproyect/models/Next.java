package com.ericsospedra.pokemonproyect.models;

import java.util.List;

public class Next {
    List<List<String>> evolution;

    public Next() {
    }

    public Next(List<List<String>> evolution) {
        this.evolution = evolution;
    }

    public List<List<String>> getEvolution() {
        return evolution;
    }

    public void setEvolution(List<List<String>> evolution) {
        this.evolution = evolution;
    }
}
