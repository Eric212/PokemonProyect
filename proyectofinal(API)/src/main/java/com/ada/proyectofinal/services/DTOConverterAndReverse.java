package com.ada.proyectofinal.services;

import com.ada.proyectofinal.dto.*;
import com.ada.proyectofinal.entities.*;
import com.ada.proyectofinal.repositories.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DTOConverterAndReverse {

    @Autowired
    RepositoryEntrenador repositoryEntrenador;
    @Autowired
    RepositoryPokemon repositoryPokemon;
    @Autowired
    RepositoryAlineacion repositoryAlineacion;
    @Autowired
    RepositoryMercado repositoryMercado;
    @Autowired
    RepositoryZona repositoryZona;
    @Autowired
    RepositoryCombate repositoryCombate;
    @Autowired
    RepositoryUsuario repositoryUsuario;

    //Pokemon
    public PokemonDTO fromPokemon(Pokemon pokemon) {
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(pokemon.getId());
        pokemonDTO.setName(pokemon.getName());
        pokemonDTO.setType(pokemon.getType());
        pokemonDTO.setLevel(pokemon.getLevel());
        pokemonDTO.setHp(pokemon.getHp());
        pokemonDTO.setAttack(pokemon.getAttack());
        pokemonDTO.setDefence(pokemon.getDefence());
        pokemonDTO.setSpeed(pokemon.getSpeed());
        pokemonDTO.setGender(pokemon.getGender());
        pokemonDTO.setValor(pokemon.getValor());
        pokemonDTO.setHiresURL(pokemon.getHiresURL());
        if (pokemon.getEntrenador() != null) {
            pokemonDTO.setEntrenador(pokemon.getEntrenador().getId());
        }
        if (pokemon.getMercado() != null) {
            pokemonDTO.setMercado(pokemon.getMercado().getId());
        }
        if (pokemon.getAlineacion() != null) {
            pokemonDTO.setAlineacion(pokemon.getAlineacion().getId());
        }
        return pokemonDTO;
    }

    public static List<PokemonDTO> listaPokemonDTO(List<Pokemon> pokemons) {
        return pokemons.stream()
                .map(pokemon -> {
                    PokemonDTO pokemonDTO = new PokemonDTO();
                    pokemonDTO.setId(pokemon.getId());
                    pokemonDTO.setName(pokemon.getName());
                    pokemonDTO.setType(pokemon.getType());
                    pokemonDTO.setLevel(pokemon.getLevel());
                    pokemonDTO.setHp(pokemon.getHp());
                    pokemonDTO.setAttack(pokemon.getAttack());
                    pokemonDTO.setDefence(pokemon.getDefence());
                    pokemonDTO.setSpeed(pokemon.getSpeed());
                    pokemonDTO.setGender(pokemon.getGender());
                    pokemonDTO.setValor(pokemon.getValor());
                    pokemonDTO.setHiresURL(pokemon.getHiresURL());
                    if(pokemon.getEntrenador()!=null) {
                        pokemonDTO.setEntrenador(pokemon.getEntrenador().getId());
                    }
                    if(pokemon.getMercado()!=null) {
                        pokemonDTO.setMercado(pokemon.getMercado().getId());
                    }
                    if(pokemon.getAlineacion()!=null) {
                        pokemonDTO.setAlineacion(pokemon.getAlineacion().getId());
                    }
                    return pokemonDTO;
                })
                .collect(Collectors.toList());
    }

    public Pokemon fromPokemonDTO(PokemonDTO pokemonDTO){
        Pokemon pokemon = new Pokemon();
        pokemon.setId(pokemonDTO.getId());
        pokemon.setName(pokemonDTO.getName());
        pokemon.setType(pokemonDTO.getType());
        pokemon.setLevel(pokemonDTO.getLevel());
        pokemon.setHp(pokemonDTO.getHp());
        pokemon.setAttack(pokemonDTO.getAttack());
        pokemon.setDefence(pokemonDTO.getDefence());
        pokemon.setSpeed(pokemonDTO.getSpeed());
        pokemon.setGender(pokemonDTO.getGender());
        pokemon.setValor(pokemonDTO.getValor());
        pokemon.setHiresURL(pokemonDTO.getHiresURL());
        if (pokemon.getEntrenador() != null) {
            pokemon.setEntrenador(repositoryEntrenador.findById(pokemonDTO.getEntrenador()));
        }
        if (pokemon.getMercado() != null) {
            pokemon.setMercado(repositoryMercado.findById(pokemonDTO.getMercado()));
        }
        if (pokemon.getAlineacion() != null) {
            pokemon.setAlineacion(repositoryAlineacion.findById(pokemonDTO.getAlineacion()));
        }
        return pokemon;
    }

    public List<Pokemon> listaPokemon(List<PokemonDTO> pokemonsDTO) {
        return pokemonsDTO.stream()
                .map(pokemonDTO -> {
                    Pokemon pokemon = new Pokemon();
                    pokemon.setId(pokemonDTO.getId());
                    pokemon.setName(pokemonDTO.getName());
                    pokemon.setType(pokemonDTO.getType());
                    pokemon.setLevel(pokemonDTO.getLevel());
                    pokemon.setHp(pokemonDTO.getHp());
                    pokemon.setAttack(pokemonDTO.getAttack());
                    pokemon.setDefence(pokemonDTO.getDefence());
                    pokemon.setSpeed(pokemonDTO.getSpeed());
                    pokemon.setGender(pokemonDTO.getGender());
                    pokemon.setValor(pokemonDTO.getValor());
                    pokemon.setHiresURL(pokemonDTO.getHiresURL());
                    if (pokemon.getEntrenador() != null) {
                        pokemon.setEntrenador(repositoryEntrenador.findById(pokemonDTO.getId()));
                    }
                    if (pokemon.getAlineacion() != null) {
                        pokemon.setAlineacion(repositoryAlineacion.findById(pokemonDTO.getAlineacion()));
                    }
                    if (pokemon.getMercado() != null) {
                        pokemon.setMercado(repositoryMercado.findById(pokemonDTO.getMercado()));
                    }
                    return pokemon;
                })
                .collect(Collectors.toList());
    }
    //Entrenador
    public EntrenadorDTO fromEntrenador(Entrenador entrenador){
        EntrenadorDTO entrenadorDTO = new EntrenadorDTO();
        entrenadorDTO.setId(entrenador.getId());
        entrenadorDTO.setNombre(entrenador.getNombre());
        entrenadorDTO.setApellido(entrenador.getApellido());
        entrenadorDTO.setIcono(entrenador.getIcono());
        entrenadorDTO.setDinero(entrenador.getDinero());
        entrenadorDTO.setUsuario_id(entrenador.getUsuario().getId());
        entrenadorDTO.setPokemons(listaPokemonDTO(entrenador.getPokemons()));
        entrenadorDTO.setResultados(listaResultadosDTO(entrenador.getResultados()));
        return entrenadorDTO;
    }



    public Entrenador fromEntrenadorDTO(EntrenadorDTO entrenadorDTO){
        Entrenador entrenador = new Entrenador();
        entrenador.setId(entrenadorDTO.getId());
        entrenador.setNombre(entrenadorDTO.getNombre());
        entrenador.setApellido(entrenadorDTO.getApellido());
        entrenador.setIcono(entrenadorDTO.getIcono());
        entrenador.setDinero(entrenadorDTO.getDinero());
        entrenador.setUsuario(repositoryUsuario.findById(entrenadorDTO.getUsuario_id()));
        entrenador.setPokemons(listaPokemon(entrenadorDTO.getPokemons()));
        entrenador.setResultados(listaResultados(entrenadorDTO.getResultados()));
        return entrenador;
    }

    public List<EntrenadorDTO> listaEntrenadorDTO(List<Entrenador> entrenadores){
        return entrenadores.stream().map(entrenador -> {
            EntrenadorDTO entrenadorDTO = new EntrenadorDTO();
            entrenadorDTO.setId(entrenador.getId());
            entrenadorDTO.setNombre(entrenador.getNombre());
            entrenadorDTO.setApellido(entrenador.getApellido());
            entrenadorDTO.setIcono(entrenador.getIcono());
            entrenadorDTO.setDinero(entrenador.getDinero());
            entrenadorDTO.setUsuario_id(entrenador.getUsuario().getId());
            entrenadorDTO.setPokemons(listaPokemonDTO(entrenador.getPokemons()));
            entrenadorDTO.setResultados(listaResultadosDTO(entrenador.getResultados()));
            return entrenadorDTO;
        }).collect(Collectors.toList());
    }

    public List<Entrenador> listaEntrenador(List<EntrenadorDTO> entrenadoresDTO){
        return entrenadoresDTO.stream().map(entrenadorDTO -> {
            Entrenador entrenador = new Entrenador();
            entrenador.setId(entrenadorDTO.getId());
            entrenador.setNombre(entrenadorDTO.getNombre());
            entrenador.setApellido(entrenadorDTO.getApellido());
            entrenador.setIcono(entrenadorDTO.getIcono());
            entrenador.setDinero(entrenadorDTO.getDinero());
            entrenador.setUsuario(repositoryUsuario.findById(entrenadorDTO.getUsuario_id()));
            entrenador.setPokemons(listaPokemon(entrenadorDTO.getPokemons()));
            entrenador.setResultados(listaResultados(entrenadorDTO.getResultados()));
            return entrenador;
        }).collect(Collectors.toList());
    }

    //Resultado
    public ResultadoDTO fromResultado(Resultado resultado){
        ResultadoDTO resultadoDTO = new ResultadoDTO();
        resultadoDTO.setId(resultado.getId());
        resultadoDTO.setEntrenador(resultado.getEntrenador().getId());
        return resultadoDTO;
    }

    public Resultado fromResultadoDTO(ResultadoDTO resultadoDTO){
        Resultado resultado = new Resultado();
        resultado.setId(resultadoDTO.getId());
        resultado.setEntrenador(repositoryEntrenador.findById(resultadoDTO.getEntrenador()));
        return resultado;
    }

    public List<ResultadoDTO> listaResultadosDTO(List<Resultado> resultados) {
        return resultados.stream()
                .map(resultado -> {
                    ResultadoDTO resultadoDTO = new ResultadoDTO();
                    resultadoDTO.setId(resultado.getId());
                    resultadoDTO.setEntrenador(resultado.getEntrenador().getId());
                    return resultadoDTO;
                })
                .collect(Collectors.toList());
    }

    public List<Resultado> listaResultados(List<ResultadoDTO> resultados) {
        return resultados.stream()
                .map(resultadoDTO -> {
                    Resultado resultado = new Resultado();
                    resultado.setId(resultadoDTO.getId());
                    resultado.setEntrenador(repositoryEntrenador.findById(resultadoDTO.getEntrenador()));
                    return resultado;
                })
                .collect(Collectors.toList());
    }

    //Alineacion
    public AlineacionDTO fromAlineacion(Alineacion alineacion){
        AlineacionDTO alineacionDTO = new AlineacionDTO();
        alineacionDTO.setId(alineacion.getId());
        alineacionDTO.setZona(alineacion.getZona());
        return alineacionDTO;
    }

    public Alineacion fromAlineacionDTO(AlineacionDTO alineacionDTO){
        Alineacion alineacion = new Alineacion();
        alineacion.setId(alineacionDTO.getId());
        alineacion.setZona(alineacionDTO.getZona());
        return alineacion;

    }

    public List<AlineacionDTO> listaAlineacionDTO(List<Alineacion> alineaciones){
        return alineaciones.stream().map(alineacion -> {
            AlineacionDTO alineacionDTO = new AlineacionDTO();
            alineacionDTO.setId(alineacion.getId());
            alineacionDTO.setZona(alineacion.getZona());
            return alineacionDTO;
        }).collect(Collectors.toList());
    }
    public List<Alineacion> listaAlineacion(List<AlineacionDTO> alineacionesDTO){
        return alineacionesDTO.stream().map(alineacionDTO -> {
            Alineacion alineacion = new Alineacion();
            alineacion.setId(alineacionDTO.getId());
            alineacion.setZona(alineacionDTO.getZona());
            return alineacion;
        }).collect(Collectors.toList());
    }

    //Usuario
    public UsuarioDTO fromUsuario(Usuario usuario){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setUsername(usuario.getUsername());
        usuarioDTO.setPassword(usuario.getPassword());
        usuarioDTO.setToken(usuario.getToken());
        return usuarioDTO;
    }

    public Usuario fromUsuarioDTO(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuario.getId());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(usuarioDTO.getPassword());
        usuario.setToken(usuarioDTO.getToken());
        return usuario;
    }

    public List<UsuarioDTO> listaUsuariosDTO(List<Usuario> usuarios){
        return usuarios.stream().map(usuario -> {
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setUsername(usuario.getUsername());
            usuarioDTO.setPassword(usuario.getPassword());
            usuarioDTO.setToken(usuario.getToken());
            return usuarioDTO;
        }).collect(Collectors.toList());
    }

    public List<Usuario> listaUsuarios(List<UsuarioDTO> usuariosDTO){
        return usuariosDTO.stream().map(usuarioDTO -> {
            Usuario usuario = new Usuario();
            usuario.setId(usuario.getId());
            usuario.setUsername(usuarioDTO.getUsername());
            usuario.setPassword(usuarioDTO.getPassword());
            usuario.setToken(usuarioDTO.getToken());
            return usuario;
        }).collect(Collectors.toList());
    }

    //Mercado
    public MercadoDTO fromMercado(Mercado mercado){
        MercadoDTO mercadoDTO = new MercadoDTO();
        mercadoDTO.setId(mercado.getId());
        mercadoDTO.setFecha(mercadoDTO.getFecha());
        mercadoDTO.setPokemons(listaPokemonDTO(mercado.getPokemons()));
        return mercadoDTO;
    }

    public Mercado fromMercadoDTO(MercadoDTO mercadoDTO){
        Mercado mercado = new Mercado();
        mercado.setId(mercadoDTO.getId());
        mercado.setFecha(mercadoDTO.getFecha());
        mercado.setPokemons(listaPokemon(mercadoDTO.getPokemons()));
        return mercado;
    }

    public List<MercadoDTO> listaMercadoDTO(List<Mercado> mercados){
        return mercados.stream().map(mercado -> {
            MercadoDTO mercadoDTO = new MercadoDTO();
            mercadoDTO.setId(mercado.getId());
            mercadoDTO.setFecha(mercadoDTO.getFecha());
            mercadoDTO.setPokemons(listaPokemonDTO(mercado.getPokemons()));
            return mercadoDTO;
        }).collect(Collectors.toList());
    }

    public List<Mercado> listaMercado(List<MercadoDTO> mercadosDTO){
        return mercadosDTO.stream().map(mercadoDTO -> {
            Mercado mercado = new Mercado();
            mercado.setId(mercadoDTO.getId());
            mercado.setFecha(mercadoDTO.getFecha());
            mercado.setPokemons(listaPokemon(mercadoDTO.getPokemons()));
            return mercado;
        }).collect(Collectors.toList());
    }

    //Token
    public TokenDTO fromToken(Token token){
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(token.getToken());
        return tokenDTO;
    }

    public Token fromTokenDTO(TokenDTO tokenDTO){
        Token token = new Token();
        token.setToken(tokenDTO.getToken());
        return token;
    }

    public List<TokenDTO> listaTokenDTO(List<Token> tokens){
        return tokens.stream().map(token -> {
            TokenDTO tokenDTO = new TokenDTO();
            tokenDTO.setToken(token.getToken());
            return tokenDTO;
        }).collect(Collectors.toList());
    }

    public List<Token> listaToken(List<TokenDTO> tokensDTO){
        return tokensDTO.stream().map(tokenDTO -> {
            Token token = new Token();
            token.setToken(tokenDTO.getToken());
            return token;
        }).collect(Collectors.toList());
    }

}
