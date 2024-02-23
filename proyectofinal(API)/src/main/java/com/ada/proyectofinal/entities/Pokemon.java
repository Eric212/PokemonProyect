package com.ada.proyectofinal.entities;

import com.ada.proyectofinal.dto.PokemonDTO;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

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

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "entrenador_id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    @JsonBackReference
    private Entrenador entrenador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mercado_id")
    @JsonBackReference("mercado-pokemons")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private Mercado mercado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alineacion_id")
    @JsonBackReference("alineacion-pokemons")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private Alineacion alineacion;
    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", attack=" + attack +
                ", defence=" + defence +
                ", speed=" + speed +
                ", gender='" + gender + '\'' +
                ", valor=" + valor +
                ", hiresURL='" + hiresURL + '\'' +
                ", entrenador=" + (entrenador != null ? entrenador.getId() : null) +
                ", mercado=" + (mercado != null ? mercado.getId() : null) +
                ", alineacion=" + (alineacion != null ? alineacion.getId() : null) +
                '}';
    }
}
