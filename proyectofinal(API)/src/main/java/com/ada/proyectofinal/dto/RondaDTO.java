package com.ada.proyectofinal.dto;

public class RondaDTO {
    private int id;
    private int dadoJugador;
    private int dadoUsuario;
    private int usuWinner;
    private int playerWinner;
    private int combate;

    public RondaDTO() {
    }

    public RondaDTO(int id, int dadoJugador, int dadoUsuario, int usuWinner, int playerWinner, int combate) {
        this.id = id;
        this.dadoJugador = dadoJugador;
        this.dadoUsuario = dadoUsuario;
        this.usuWinner = usuWinner;
        this.playerWinner = playerWinner;
        this.combate = combate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDadoJugador() {
        return dadoJugador;
    }

    public void setDadoJugador(int dadoJugador) {
        this.dadoJugador = dadoJugador;
    }

    public int getDadoUsuario() {
        return dadoUsuario;
    }

    public void setDadoUsuario(int dadoUsuario) {
        this.dadoUsuario = dadoUsuario;
    }

    public int getUsuWinner() {
        return usuWinner;
    }

    public void setUsuWinner(int usuWinner) {
        this.usuWinner = usuWinner;
    }

    public int getPlayerWinner() {
        return playerWinner;
    }

    public void setPlayerWinner(int playerWinner) {
        this.playerWinner = playerWinner;
    }

    public int getCombate() {
        return combate;
    }

    public void setCombate(int combate) {
        this.combate = combate;
    }

    @Override
    public String toString() {
        return "RondaDTO{" +
                "id=" + id +
                ", dadoJugador=" + dadoJugador +
                ", dadoUsuario=" + dadoUsuario +
                ", usuWinner=" + usuWinner +
                ", playerWinner=" + playerWinner +
                ", combate=" + combate +
                '}';
    }
}
