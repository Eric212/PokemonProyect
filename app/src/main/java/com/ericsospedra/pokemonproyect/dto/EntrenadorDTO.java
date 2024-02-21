package com.ericsospedra.pokemonproyect.dto;


import com.ericsospedra.pokemonproyect.models.Entrenador;

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
    private List<ResultadoDTO> resultados = new ArrayList<>();
    private int usuario_id;

    public EntrenadorDTO() {
    }

    public EntrenadorDTO(String nombre, String apellido, boolean genero, String icono, float dinero,int usurio_id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.icono = icono;
        this.dinero = dinero;
        this.usuario_id = usurio_id;
    }

    public EntrenadorDTO(int id, String nombre, String apellido, boolean genero, String icono, float dinero, List<PokemonDTO> pokemons, List<ResultadoDTO> resultados) {
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
        if(entrenador.getUsuario()!=null) {
            entrenadorDTO.setUsuario_id(entrenador.getUsuario().getId());
        }
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

    public List<ResultadoDTO> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoDTO> resultados) {
        this.resultados = resultados;
    }

    public int getUsuario() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
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
