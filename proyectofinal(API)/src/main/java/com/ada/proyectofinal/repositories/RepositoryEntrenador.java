package com.ada.proyectofinal.repositories;

import com.ada.proyectofinal.entities.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryEntrenador extends JpaRepository<Entrenador, Integer> {

    @Query(value = "SELECT * FROM entrenador WHERE id = :id", nativeQuery = true)
    Entrenador findById(int id);

    @Query(value = "SELECT * FROM entrenador WHERE id != 1", nativeQuery = true)
    List<Entrenador> recuperarBots();

    @Query(value = "SELECT * FROM entrenador WHERE nombre=:name", nativeQuery = true)
    Entrenador findByName(String name);

    @Query(value = "SELECT * FROM entrenador WHERE usuario_id = :id",nativeQuery = true)
    Entrenador findByUsuario(int id);

    @Query(value = "SELECT * FROM entrenador WHERE usuario_id = :id",nativeQuery = true)
    Entrenador recuperarEntrenadorPorUsuario(int id);
}
