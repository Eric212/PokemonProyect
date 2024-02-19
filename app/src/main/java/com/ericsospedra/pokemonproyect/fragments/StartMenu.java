package com.ericsospedra.pokemonproyect.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ericsospedra.pokemonproyect.LoginPreference;
import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.RestClient;
import com.ericsospedra.pokemonproyect.models.Token;
import com.ericsospedra.pokemonproyect.models.Usuario;
import com.ericsospedra.pokemonproyect.utils.HashGenerator;

import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StartMenu extends Fragment implements View.OnClickListener {

    public interface IOnAttach {
        SharedPreferences getPreferences();
    }

    private SharedPreferences preference;
    private IOnClickListener listener;
    private EditText etUsername;
    private EditText etPassword;
    private TextView tvAlert;
    private Button bLogIn;
    private Button bSignIn;
    private ImageView ivPreference;
    private IApiService api;
    private Token token;
    private CheckBox cbRemember;
    private Context context;

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
        bSignIn = view.findViewById(R.id.bSignIn);
        ivPreference = view.findViewById(R.id.ivPreference);
        cbRemember = view.findViewById(R.id.cbRemember);
        if (preference != null) {
            if (!preference.getString("username", "").isEmpty()) {
                etUsername.setText(preference.getString("username", ""));
                etPassword.setText(preference.getString("password", ""));
                token = new Token(preference.getString("token",""));
                RestClient.setIp(preference.getString("ip",""));
                RestClient.setPuerto(preference.getString("puerto",""));
                cbRemember.setChecked(true);
            }
        }
        ivPreference.setOnClickListener(this);
        bLogIn.setOnClickListener(this);
        bSignIn.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        listener = (IOnClickListener) context;
        preference = context.getSharedPreferences("login",0);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bLogIn) {
            Usuario usuario = null;
            try {
                usuario = new Usuario(etUsername.getText().toString(), HashGenerator.getSHAString(etPassword.getText().toString()), token.getToken());
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            api.checkLogin(usuario).enqueue(new Callback<Token>() {
                @Override
                public void onResponse(Call<Token> call, Response<Token> response) {
                    token = response.body();
                    if (!token.getToken().equals("")) {
                        tvAlert.setVisibility(View.GONE);
                        if(!preference.getString("token","").equals(token.getToken())){
                            Log.d("Info ","Añado el token porque no lo tenia");
                            preference.edit().putString("token",token.getToken()).apply();
                        }
                        Log.d("Info ","Apunto de saltar al main");
                        listener.onClick(v.getId());
                    } else {
                        tvAlert.setVisibility(View.VISIBLE);
                        tvAlert.setText("Error al iniciar sesion");
                    }
                }

                @Override
                public void onFailure(Call<Token> call, Throwable t) {
                    Log.e(StartMenu.class.getSimpleName(), t.getMessage());
                }
            });
        } else if (v.getId() == R.id.bSignIn) {
            Usuario usuario = null;
            try {
                usuario = new Usuario(etUsername.getText().toString(), HashGenerator.getSHAString(etPassword.getText().toString()), null);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
            api.userAdd(usuario).enqueue(new Callback<Token>() {
                @Override
                public void onResponse(Call<Token> call, Response<Token> response) {
                    token = response.body();
                    Log.d("Info ",token.getToken());
                    if (!token.getToken().equals("")) {
                        if (cbRemember.isChecked()) {
                            if (preference.getString("username", "").isEmpty()) {
                                SharedPreferences.Editor editor = preference.edit();
                                editor.putString("username", etUsername.getText().toString());
                                editor.putString("password", etPassword.getText().toString());
                                editor.putString("token", token.getToken());
                                editor.putString("ip",RestClient.getIp());
                                editor.putString("puerto",RestClient.getPuerto());
                                editor.apply();
                            }
                        }
                        tvAlert.setVisibility(View.GONE);
                        Toast.makeText(context, "Usuario " + etUsername.getText().toString() + " registrado con exito", Toast.LENGTH_SHORT).show();
                        listener.onClick(v.getId());
                    } else {
                        tvAlert.setVisibility(View.VISIBLE);
                        tvAlert.setText("Error al registrarse");
                    }
                }

                @Override
                public void onFailure(Call<Token> call, Throwable t) {
                    Log.e(StartMenu.class.getSimpleName(), t.getMessage());
                }
            });
        } else {
            if(preference!=null) {
                Intent intent = new Intent(context, LoginPreference.class);
                intent.putExtra("username", preference.getString("username", ""));
                intent.putExtra("password", preference.getString("password", ""));
                intent.putExtra("token", preference.getString("token", ""));
                intent.putExtra("ip", preference.getString("ip", ""));
                intent.putExtra("puerto", preference.getString("puerto", ""));
                startActivity(intent);
            }else{
                Intent intent = new Intent(context, LoginPreference.class);
                startActivity(intent);
            }
        }
    }
}
