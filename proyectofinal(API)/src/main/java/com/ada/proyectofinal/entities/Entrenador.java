package com.ada.proyectofinal.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "entrenador")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 45, nullable = false)
    private String nombre;

    @Column(length = 45, nullable = false)
    private String apellido;

    @Column(nullable = false)
    private boolean genero;

    @Column(length = 255)
    private String icono;

    @Column(nullable = false)
    private float dinero;

    @OneToOne(mappedBy = "entrenador")
    @JsonManagedReference("entrenador-combate")
    private Combate  combate;

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pokemon> pokemons = new ArrayList<>();

    @OneToMany(mappedBy = "entrenador", cascade = CascadeType.ALL)
    @JsonManagedReference("entrenador-resultados")
    private List<Resultado> resultados = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    @JsonBackReference("usuario-entrenador")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    private Usuario usuario;
    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", Icono='" + icono + '\'' +
                ", dinero=" + dinero +
                ", resultados=" + resultados +
                '}';
    }
}
