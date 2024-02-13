package com.ericsospedra.pokemonproyect.interfaces;

import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.ericsospedra.pokemonproyect.models.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IApiService {

    @GET("pokemons/entrenador/{id}")
    public Call<List<Pokemon>> getPokemons(@Path("id") int id);

    @GET("pokemons/{id}")
    public Call<Pokemon> getPokemon(@Path("id") int id);

    @POST("user/login")
    Call<String> checkLogin(@Body Usuario usuario);

    @POST("user/signin")
    Call<String> userAdd(@Body Usuario usuario);
}
