package com.ada.proyectofinal.restcontrollers;

import com.ada.proyectofinal.Parser.Parser;
import com.ada.proyectofinal.dto.PokemonDTO;
import com.ada.proyectofinal.entities.Pokemon;
import com.ada.proyectofinal.services.DTOConverterAndReverse;
import com.ada.proyectofinal.services.ServicioMercado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerMercado {
    @Autowired
    private ServicioMercado servicioMercado;

    @Autowired
    private DTOConverterAndReverse dtoConverterAndReverse;

    @GetMapping("mostrarMercado")
    public List<PokemonDTO> mostrarMercado(){
        return dtoConverterAndReverse.listaPokemonDTO(servicioMercado.ListarPokemonsDelMercado());
    }

}
