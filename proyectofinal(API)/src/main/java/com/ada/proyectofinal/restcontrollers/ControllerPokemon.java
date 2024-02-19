package com.ada.proyectofinal.restcontrollers;

import com.ada.proyectofinal.entities.Pokemon;
import com.ada.proyectofinal.services.ServicioPokemon;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemons")
public class ControllerPokemon {
    @Autowired
    private ServicioPokemon servicioPokemon;

    @GetMapping
    public List<Pokemon> showAllPokemons(){
        return servicioPokemon.findAll();
    }

    @GetMapping("/entrenador/{id}")
    public List<Pokemon> showTrainerPokemons(@PathVariable("id") int id){
        return servicioPokemon.getPokemonsByEntrenadorId(id);
    }
    @GetMapping("/{id}")
    public Optional<Pokemon> showPokemon(@PathVariable("id") int id){
        return servicioPokemon.findById(id);
    }


    @GetMapping("/alineados/{id}")
    public List<Pokemon> getPokemons(@PathVariable("id")int id){
        return servicioPokemon.getPokemonsAlineados(id);
    }

    @PostMapping("/alinear")
    public Boolean crearAlineacion(@RequestBody Pokemon pokemons){
        System.out.println(pokemons.toString());
        servicioPokemon.save(pokemons);
        return true;
    }
}
