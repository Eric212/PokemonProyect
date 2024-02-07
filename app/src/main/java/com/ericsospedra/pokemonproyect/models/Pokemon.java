package com.ericsospedra.pokemonproyect.models;

public class Pokemon {
    private int id;
    private String name;
    private String type;
    private int hp;
    private int attack;
    private int defence;
    private int speed;
    private Prev prev;
    private Next next;
    private String gender;
    private String hiresURL;

    public Pokemon(int id, String name, String type, int hp, int attack, int defence, int speed, Prev prev, Next next, String gender, String hiresURL) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.prev = prev;
        this.next = next;
        this.gender = gender;
        this.hiresURL = hiresURL;
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

    public Prev getPrev() {
        return prev;
    }

    public Next getNext() {
        return next;
    }

    public String getGender() {
        return gender;
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
                ", prev=" + prev +
                ", next=" + next +
                ", gender='" + gender + '\'' +
                ", hiresURL='" + hiresURL + '\'' +
                '}';
    }
}
