package com.ada.proyectofinal.dto;

import java.util.List;

public class    CombateDTO {

    private int id;
    private String fecha;
    private int usuarioWinner;
    private int jugadorWinner;
    private int usuarioId;
    private int entrenadorId;

    public CombateDTO() {
    }

    public CombateDTO(int id, String fecha, int usuarioWinner, int jugadorWinner, int usuarioId, int entrenadorId) {
        this.id = id;
        this.fecha = fecha;
        this.usuarioWinner = usuarioWinner;
        this.jugadorWinner = jugadorWinner;
        this.usuarioId = usuarioId;
        this.entrenadorId = entrenadorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getUsuarioWinner() {
        return usuarioWinner;
    }

    public void setUsuarioWinner(int usuarioWinner) {
        this.usuarioWinner = usuarioWinner;
    }

    public int getJugadorWinner() {
        return jugadorWinner;
    }

    public void setJugadorWinner(int jugadorWinner) {
        this.jugadorWinner = jugadorWinner;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getEntrenadorId() {
        return entrenadorId;
    }

    public void setEntrenadorId(int entrenadorId) {
        this.entrenadorId = entrenadorId;
    }

    @Override
    public String toString() {
        return "CombateDTO{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", usuarioWinner=" + usuarioWinner +
                ", jugadorWinner=" + jugadorWinner +
                ", usuarioId=" + usuarioId +
                ", entrenadorId=" + entrenadorId +
                '}';
    }
}
