package com.ericsospedra.pokemonproyect.models;

public class Usuario {
    private int id;
    private String username;
    private String password;
    private String token;

    public Usuario() {
    }

    public Usuario(String username, String password, String token) {
        this.username = username;
        this.password = password;
        this.token = token;
    }
    public Usuario(int id, String username, String password, String token) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
