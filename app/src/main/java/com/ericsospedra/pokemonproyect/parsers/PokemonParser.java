package com.ericsospedra.pokemonproyect.parsers;

import android.content.Context;
import android.util.Log;


import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.models.Next;
import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.ericsospedra.pokemonproyect.models.Prev;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PokemonParser {
    private final InputStream file;
    private List<Pokemon> pokemons;

    public PokemonParser(Context context) {
        this.file = context.getResources().openRawResource(R.raw.pokedex);
    }

    public boolean parser() {
        boolean parsed = false;
        String json = null;
        int size = 0;
        pokemons = new ArrayList<>();
        try {
            size = file.available();
            byte[] buffer = new byte[size];
            file.read(buffer);
            file.close();
            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                int id = object.getInt("id");
                JSONObject nameObject = object.getJSONObject("name");
                String name = nameObject.getString("english");
                JSONArray typeArray = object.getJSONArray("type");
                String type = typeArray.getString(0);
                Log.d("Info ",String.valueOf(i));
                JSONObject baseObject = object.getJSONObject("base");
                int hp = baseObject.getInt("HP");
                int attack = baseObject.getInt("Attack");
                int defense = baseObject.getInt("Defense");
                int speed = baseObject.getInt("Speed");
                JSONObject evolutionObject = object.getJSONObject("evolution");
                Prev prev = new Prev();
                if (evolutionObject.has("prev")) {
                    JSONArray prevArray = evolutionObject.getJSONArray("prev");
                    List<String> temporaly = new ArrayList<>();
                    for(int j = 0; j<prevArray.length();j++){
                        temporaly.add(prevArray.getString(j));
                    }
                    prev.setPreEvolution(temporaly);
                }
                Next next = new Next();
                if (evolutionObject.has("next")) {
                    JSONArray nextArray = evolutionObject.getJSONArray("next");
                    List<List<String>> temporaly = new ArrayList<>();
                    for(int k = 0; k<nextArray.length();k++){
                        JSONArray nextArrayInside = nextArray.getJSONArray(k);
                        List<String> temporaly2 = new ArrayList<>();
                        for (int l = 0; l < nextArrayInside.length(); l++){
                            temporaly2.add(nextArrayInside.getString(l));
                        }
                        temporaly.add(temporaly2);
                    }
                    next.setEvolution(temporaly);
                }
                String gender = object.getJSONObject("profile").getString("gender");
                String hiresUrl = object.getJSONObject("image").getString("hires");
                pokemons.add(new Pokemon(id,name,type,hp,attack,defense,speed,prev,next,gender,hiresUrl));
                parsed = true;
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
        return parsed;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

}
