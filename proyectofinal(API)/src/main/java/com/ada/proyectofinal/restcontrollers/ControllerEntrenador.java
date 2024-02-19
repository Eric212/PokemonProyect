package com.ada.proyectofinal.restcontrollers;

import ch.qos.logback.core.model.Model;
import com.ada.proyectofinal.entities.Alineacion;
import com.ada.proyectofinal.entities.Entrenador;
import com.ada.proyectofinal.entities.Pokemon;
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

    @GetMapping("/{name}")
    public Entrenador getPerfil(@PathVariable String name) {
        return servicioEntrenador.findByName(name);
    }

    @GetMapping("/usuario/{id}")
    public Boolean usuarioTieneEntrenador(@PathVariable("id")int id){
        return servicioEntrenador.findByUsuario(id);
    }
    @PostMapping("/add")
    public Boolean addEntrenador(@RequestBody Entrenador entrenador){
        return servicioEntrenador.save(entrenador);
    }

    @GetMapping("/find/{id}")
    public Entrenador recuperarEntrenadorPorUsuario(@PathVariable("id") int id){
        return servicioEntrenador.recuperarEntrenadorPorUsuario(id);
    }

    @PostMapping("/alinear")
    public Boolean updateAlineacion(@RequestBody List<Pokemon> pokemons){
        for(Pokemon pokemon : pokemons){
            System.out.println(pokemon.toString());
        }
        return  true;
    }
}