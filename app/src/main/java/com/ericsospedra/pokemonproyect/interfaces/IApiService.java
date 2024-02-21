package com.ericsospedra.pokemonproyect.interfaces;

import com.ericsospedra.pokemonproyect.dto.AlineacionDTO;
import com.ericsospedra.pokemonproyect.dto.EntrenadorDTO;
import com.ericsospedra.pokemonproyect.dto.PokemonDTO;
import com.ericsospedra.pokemonproyect.dto.TokenDTO;
import com.ericsospedra.pokemonproyect.dto.UsuarioDTO;
import com.ericsospedra.pokemonproyect.models.Alineacion;
import com.ericsospedra.pokemonproyect.models.Entrenador;
import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.ericsospedra.pokemonproyect.models.Token;
import com.ericsospedra.pokemonproyect.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IApiService {

    @GET("pokemons")
    Call<List<PokemonDTO>> getPokemons();

    @GET("pokemons/entrenador/{id}")
    Call<List<PokemonDTO>> getTrainerPokemons(@Path("id") int id);

    @GET("pokemons/{id}")
    Call<PokemonDTO> getPokemon(@Path("id") int id);

    @POST("user/login")
    Call<TokenDTO> checkLogin(@Body UsuarioDTO usuarioDTO);

    @POST("user/signin")
    Call<TokenDTO> userAdd(@Body UsuarioDTO usuarioDTO);

    @POST("user/buscarpornombre/{name}")
    Call<UsuarioDTO> findUserByName(@Path("name") String name);

    @GET("alineacion/{id}")
    Call<AlineacionDTO> getAlineacion(@Path("id") int id);

    @GET("alineacion/alineaciones")
    Call<List<AlineacionDTO>> getAlineaciones();

    @GET("entrenador/{id}")
    Call<EntrenadorDTO> getEntrenador(@Path("id")int id);

    @GET("pokemons/alineados/{id}")
    Call<List<PokemonDTO>> getPokemonsAlineados(@Path("id") int i);
    @GET("entrenador/usuario/{id}")
    Call<Boolean> entrenadorTieneUsuario(@Path("id")int id);

    @POST("generar")
    Call<Boolean> entrenadorAdd(@Body EntrenadorDTO entrenadorDTO);

    @GET("/buscarportoken/{token}")
    Call<Integer> findUserByToken(@Path("token") String token);

    @GET("/entrenador/find/{id}")
    Call<EntrenadorDTO> recuperarEntrenadorPorUsuario(@Path("id") int id);

    @POST("pokemons/alinear")
    Call<Boolean> updateAlineacion(@Body List<PokemonDTO> pokemonsAlineadosDTO);
}
