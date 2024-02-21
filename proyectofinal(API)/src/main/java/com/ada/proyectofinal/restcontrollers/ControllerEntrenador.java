package com.ada.proyectofinal.restcontrollers;

import ch.qos.logback.core.model.Model;
import com.ada.proyectofinal.dto.EntrenadorDTO;
import com.ada.proyectofinal.dto.PokemonDTO;
import com.ada.proyectofinal.entities.Alineacion;
import com.ada.proyectofinal.entities.Entrenador;
import com.ada.proyectofinal.entities.Pokemon;
import com.ada.proyectofinal.services.DTOConverterAndReverse;
import com.ada.proyectofinal.services.ServicioEntrenador;
import com.ada.proyectofinal.services.ServicioMercado;
import com.ada.proyectofinal.services.ServicioPokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/entrenador")
public class ControllerEntrenador {
    @Autowired
    private ServicioEntrenador servicioEntrenador;

    @Autowired
    private DTOConverterAndReverse dtoConverterAndReverse;

    @GetMapping("/{name}")
    public EntrenadorDTO getPerfil(@PathVariable String name) {
        return dtoConverterAndReverse.fromEntrenador(servicioEntrenador.findByName(name));
    }

    @GetMapping("/usuario/{id}")
    public Boolean usuarioTieneEntrenador(@PathVariable("id")int id){
        return servicioEntrenador.findByUsuario(id);
    }
    @PostMapping("/add")
    public Boolean addEntrenador(@RequestBody EntrenadorDTO entrenador){
        return servicioEntrenador.save(dtoConverterAndReverse.fromEntrenadorDTO(entrenador));
    }

    @GetMapping("/find/{id}")
    public EntrenadorDTO recuperarEntrenadorPorUsuario(@PathVariable("id") int id){
        return dtoConverterAndReverse.fromEntrenador(servicioEntrenador.recuperarEntrenadorPorUsuario(id));
    }
}