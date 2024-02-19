package com.ada.proyectofinal.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "combates")
public class Combate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "usuario_winner")
    private int usuarioWinner;

    @Column(name = "jugador_winner")
    private int jugadorWinner;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference("usuario-combate")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "entrenador_id")
    @JsonBackReference("entrenador-combate")
    private Entrenador  entrenador;


    @OneToMany(mappedBy = "combate")
    @JsonManagedReference("combate-rondas")
    private List<Ronda> rondas;

}