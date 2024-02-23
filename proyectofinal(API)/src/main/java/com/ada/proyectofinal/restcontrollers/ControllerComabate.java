package com.ada.proyectofinal.restcontrollers;

import com.ada.proyectofinal.dto.CombateDTO;
import com.ada.proyectofinal.dto.PokemonDTO;
import com.ada.proyectofinal.entities.Pokemon;
import com.ada.proyectofinal.services.DTOConverterAndReverse;
import com.ada.proyectofinal.services.ServicioCombate;
import com.ada.proyectofinal.services.ServicioPokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/combate")
public class ControllerComabate {
    @Autowired
    private ServicioCombate servicioCombate;
    @Autowired
    private ServicioPokemon servicioPokemon;
    @Autowired
    private DTOConverterAndReverse dtoConverterAndReverse;

   @PostMapping("/guardar")
    public Boolean guardarCombate(@RequestBody CombateDTO combateDTO){
       return servicioCombate.guardarCombate(combateDTO);
   }
}
