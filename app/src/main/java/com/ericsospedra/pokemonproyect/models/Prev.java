package com.ericsospedra.pokemonproyect.models;

import java.util.List;

public class Prev {
    List<String> preEvolution;

    public Prev() {
    }

    public Prev(List<String> preEvolution) {
        this.preEvolution = preEvolution;
    }

    public List<String> getPreEvolution() {
        return preEvolution;
    }

    public void setPreEvolution(List<String> preEvolution) {
        this.preEvolution = preEvolution;
    }
}
