package com.ada.proyectofinal.repositories;

import com.ada.proyectofinal.entities.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RepositoryPokemon extends JpaRepository<Pokemon, Integer> {

    @Query(value = "SELECT * FROM pokemon WHERE id = :id", nativeQuery = true)
    Pokemon findById(int id);

    @Query(value = "SELECT * FROM pokemon WHERE entrenador_id IS NULL Limit :limit", nativeQuery = true)
    List<Pokemon> recuperarPokemons(int limit);

    @Query(value = "SELECT * FROM pokemon WHERE entrenador_id = :id", nativeQuery = true)
    List<Pokemon> getPokemonsByEntrenadorId(int id);

    @Query(value = "SELECT * FROM pokemon WHERE entrenador_id IS NULL AND mercado_id IS NULL", nativeQuery = true)
    List<Pokemon> comprobarPokemonsSinEntrenadorNiMercado();

    @Query(value = "SELECT * FROM pokemon WHERE entrenador_id is null", nativeQuery = true)
    List<Pokemon> mostrarPokemonsEnVenta();

    @Query(value = "SELECT * FROM pokemon WHERE alineacion_id IS NOT NULL AND entrenador_id = :id", nativeQuery = true)
    List<Pokemon> getPokemonsAlineados(int id);

    @Query(value = "SELECT * FROM pokemon WHERE alineacion_id IS NOT NULL", nativeQuery = true)
    List<Pokemon> getAllPokemonsAlineados();

    @Modifying
    @Query(value = "UPDATE pokemon SET alineacion_id = :alineacion_id WHERE id = :id", nativeQuery = true)
    int updateAlignment(@Param("alineacion_id") int alineacion_id, @Param("id") int id);
}
