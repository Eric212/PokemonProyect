package com.ada.proyectofinal.restcontrollers;

import com.ada.proyectofinal.entities.Alineacion;
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

    @GetMapping("/alineaciones")
    public List<Alineacion> getAlineaciones(){
        return servicioAlineacion.findAll();
    }

    @GetMapping("/{id}")
    public Alineacion getAlineacion(@PathVariable("id") int id){
        return servicioAlineacion.findById(id);
    }

}
