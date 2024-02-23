package com.ericsospedra.pokemonproyect.models;


import java.util.List;

public class Alineacion {

    private int id;

    private String zona;

    public Alineacion(int id, String zona) {
        this.id = id;
        this.zona = zona;
    }

    public Alineacion(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        return "Alineacion{" +
                "id=" + id +
                ", zona='" + zona + '\'' +
                '}';
    }
}
