package com.ada.proyectofinal.dto;

import java.util.List;

public class AlineacionDTO {

    private int id;
    private String zona;

    public AlineacionDTO() {
    }

    public AlineacionDTO(int id, String zona) {
        this.id = id;
        this.zona = zona;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

}

