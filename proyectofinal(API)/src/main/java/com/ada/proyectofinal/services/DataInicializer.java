package com.ada.proyectofinal.services;

import com.ada.proyectofinal.Parser.Parser;
import com.ada.proyectofinal.entities.*;
import com.ada.proyectofinal.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class DataInicializer {

    @Autowired
    private RepositoryPokemon repositoryPokemon;

    @Autowired
    private RepositoryEntrenador repositoryEntrenador;

    @Autowired
    private RepositoryMercado repositoryMercado;

    @Autowired
    private RepositoryAlineacion repositoryAlineacion;

    @Autowired
    private RepositoryUsuario repositoryUsuario;

    @Autowired
    private Parser parser;

    public void GenerarEntrenadores(Entrenador entrenadorRecibido) {
        List<Entrenador> entrenadores = repositoryEntrenador.findAll();
        if (entrenadores.isEmpty()) {
            Entrenador entrenador = new Entrenador();
            entrenador.setNombre(entrenadorRecibido.getNombre());
            entrenador.setApellido(entrenadorRecibido.getApellido());
            entrenador.setGenero(entrenadorRecibido.isGenero());
            entrenador.setDinero(entrenadorRecibido.getDinero());
            entrenador.setUsuario(repositoryUsuario.findAll().get(0));
            if (entrenadorRecibido.getIcono() == null) {
                entrenador.setIcono(null);
            }
            entrenador.setIcono(entrenadorRecibido.getIcono());
            repositoryEntrenador.save(entrenador);
            for (Pokemon pokemon : entrenadorRecibido.getPokemons()) {
                pokemon.setEntrenador(entrenador);
                repositoryPokemon.save(pokemon);
            }
            if (!entrenadorRecibido.getResultados().isEmpty()) {
                for (Resultado resultado : entrenadorRecibido.getResultados()) {
                    resultado.setEntrenador(entrenador);
                }
            }

            Entrenador entrenador1 = new Entrenador();
            entrenador1.setNombre("Ash");
            entrenador1.setApellido("Ketchum");
            entrenador1.setDinero(150000);
            entrenador1.setGenero(false);
            entrenador1.setIcono(null);
            repositoryEntrenador.save(entrenador1);

            Entrenador entrenador2 = new Entrenador();
            entrenador2.setNombre("Misty");
            entrenador2.setApellido("Waterflower");
            entrenador1.setGenero(true);
            entrenador2.setDinero(150000);
            entrenador2.setIcono(null);
            repositoryEntrenador.save(entrenador2);

            Entrenador entrenador3 = new Entrenador();
            entrenador3.setNombre("Brock");
            entrenador3.setApellido("Takeshi");
            entrenador1.setGenero(false);
            entrenador3.setDinero(150000);
            entrenador3.setIcono(null);
            repositoryEntrenador.save(entrenador3);

            Entrenador entrenador4 = new Entrenador();
            entrenador4.setNombre("Gary");
            entrenador4.setApellido("Oak");
            entrenador1.setGenero(false);
            entrenador4.setDinero(150000);
            entrenador4.setIcono(null);
            repositoryEntrenador.save(entrenador4);
        }
    }

    public void generarPokemons() {
        List<Pokemon> pokemons = repositoryPokemon.findAll();
        if (pokemons.isEmpty()) {
            pokemons = new ArrayList<>();
            if (parser.parse()) {
                pokemons = parser.getPokemons();
            }
        }
        repositoryPokemon.saveAll(pokemons);
    }

    public void asignarPokemons() {
        List<Pokemon> pokemons = repositoryPokemon.comprobarPokemonsSinEntrenadorNiMercado();
        if (!pokemons.isEmpty()) {
            if (!repositoryPokemon.comprobarPokemonsSinEntrenadorNiMercado().isEmpty()) {
                List<Entrenador> entrenadores = repositoryEntrenador.findAll();
                Collections.shuffle(pokemons);
                int limit = 0;
                for (Entrenador entrenador : entrenadores) {
                    List<Pokemon> pokemonsParaEntrenador = pokemons.subList(limit,limit+20);
                    limit=limit+20;
                    asignar20Pokemons(pokemonsParaEntrenador, entrenador.getId());
                }
            }
        }
    }

    private void asignar20Pokemons(List<Pokemon> pokemons, int id_entrenador) {
        Entrenador entrenador = repositoryEntrenador.findById(id_entrenador);
        List<Pokemon> modifiedPokemons = new ArrayList<>();

        for (Pokemon pokemon : pokemons) {
            pokemon.setEntrenador(entrenador);
            modifiedPokemons.add(pokemon);
        }

        entrenador.setPokemons(modifiedPokemons);
        repositoryEntrenador.save(entrenador);
    }

    public void prepararMercado() {
        List<Mercado> mercados = repositoryMercado.findAll();
        if (mercados.isEmpty()) {
            Mercado mercado = new Mercado();
            mercado.setFecha(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            List<Pokemon> pokemons = repositoryPokemon.comprobarPokemonsSinEntrenadorNiMercado();
            for (Pokemon pokemon : pokemons) {
                pokemon.setMercado(mercado);
            }
            mercado.setPokemons(pokemons);
            repositoryMercado.save(mercado);
        }
    }

    public void generarAlineacion() {
        List<Alineacion> alineaciones = repositoryAlineacion.findAll();
        if (alineaciones.isEmpty()) {
            for (int i = 1; i < 5; i++) {
                Alineacion alineacion = new Alineacion();
                alineacion.setZona("Zona" + i);
                repositoryAlineacion.save(alineacion);
            }
        }
    }

    public void asignarAlineaciones() {
        List<Entrenador> entrenadores = repositoryEntrenador.recuperarBots();
        List<Pokemon> pokemonsAlineados = new ArrayList<>();
        List<Alineacion> alineaciones;
        List<Pokemon> pokemons;
        List<Integer> pokemons_id = new ArrayList<>();
        int idEntrenador = 0;
        for (Entrenador entrenador : entrenadores) {
            idEntrenador = entrenador.getId();
            pokemons = entrenador.getPokemons();
            Collections.shuffle(pokemons);
            alineaciones = repositoryAlineacion.findAll();
            List<Pokemon> zona1 = new ArrayList<>();
            List<Pokemon> zona2 = new ArrayList<>();
            List<Pokemon> zona3 = new ArrayList<>();
            List<Pokemon> zona4 = new ArrayList<>();
            for (Alineacion alineacion : alineaciones) {
                for (Pokemon pokemon : pokemons) {
                    if (!pokemons_id.contains(pokemon.getId())) {
                        switch (alineacion.getId()) {
                            case 1:
                                if (zona1.size() < 2) {
                                    zona1.add(pokemon);
                                    pokemons_id.add(pokemon.getId());
                                    pokemon.setAlineacion(alineacion);
                                }
                                break;
                            case 2:
                                if (zona2.size() < 3) {
                                    zona2.add(pokemon);
                                    pokemons_id.add(pokemon.getId());
                                    pokemon.setAlineacion(alineacion);
                                }
                                break;
                            case 3:
                                if (zona3.size() < 4) {
                                    zona3.add(pokemon);
                                    pokemons_id.add(pokemon.getId());
                                    pokemon.setAlineacion(alineacion);
                                }
                                break;
                            case 4:
                                if (zona4.size() < 2) {
                                    zona4.add(pokemon);
                                    pokemons_id.add(pokemon.getId());
                                    pokemon.setAlineacion(alineacion);
                                }
                                break;
                        }
                    }
                }
                pokemonsAlineados.addAll(zona1);
                pokemonsAlineados.addAll(zona2);
                pokemonsAlineados.addAll(zona3);
                pokemonsAlineados.addAll(zona4);
                repositoryPokemon.saveAll(pokemonsAlineados);
                repositoryEntrenador.save(repositoryEntrenador.findById(idEntrenador));
            }
        }
    }
    public boolean comprobarDatos(){
        return repositoryEntrenador.findAll().size() == 5
                && repositoryPokemon.findAll().size() == 151
                && repositoryPokemon.mostrarPokemonsEnVenta().size() == 51
                && repositoryAlineacion.findAll().size() == 4
                && repositoryPokemon.getAllPokemonsAlineados().size() == 44;
    }
}
