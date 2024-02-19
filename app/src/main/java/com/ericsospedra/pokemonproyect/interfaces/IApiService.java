package com.ericsospedra.pokemonproyect.interfaces;

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
    Call<List<Pokemon>> getPokemons();

    @GET("pokemons/entrenador/{id}")
    Call<List<Pokemon>> getTrainerPokemons(@Path("id") int id);

    @GET("pokemons/{id}")
    Call<Pokemon> getPokemon(@Path("id") int id);

    @POST("user/login")
    Call<Token> checkLogin(@Body Usuario usuario);

    @POST("user/signin")
    Call<Token> userAdd(@Body Usuario usuario);

    @POST("user/buscarpornombre/{name}")
    Call<Usuario> findUserByName(@Path("name") String name);

    @GET("alineacion/{id}")
    Call<Alineacion> getAlineacion(@Path("id") int id);

    @GET("alineacion/alineaciones")
    Call<List<Alineacion>> getAlineaciones();

    @GET("entrenador/{id}")
    Call<Entrenador> getEntrenador(@Path("id")int id);

    @GET("pokemons/alineados/{id}")
    Call<List<Pokemon>> getPokemonsAlineados(@Path("id") int i);
    @GET("entrenador/usuario/{id}")
    Call<Boolean> entrenadorTieneUsuario(@Path("id")int id);

    @POST("generar")
    Call<Boolean> entrenadorAdd(@Body Entrenador entrenador);

    @GET("/buscarportoken/{token}")
    Call<Integer> findUserByToken(@Path("token") String token);

    @GET("/entrenador/find/{id}")
    Call<Entrenador> recuperarEntrenadorPorUsuario(@Path("id") int id);

    @POST("entrenador/alinear")
    Call<Boolean> updateAlineacion(@Body List<Pokemon> pokemonsAlineados);
}
