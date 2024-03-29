package com.ericsospedra.pokemonproyect.dto;

import com.ericsospedra.pokemonproyect.models.Usuario;

public class UsuarioDTO {
    private int id;
    private String username;
    private String password;
    private String token;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String username, String password, String token) {
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public UsuarioDTO(int id, String username, String password, String token) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
    }

    public static UsuarioDTO fromUsuario(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setToken(usuarioDTO.getToken());
        return usuarioDTO;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
