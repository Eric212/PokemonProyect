package com.ada.proyectofinal.restcontrollers;

import com.ada.proyectofinal.dto.PokemonDTO;
import com.ada.proyectofinal.entities.Pokemon;
import com.ada.proyectofinal.services.DTOConverterAndReverse;
import com.ada.proyectofinal.services.ServicioPokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/pokemons")
public class ControllerPokemon {
    @Autowired
    private ServicioPokemon servicioPokemon;

    @Autowired
    private DTOConverterAndReverse dtoConverterAndReverse;

    @GetMapping
    public List<PokemonDTO> showAllPokemons(){
        return dtoConverterAndReverse.listaPokemonDTO(servicioPokemon.findAll());
    }

    @GetMapping("/entrenador/{id}")
    public List<PokemonDTO> showTrainerPokemons(@PathVariable("id") int id){
        return dtoConverterAndReverse.listaPokemonDTO(servicioPokemon.getPokemonsByEntrenadorId(id));
    }
    @GetMapping("/{id}")
    public PokemonDTO showPokemon(@PathVariable("id") int id){
        return dtoConverterAndReverse.fromPokemon(servicioPokemon.findById(id));
    }


    @GetMapping("/alineados/{id}")
    public List<PokemonDTO> getPokemons(@PathVariable("id")int id){
        return dtoConverterAndReverse.listaPokemonDTO(servicioPokemon.getPokemonsAlineados(id));
    }

    @PostMapping("/alinear")
    public Boolean crearAlineacion(@RequestBody List<PokemonDTO> pokemons){
        System.out.println(pokemons.toString());
        servicioPokemon.saveAll(dtoConverterAndReverse.listaPokemon(pokemons));
        return true;
    }
}
