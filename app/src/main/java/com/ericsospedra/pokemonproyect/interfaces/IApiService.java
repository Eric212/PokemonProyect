package com.ericsospedra.pokemonproyect.interfaces;

import com.ericsospedra.pokemonproyect.models.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApiService {

    @GET("pokemons")
    public Call<List<Pokemon>> getPokemons(@Query("id") int id);
}
