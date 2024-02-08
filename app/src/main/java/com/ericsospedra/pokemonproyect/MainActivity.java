package com.ericsospedra.pokemonproyect;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.ericsospedra.pokemonproyect.fragments.EntrenadorFragment;
import com.ericsospedra.pokemonproyect.fragments.PokemonDetailFragment;
import com.ericsospedra.pokemonproyect.fragments.PokemonsFragment;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.Pokemon;
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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, PokemonsFragment.IOnAttach, IOnClickListener, PokemonDetailFragment.IOnAttach {
    private DrawerLayout drawer;
    private FragmentManager manager;
    private List<Pokemon> pokemons;
    private Stack<Integer> id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = new Stack<>();
        cargarDatos();
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

    private void cargarDatos() {
        PokemonParser parser = new PokemonParser(MainActivity.this);
        if(parser.parser()){
            pokemons = parser.getPokemons();
        }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment f;
        int id = item.getItemId();

        if (id == R.id.nav_pokemons) {
            f = new PokemonsFragment();
            manager
                    .beginTransaction().setReorderingAllowed(true)
                    .addToBackStack(null)
                    .replace(R.id.nav_fcvMain, f)
                    .commit();
            setTitle(R.string.pokemons);
        } else if (id == R.id.nav_entrenador) {
            f = new EntrenadorFragment();
            manager
                    .beginTransaction().setReorderingAllowed(true)
                    .addToBackStack(null)
                    .replace(R.id.nav_fcvMain, f)
                    .commit();
            setTitle(R.string.entrenador);
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public List<Pokemon> getPokemons() {
        if(pokemons == null){
            cargarDatos();
            return pokemons;
        }else{
            return pokemons;
        }
    }

    @Override
    public void onClick(int position) {
        id.push(position);
        if(manager.findFragmentById(R.id.nav_fcvMain) instanceof PokemonsFragment){
            manager.beginTransaction().setReorderingAllowed(true).addToBackStack(null).replace(R.id.nav_fcvMain,PokemonDetailFragment.class,null).commit();
        }
    }

    @Override
    public Pokemon getPokemon() {
        return pokemons.get(id.pop());
    }
}