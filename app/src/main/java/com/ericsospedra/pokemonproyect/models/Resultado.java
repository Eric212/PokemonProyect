package com.ericsospedra.pokemonproyect.models;

import com.ericsospedra.pokemonproyect.dto.PokemonDTO;
import com.ericsospedra.pokemonproyect.dto.ResultadoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Resultado {

    private int id;

    public Resultado() {
    }

    public Resultado(int id) {
        this.id = id;
    }

    public static List<Resultado> listaResultados(List<ResultadoDTO> resultadosDTO) {
        return resultadosDTO.stream()
                .map(resultadoDTO -> {
                    Resultado resultado = new Resultado();
                    resultado.setId(resultadoDTO.getId());
                    return resultado;
                })
                .collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "id=" + id +
                '}';
    }
}
