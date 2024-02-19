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
    private Entrenador entrenador;
    private Mercado mercado;
    private Alineacion alineacion;

    public Pokemon() {
    }

    public Pokemon(int id, String name, String type, int level, int hp, int attack, int defence, int speed, String gender, String hiresURL, Entrenador entrenador, Mercado mercadoId, Alineacion alineacionId) {
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
        this.entrenador = entrenador;
        this.mercado = mercadoId;
        this.alineacion = alineacionId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHiresURL(String hiresURL) {
        this.hiresURL = hiresURL;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public void setMercado_id(Mercado mercado) {
        this.mercado = mercado;
    }

    public void setAlineacion(Alineacion alineacion_) {
        this.alineacion = alineacion;
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

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public Mercado getMercado_id() {
        return mercado;
    }

    public Alineacion getAlineacion() {
        return alineacion;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defence=" + defence +
                ", speed=" + speed +
                ", gender='" + gender + '\'' +
                ", hiresURL='" + hiresURL + '\'' +
                ", entrenador_id=" + entrenador +
                ", mercado_id=" + mercado +
                ", alineacion_id=" + alineacion +
                '}';
    }
}
