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
    private float valor;
    private String hiresURL;
    private int entrenador;
    private Mercado mercado;
    private Alineacion alineacion;

    public Pokemon() {
    }

    public Pokemon(int id, String name, String type, int level, int hp, int attack, int defence, int speed, String gender, float valor, String hiresURL, int entrenador, Mercado mercado, Alineacion alineacion) {
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
        this.mercado = mercado;
        this.alineacion = alineacion;
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

    public void setEntrenador(int entrenador) {
        this.entrenador = entrenador;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setAlineacion(Alineacion alineacion) {
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

    public int getEntrenador() {
        return entrenador;
    }

    public Alineacion getAlineacion() {
        return alineacion;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public float getValor() {
        return valor;
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
                ", valor=" + valor +
                ", hiresURL='" + hiresURL + '\'' +
                ", entrenador=" + entrenador +
                ", mercado=" + (mercado != null ? mercado.getId() : null) +
                ", alineacion=" + (alineacion != null ? alineacion.getId() : null) +
                '}';
    }

}
