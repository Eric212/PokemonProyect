package com.ada.proyectofinal.restcontrollers;

import com.ada.proyectofinal.entities.Token;
import com.ada.proyectofinal.entities.Usuario;
import com.ada.proyectofinal.services.ServicioUsuario;
import com.ada.proyectofinal.services.TokenGenerator;
import com.ada.proyectofinal.utils.HashGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/user")
public class ControllerUsuario {
    @Autowired
    ServicioUsuario servicioUsuario;

    @Autowired
    TokenGenerator tokenGenerator;

    @PostMapping("/{id}")
    public Usuario findUser(@PathVariable("id") int id) {
        Usuario usuario = servicioUsuario.findById(id);
        Usuario userForSend = new Usuario();
        userForSend.setId(usuario.getId());
        userForSend.setUsername(usuario.getUsername());
        userForSend.setToken(usuario.getToken());
        return userForSend;
    }

    @PostMapping("/login")
    public Token checkLogIn(@RequestBody Usuario usuario) {
        if (servicioUsuario.checkUser(usuario.getUsername(), usuario.getPassword()) != null) {
            return new Token(servicioUsuario.checkUser(usuario.getUsername(), usuario.getPassword()));
        } else {
            return new Token("");
        }
    }

    @PostMapping("/signin")
    public Token addUser(@RequestBody Usuario usuario) {
        if (servicioUsuario.findUserByName(usuario.getUsername()) == null) {
            usuario.setToken(TokenGenerator.generateToken(usuario.getUsername()));
            servicioUsuario.save(usuario);
            return new Token(usuario.getToken());
        } else {
            return new Token("");
        }
    }

    @PostMapping("/buscarpornombre/{name}")
    public Usuario findUserByName(@PathVariable("name") String name) {
        return servicioUsuario.findUserByName(name);
    }

    @GetMapping("/buscarportoken/{token}")
    public Integer findUserByToken(@PathVariable("token") String token){
        return servicioUsuario.findByToken(token);
    }
}
