package com.ericsospedra.pokemonproyect.dao;

import com.ericsospedra.pokemonproyect.models.Pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class PokemonDTO {
    private int id;
    private String name;
    private String type;
    private int level;
    private int hp;
    private int attack;
    private int defence;
    private int speed;
    private String gender;
    private float valor;
    private String hiresURL;
    private int entrenador;
    private int mercadoId;
    private int alineacionId;

    // Constructor, getters y setters
    public PokemonDTO() {
    }

    public PokemonDTO(int id, String name, String type, int level, int hp, int attack, int defence, int speed, String gender, float valor, String hiresURL, int entrenador, int mercadoId, int alineacionId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.gender = gender;
        this.valor = valor;
        this.hiresURL = hiresURL;
        this.entrenador = entrenador;
        this.mercadoId = mercadoId;
        this.alineacionId = alineacionId;
    }

    public static PokemonDTO fromPokemon(Pokemon pokemon) {
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(pokemon.getId());
        pokemonDTO.setName(pokemon.getName());
        pokemonDTO.setType(pokemon.getType());
        pokemonDTO.setLevel(pokemon.getLevel());
        pokemonDTO.setHp(pokemon.getHp());
        pokemonDTO.setAttack(pokemon.getAttack());
        pokemonDTO.setDefence(pokemon.getDefence());
        pokemonDTO.setSpeed(pokemon.getSpeed());
        pokemonDTO.setGender(pokemon.getGender());
        pokemonDTO.setValor(pokemon.getValor());
        pokemonDTO.setHiresURL(pokemon.getHiresURL());
        pokemonDTO.setEntrenador(pokemon.getEntrenador());
        pokemonDTO.setMercadoId(pokemon.getMercado().getId());
        pokemonDTO.setAlineacionId(pokemon.getAlineacion().getId());
        return pokemonDTO;
    }
    public static List<PokemonDTO> listaPokemonDTO(List<Pokemon> pokemons) {
        return pokemons.stream()
             .map(pokemon -> {
                 PokemonDTO pokemonDTO = new PokemonDTO();
                 pokemonDTO.setId(pokemon.getId());
                 pokemonDTO.setName(pokemon.getName());
                 pokemonDTO.setType(pokemon.getType());
                 pokemonDTO.setLevel(pokemon.getLevel());
                 pokemonDTO.setHp(pokemon.getHp());
                 pokemonDTO.setAttack(pokemon.getAttack());
                 pokemonDTO.setDefence(pokemon.getDefence());
                 pokemonDTO.setSpeed(pokemon.getSpeed());
                 pokemonDTO.setGender(pokemon.getGender());
                 pokemonDTO.setValor(pokemon.getValor());
                 pokemonDTO.setHiresURL(pokemon.getHiresURL());
                 pokemonDTO.setEntrenador(pokemon.getEntrenador());
                 pokemonDTO.setMercadoId(pokemon.getMercado().getId());
                 pokemonDTO.setAlineacionId(pokemon.getAlineacion().getId());
                 return pokemonDTO;
             })
             .collect(Collectors.toList());
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getHiresURL() {
        return hiresURL;
    }

    public void setHiresURL(String hiresURL) {
        this.hiresURL = hiresURL;
    }

    public int getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(int entrenador) {
        this.entrenador = entrenador;
    }

    public int getMercadoId() {
        return mercadoId;
    }

    public void setMercadoId(int mercadoId) {
        this.mercadoId = mercadoId;
    }

    public int getAlineacionId() {
        return alineacionId;
    }

    public void setAlineacionId(int alineacionId) {
        this.alineacionId = alineacionId;
    }
}
