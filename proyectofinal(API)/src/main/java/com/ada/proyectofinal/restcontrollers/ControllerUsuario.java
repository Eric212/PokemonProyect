package com.ada.proyectofinal.restcontrollers;

import com.ada.proyectofinal.dto.TokenDTO;
import com.ada.proyectofinal.dto.UsuarioDTO;
import com.ada.proyectofinal.entities.Token;
import com.ada.proyectofinal.entities.Usuario;
import com.ada.proyectofinal.services.DTOConverterAndReverse;
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

    @Autowired
    private DTOConverterAndReverse dtoConverterAndReverse;

    @PostMapping("/{id}")
    public UsuarioDTO findUser(@PathVariable("id") int id) {
        Usuario usuario = servicioUsuario.findById(id);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setToken(usuario.getToken());
        return usuarioDTO;
    }

    @PostMapping("/login")
    public TokenDTO checkLogIn(@RequestBody Usuario usuario) {
        if (servicioUsuario.checkUser(usuario.getUsername(), usuario.getPassword()) != null) {
            return new TokenDTO(servicioUsuario.checkUser(usuario.getUsername(), usuario.getPassword()));
        } else {
            return new TokenDTO("");
        }
    }

    @PostMapping("/signin")
    public TokenDTO addUser(@RequestBody Usuario usuario) {
        if (servicioUsuario.findUserByName(usuario.getUsername()) == null) {
            usuario.setToken(TokenGenerator.generateToken(usuario.getUsername()));
            servicioUsuario.save(usuario);
            return new TokenDTO(usuario.getToken());
        } else {
            return new TokenDTO("");
        }
    }

    @PostMapping("/buscarpornombre/{name}")
    public UsuarioDTO findUserByName(@PathVariable("name") String name) {
        return dtoConverterAndReverse.fromUsuario(servicioUsuario.findUserByName(name));
    }

    @GetMapping("/buscarportoken/{token}")
    public Integer findUserByToken(@PathVariable("token") String token){
        return servicioUsuario.findByToken(token);
    }
}
