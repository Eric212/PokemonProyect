package com.ada.proyectofinal.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alineacion")
public class Alineacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String zona;

    @OneToMany(mappedBy = "alineacion", cascade = CascadeType.ALL)
    @JsonManagedReference("alineacion-pokemons")
    private List<Pokemon> pokemons;
    @Override
    public String toString() {
        return "Alineacion{" +
                "id=" + id +
                ", zona='" + zona + '\'' +
                '}';
    }
}
