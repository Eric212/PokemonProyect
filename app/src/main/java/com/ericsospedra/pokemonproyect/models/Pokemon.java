package com.ericsospedra.pokemonproyect.models;

public class Pokemon {

    private int id;

    private String name;

    private String type;

    private int level;

    private int hp;

    private int attack;

    private int defence;

    private int speed;

    private String gender;

    private String hiresURL;
    private int entrenador_id;
    private int mercado_id;
    private int alineacion_id;

    public Pokemon(int id, String name, String type, int level, int hp, int attack, int defence, int speed, String gender, String hiresURL, int entrenadorId, int mercadoId, int alineacionId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.gender = gender;
        this.hiresURL = hiresURL;
        entrenador_id = entrenadorId;
        mercado_id = mercadoId;
        alineacion_id = alineacionId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getSpeed() {
        return speed;
    }

    public String getGender() {
        return gender;
    }

    public String getHiresURL() {
        return hiresURL;
    }

    public int getEntrenador_id() {
        return entrenador_id;
    }

    public int getMercado_id() {
        return mercado_id;
    }

    public int getAlineacion_id() {
        return alineacion_id;
    }
}
