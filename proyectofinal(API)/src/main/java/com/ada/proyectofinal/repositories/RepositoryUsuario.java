package com.ada.proyectofinal.repositories;

import com.ada.proyectofinal.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario,Integer> {

    @Query(value = "SELECT * FROM usuario WHERE username = :username AND password = :password", nativeQuery = true)
    Usuario checkUser(String username, String password);

    @Query(value = "SELECT * FROM usuario WHERE password = :password",nativeQuery = true)
    Usuario checkIfUserExist(String password);

    @Query(value = "SELECT * FROM usuario WHERE id=:id",nativeQuery = true)
    Usuario findById(int id);

    @Query(value = "SELECT id FROM usuario WHERE token=:token",nativeQuery = true)
    int findByToken(String token);

    @Query(value = "SELECT * FROM usuario WHERE username=:username",nativeQuery = true)
    Usuario findByName(String username);

    @Query(value = "UPDATE usuario set token = :token",nativeQuery = true)
    Usuario update(String token);
}
