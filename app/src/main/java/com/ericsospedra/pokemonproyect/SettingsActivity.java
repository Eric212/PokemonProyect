package com.ericsospedra.pokemonproyect;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ericsospedra.pokemonproyect.fragments.SettingsFragment;

/**
 * SettingsActivity
 *
 * @author Germán Gascón
 * @version 0.3, 2021-01-27
 * @since 0.1, 2019-01-27
 **/
public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
