package com.ada.proyectofinal.restcontrollers;

import com.ada.proyectofinal.dto.AlineacionDTO;
import com.ada.proyectofinal.entities.Alineacion;
import com.ada.proyectofinal.services.DTOConverterAndReverse;
import com.ada.proyectofinal.services.ServicioAlineacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/alineacion")
public class ControllerAlineacion {
    @Autowired
    private ServicioAlineacion servicioAlineacion;

    @Autowired
    private DTOConverterAndReverse dtoConverterAndReverse;

    @GetMapping("/alineaciones")
    public List<AlineacionDTO> getAlineaciones(){
        return dtoConverterAndReverse.listaAlineacionDTO(servicioAlineacion.findAll());
    }

    @GetMapping("/{id}")
    public AlineacionDTO getAlineacion(@PathVariable("id") int id){
        return dtoConverterAndReverse.fromAlineacion(servicioAlineacion.findById(id));
    }

}
