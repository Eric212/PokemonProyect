package com.ericsospedra.pokemonproyect.models;


import java.util.ArrayList;
import java.util.List;

public class Entrenador {

    private int id;

    private String nombre;

    private String apellido;

    private String Icono;

    private float dinero;

    private List<Pokemon> pokemons = new ArrayList<>();

    private List<Resultado> resultados = new ArrayList<>();

    public Entrenador(int id, String nombre, String apellido, String icono, float dinero, List<Pokemon> pokemons, List<Resultado> resultados) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        Icono = icono;
        this.dinero = dinero;
        this.pokemons = pokemons;
        this.resultados = resultados;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIcono() {
        return Icono;
    }

    public float getDinero() {
        return dinero;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", Icono='" + Icono + '\'' +
                ", dinero=" + dinero +
                ", pokemons=" + pokemons +
                ", resultados=" + resultados +
                '}';
    }
}
