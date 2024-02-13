package com.ericsospedra.pokemonproyect.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ericsospedra.pokemonproyect.MainActivity;
import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.RestClient;
import com.ericsospedra.pokemonproyect.models.Usuario;
import com.ericsospedra.pokemonproyect.utils.HashGenerator;

import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartMenu extends Fragment implements View.OnClickListener, MainActivity.Token {
    private IOnClickListener listener;
    private EditText etUsername;
    private EditText etPassword;
    private TextView tvAlert;
    private Button bLogIn;
    private Button bSignIn;
    private IApiService api;
    private String token;

    public StartMenu() {
        super(R.layout.start_menu_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        api = RestClient.getInstance();
        tvAlert = view.findViewById(R.id.tvAlert);
        etUsername = view.findViewById(R.id.etUsername);
        etPassword = view.findViewById(R.id.etPassword);
        bLogIn = view.findViewById(R.id.bLogIn);
        bSignIn = view.findViewById(R.id.bSigIn);
        bLogIn.setOnClickListener(this);
        bSignIn.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IOnClickListener) context;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bLogIn) {
            Usuario usuario = null;
            try {
                usuario = new Usuario(etUsername.getText().toString(), HashGenerator.getSHAString(etPassword.getText().toString()));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            api.checkLogin(usuario).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    token = response.body();
                    Log.d("Info ",response.body());
                    if (response.code() == 200) {
                        tvAlert.setVisibility(View.GONE);
                    } else {
                        tvAlert.setVisibility(View.VISIBLE);
                        tvAlert.setText("Error al iniciar sesion");
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        } else {
            Usuario usuario = null;
            try {
                usuario = new Usuario(etUsername.getText().toString(), HashGenerator.getSHAString(etPassword.getText().toString()));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            api.userAdd(usuario).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    token = response.body();
                    if (response.code() == 200) {
                        tvAlert.setVisibility(View.GONE);
                    } else {
                        tvAlert.setVisibility(View.VISIBLE);
                        tvAlert.setText("Error al registrarse");
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        }
    }

    @Override
    public String getToken() {
        return token;
    }
}
