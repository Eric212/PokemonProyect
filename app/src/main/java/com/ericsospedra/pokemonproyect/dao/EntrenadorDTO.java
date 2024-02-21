package com.ericsospedra.pokemonproyect.dao;
import com.ericsospedra.pokemonproyect.models.Entrenador;
import com.ericsospedra.pokemonproyect.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class EntrenadorDTO {

    private int id;
    private String nombre;
    private String apellido;
    private boolean genero;
    private String icono;
    private float dinero;
    private List<PokemonDTO> pokemons = new ArrayList<>();
    private List<Resultado> resultados = new ArrayList<>();

    public EntrenadorDTO() {
    }

    public EntrenadorDTO(String nombre, String apellido, boolean genero, String icono, float dinero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.icono = icono;
        this.dinero = dinero;
    }

    public EntrenadorDTO(int id, String nombre, String apellido, boolean genero, String icono, float dinero, List<PokemonDTO> pokemons, List<Resultado> resultados) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.icono = icono;
        this.dinero = dinero;
        this.pokemons = pokemons;
        this.resultados = resultados;
    }

    public static EntrenadorDTO fromEntrenador(Entrenador entrenador) {
        EntrenadorDTO entrenadorDTO = new EntrenadorDTO();
        entrenadorDTO.setId(entrenador.getId());
        entrenadorDTO.setNombre(entrenador.getNombre());
        entrenadorDTO.setApellido(entrenador.getApellido());
        entrenadorDTO.setGenero(entrenador.isGenero());
        entrenadorDTO.setIcono(entrenador.getIcono());
        entrenadorDTO.setDinero(entrenador.getDinero());
        entrenadorDTO.setPokemons(PokemonDTO.listaPokemonDTO(entrenador.getPokemons()));
        return entrenadorDTO;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    public List<PokemonDTO> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonDTO> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Resultado> getResultados() {
        return resultados;
    }

    public void setResultados(List<Resultado> resultados) {
        this.resultados = resultados;
    }

    @Override
    public String toString() {
        return "EntrenadorDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", genero=" + genero +
                ", icono='" + icono + '\'' +
                ", dinero=" + dinero +
                ", pokemons=" + pokemons +
                ", resultados=" + resultados +
                '}';
    }
}
