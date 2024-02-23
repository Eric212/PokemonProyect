package com.ada.proyectofinal.services;

import com.ada.proyectofinal.dto.CombateDTO;
import com.ada.proyectofinal.repositories.RepositoryCombate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ServicioCombate {
    @Autowired
    private RepositoryCombate repositoryCombate;
    @Autowired
    private DTOConverterAndReverse dtoConverterAndReverse;
    public Boolean guardarCombate(CombateDTO combateDTO) {
        repositoryCombate.save(dtoConverterAndReverse.fromCombateDTO(combateDTO));
        return true;
    }
}
