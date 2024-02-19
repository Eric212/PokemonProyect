package com.ada.proyectofinal.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "pokemon")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(length = 45, nullable = false)
    private String type;

    @Column(nullable = false)
    private int level;

    @Column(length = 100, nullable = false)
    private int hp;

    @Column(length = 45, nullable = false)
    private int attack;

    @Column(length = 45, nullable = false)
    private int defence;

    @Column(length = 45, nullable = false)
    private int speed;

    @Column
    private String gender;

    @Column
    private float valor;

    @Column
    private String hiresURL;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "entrenador_id")
    @JsonBackReference("entrenador-pokemons")
    private Entrenador entrenador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mercado_id")
    @JsonBackReference("mercado-pokemons")
    private Mercado mercado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alineacion_id")
    @JsonBackReference("alineacion-pokemons")
    private Alineacion alineacion;
}
