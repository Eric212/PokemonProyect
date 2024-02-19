package com.ada.proyectofinal.services;

import com.ada.proyectofinal.entities.Token;
import com.ada.proyectofinal.entities.Usuario;
import com.ada.proyectofinal.repositories.RepositoryUsuario;
import com.ada.proyectofinal.utils.HashGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuario {
    @Autowired
    RepositoryUsuario repositoryUsuario;

    public String checkUser(String username, String password) {
        Usuario usuario = null;
        usuario = repositoryUsuario.checkUser(username, password);
        if(usuario!=null) {
            return usuario.getToken();
        }else {
            return null;
        }
    }

    public List<Usuario> findAll() {
        return repositoryUsuario.findAll();
    }

    public Usuario findById(int id) {
        return repositoryUsuario.findById(id);
    }

    public void saveAll(List<Usuario> usuarios) {
        repositoryUsuario.saveAll(usuarios);
    }

    public boolean save(Usuario usuario) {
        repositoryUsuario.save(usuario);
        return true;
    }

    public void deleteById(int id) {
        repositoryUsuario.deleteById(id);
    }

    public void deleteAll() {
        repositoryUsuario.deleteAll();
    }

    public Usuario findUserByName(String username){
        Usuario usuario = repositoryUsuario.findByName(username);
        if(usuario!=null) {
            usuario.setPassword(null);
            return usuario;
        }else{
            return null;
        }
    }
    public boolean update(Usuario usuario){
        if(repositoryUsuario.findByName(usuario.getUsername())!=null) {
            repositoryUsuario.save(usuario);
            return true;
        }else{
            return false;
        }
    }
    public int findByToken(String token){
        return repositoryUsuario.findByToken(token);
    }
}
