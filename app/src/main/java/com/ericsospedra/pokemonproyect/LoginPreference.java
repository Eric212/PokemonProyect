package com.ericsospedra.pokemonproyect;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ericsospedra.pokemonproyect.models.RestClient;


public class LoginPreference extends AppCompatActivity implements View.OnFocusChangeListener {
    private EditText etUsername;
    private EditText etPassword;
    private TextView tvToken;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText etIP;
    private EditText etPuerto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preference_layout);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etIP = findViewById(R.id.etIP);
        etPuerto = findViewById(R.id.etPuerto);
        tvToken = findViewById(R.id.tvToken);
        Bundle bundle = getIntent().getExtras();
        etUsername.setText(bundle.getString("username"));
        etPassword.setText(bundle.getString("password"));
        tvToken.setText(bundle.getString("token"));
        etIP.setText(bundle.getString("ip"));
        etPuerto.setText(bundle.getString("puerto"));
        preferences = getSharedPreferences("login", 0);
        etUsername.setOnFocusChangeListener(this);
        etPassword.setOnFocusChangeListener(this);
        etIP.setOnFocusChangeListener(this);
        etPuerto.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == R.id.etUsername && !hasFocus) {
            editor = preferences.edit();
            editor.putString("username", etUsername.getText().toString());
            editor.apply();
        } else if (v.getId() == R.id.etPassword && !hasFocus){
            editor = preferences.edit();
            editor.putString("password", etPassword.getText().toString());
            editor.apply();
        }else if(v.getId() == R.id.etIP && !hasFocus){
            editor = preferences.edit();
            editor.putString("ip", etIP.getText().toString());
            editor.apply();
            RestClient.setIp(etIP.getText().toString());
        }else{
            editor = preferences.edit();
            editor.putString("puerto", etPuerto.getText().toString());
            editor.apply();
        }
    }
}