package com.ada.proyectofinal.dto;


public class ResultadoDTO {

    private int id;
    private int entrenador;

    public ResultadoDTO() {

    }

    public ResultadoDTO(int id, int entrenador) {
        this.id = id;
        this.entrenador = entrenador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(int entrenador) {
        this.entrenador = entrenador;
    }
}