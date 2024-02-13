package com.ericsospedra.pokemonproyect;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.ericsospedra.pokemonproyect.fragments.CombateFragment;
import com.ericsospedra.pokemonproyect.fragments.EntrenadorFragment;
import com.ericsospedra.pokemonproyect.fragments.MercadoFragment;
import com.ericsospedra.pokemonproyect.fragments.PokemonDetailFragment;
import com.ericsospedra.pokemonproyect.fragments.PokemonsFragment;
import com.ericsospedra.pokemonproyect.fragments.StartMenu;
import com.ericsospedra.pokemonproyect.fragments.WelcomeFragment;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.ericsospedra.pokemonproyect.models.RestClient;
import com.ericsospedra.pokemonproyect.parsers.PokemonParser;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;


import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        IOnClickListener,
        PokemonDetailFragment.IOnAttach {
    public interface Token{
        String getToken();
    }
    private DrawerLayout drawer;
    private IApiService api;
    public static String token;
    private FragmentManager manager;
    private Stack<Integer> id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = new Stack<>();
        api = RestClient.getInstance();
        manager = getSupportFragmentManager();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    finish();
                }
            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.dPokemon);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        FragmentManager manager = getSupportFragmentManager();

        if (id == R.id.nav_pokemons) {
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.nav_fcvMain, new PokemonsFragment(), "pokemons_fragment")
                    .addToBackStack("pokemons_fragment")
                    .commit();
            setTitle(R.string.pokemons);
        } else if (id == R.id.nav_entrenador) {
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.nav_fcvMain, new EntrenadorFragment(), "entrenador_fragment")
                    .addToBackStack("entrenador_fragment")
                    .commit();
            setTitle(R.string.entrenador);
        } else if (id == R.id.nav_combate) {
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.nav_fcvMain, new CombateFragment(), "combate_fragment")
                    .addToBackStack("combate_fragment")
                    .commit();
            setTitle(R.string.combates);
        } else if (id == R.id.nav_mercado) {
            manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.nav_fcvMain, new CombateFragment(), "combate_fragment")
                    .addToBackStack("mercado_fragment")
                    .commit();
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(int position) {
        id.push(position);
        if (manager.findFragmentById(R.id.nav_fcvMain) instanceof PokemonsFragment) {
            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.nav_fcvMain, PokemonDetailFragment.class, null).commit();
        }else if(manager.findFragmentById(R.id.nav_fcvMain) instanceof StartMenu){
            StartMenu f = (StartMenu) manager.findFragmentById(R.id.nav_fcvMain);
            token = f.getToken();
            if(position == R.id.bLogIn){
                manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.nav_fcvMain, WelcomeFragment.class,null).commit();
            }
        }
    }

    @Override
    public int getPokemonId() {
        return id.pop();
    }
}