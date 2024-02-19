package com.ada.proyectofinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "rondas")
public class Ronda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int dadoJugador;

    @Column
    private int dadoUsuario;

    @Column
    private int dadoCarta;

    @Column
    private int usuWinner;

    @Column
    private int jugWinner;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "combate_id")
    @JsonBackReference("combate-rondas")
    private Combate combate;
}
