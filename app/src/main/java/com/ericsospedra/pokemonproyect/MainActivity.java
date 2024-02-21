package com.ericsospedra.pokemonproyect;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.ericsospedra.pokemonproyect.dto.UsuarioDTO;
import com.ericsospedra.pokemonproyect.fragments.AlignmentFragment;
import com.ericsospedra.pokemonproyect.fragments.BattleFragment;
import com.ericsospedra.pokemonproyect.fragments.MarketFragment;
import com.ericsospedra.pokemonproyect.fragments.PlayerCreatorFragment;
import com.ericsospedra.pokemonproyect.fragments.PokedexFragment;
import com.ericsospedra.pokemonproyect.fragments.PokemonDetailFragment;
import com.ericsospedra.pokemonproyect.fragments.StartMenu;
import com.ericsospedra.pokemonproyect.fragments.TrainerFragment;
import com.ericsospedra.pokemonproyect.fragments.WelcomeFragment;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.RestClient;
import com.ericsospedra.pokemonproyect.models.Usuario;

import java.util.Stack;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements
        IOnClickListener,
        PokemonDetailFragment.IOnAttach {

    private IApiService api;
    public static String token;
    private FragmentManager manager;
    private Stack<Integer> id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        SharedPreferences preferences = getSharedPreferences("login", 0);
        if (!preferences.getString("ip", "").equals("") && !preferences.getString("ip", "").equals("")){
            RestClient.setIp(preferences.getString("ip", ""));
            RestClient.setPuerto(preferences.getString("puerto", ""));
         }
        id = new Stack<>();
        api = RestClient.getInstance();
        manager = getSupportFragmentManager();
    }


    @Override
    public void onClick(int position) {
        if (manager.findFragmentById(R.id.fcvMain) instanceof StartMenu) {
            String username = getSharedPreferences("login", 0).getString("username", "");
            token = getSharedPreferences("login", 0).getString("token", "");
            api.entrenadorTieneUsuario(1).enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if (response.isSuccessful()) {
                        if (response.body()) {
                            api.findUserByName(username).enqueue(new Callback<UsuarioDTO>() {
                                @Override
                                public void onResponse(Call<UsuarioDTO> call, Response<UsuarioDTO> response) {
                                    if (response.isSuccessful()) {
                                        token = response.body().getToken();
                                        if (getSharedPreferences("login", 0).getString("token", "").equals(token)) {
                                            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, WelcomeFragment.class, null).commit();
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<UsuarioDTO> call, Throwable t) {
                                    Log.e(MainActivity.class.getSimpleName(), t.getMessage());
                                }
                            });
                            Log.d("Info ", "Fallo la consulta api");
                        } else {
                            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, PlayerCreatorFragment.class, null).commit();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {

                }
            });
        } else if (manager.findFragmentById(R.id.fcvMain) instanceof PlayerCreatorFragment) {
            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, WelcomeFragment.class, null).commit();
        } else if (manager.findFragmentById(R.id.fcvMain) instanceof WelcomeFragment) {
            logicaMenu(position);
        } else if (manager.findFragmentById(R.id.fcvMain) instanceof PokedexFragment) {
            if(!logicaMenu(position)) {
                id.push(position);
                manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, PokemonDetailFragment.class, null).commit();
            }
        } else if(manager.findFragmentById(R.id.fcvMain) instanceof TrainerFragment){
            if(!logicaMenu(position)){
                manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, AlignmentFragment.class, null).commit();
            }
        }else if(manager.findFragmentById(R.id.fcvMain) instanceof AlignmentFragment){
            logicaMenu(position);
        }else if(manager.findFragmentById(R.id.fcvMain) instanceof PokemonDetailFragment) {
            logicaMenu(position);
        }
    }

    @Override
    public int getPokemonId() {
        return id.pop();
    }
    public boolean logicaMenu(int position){
        if (position == R.id.ivTrainer) {
            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, TrainerFragment.class, null).commit();
            return true;
        } else if (position == R.id.ivHome) {
            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, WelcomeFragment.class, null).commit();
            return true;
        } else if (position == R.id.ivPokedex) {
            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, PokedexFragment.class, null).commit();
            return true;
        } else if (position == R.id.ivBattle) {
            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, BattleFragment.class, null).commit();
            return true;
        } else if(position == R.id.ivMarket){
            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.fcvMain, MarketFragment.class, null).commit();
            return true;
        }else {
            return false;
        }
    }
}