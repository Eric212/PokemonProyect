package com.ada.proyectofinal.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mercado")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String fecha;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference("mercado-pokemons")
    private List<Pokemon> pokemons = new ArrayList<>();

}
