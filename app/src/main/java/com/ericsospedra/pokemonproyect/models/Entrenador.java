package com.ericsospedra.pokemonproyect.models;


import com.ericsospedra.pokemonproyect.dto.EntrenadorDTO;

import java.util.ArrayList;
import java.util.List;

public class Entrenador {

    private int id;

    private String nombre;

    private String apellido;

    private boolean genero;

    private String icono;

    private float dinero;
    private Usuario usuario;

    private List<Pokemon> pokemons = new ArrayList<>();

    private List<Resultado> resultados = new ArrayList<>();

    public Entrenador() {
    }

    public Entrenador(String nombre, String apellido, boolean genero, String icono, float dinero, Usuario usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.icono = icono;
        this.dinero = dinero;
        this.usuario = usuario;
    }

    public Entrenador(int id, String nombre, String apellido, String icono, float dinero, Usuario usuario, List<Pokemon> pokemons, List<Resultado> resultados) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.icono = icono;
        this.dinero = dinero;
        this.usuario = usuario;
        this.pokemons = pokemons;
        this.resultados = resultados;
    }

    public Entrenador(int id) {
        this.id = id;
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
        return icono;
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

    public boolean isGenero() {
        return genero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", Icono='" + icono + '\'' +
                ", dinero=" + dinero +
                ", pokemons=" + pokemons +
                ", resultados=" + resultados +
                '}';
    }
}
