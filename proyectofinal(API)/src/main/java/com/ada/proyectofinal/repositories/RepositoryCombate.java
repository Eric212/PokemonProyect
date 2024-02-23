package com.ada.proyectofinal.repositories;

import com.ada.proyectofinal.entities.Combate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCombate extends JpaRepository<Combate, Integer> {
}
