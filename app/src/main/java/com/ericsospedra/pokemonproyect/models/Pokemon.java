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
    private String hiresURL;

    public Pokemon(int id, String name, String type, int level, int hp, int attack, int defence, int speed, String hiresURL) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.hiresURL = convertirHiresUrl(hiresURL);
    }

    private String convertirHiresUrl(String s) {
        String[] temporaly = s.split("/");
        String imageWithExtension = temporaly[temporaly.length-1];
        return imageWithExtension.split("\\.")[0];
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
    public String getHiresURL() {
        return hiresURL;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                ", speed=" + speed +
                ", hiresURL='" + hiresURL + '\'' +
                '}';
    }
}
