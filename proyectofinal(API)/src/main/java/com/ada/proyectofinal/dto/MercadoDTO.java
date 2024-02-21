package com.ada.proyectofinal.dto;


import com.ada.proyectofinal.entities.Mercado;

import java.util.ArrayList;
import java.util.List;

public class MercadoDTO {

    private int id;
    private String fecha;
    private List<PokemonDTO> pokemons = new ArrayList<>();

    public MercadoDTO() {
    }

    public MercadoDTO(int id, String fecha, List<PokemonDTO> pokemons) {
        this.id = id;
        this.fecha = fecha;
        this.pokemons = pokemons;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<PokemonDTO> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonDTO> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return "MercadoDTO{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", pokemons=" + pokemons +
                '}';
    }
}
