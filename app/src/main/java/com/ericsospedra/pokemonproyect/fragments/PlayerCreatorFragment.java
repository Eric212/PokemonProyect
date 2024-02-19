package com.ericsospedra.pokemonproyect.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.models.Entrenador;
import com.ericsospedra.pokemonproyect.models.RestClient;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerCreatorFragment extends Fragment {
    private ImageView ivJugador;
    private EditText etNombreJugador;
    private EditText etApellidoJugador;
    private RadioGroup genero;
    private RadioButton rbMasculino;
    private RadioButton rbFemenino;
    private List<Integer> avatares;
    private Button bCrear;
    private Integer imageId;
    private IOnClickListener listener;
    private IApiService api;

    public PlayerCreatorFragment() {
        super(R.layout.player_creator_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivJugador = view.findViewById(R.id.ivJugador);
        etNombreJugador = view.findViewById(R.id.etNombreJugador);
        etApellidoJugador = view.findViewById(R.id.etApellidoJugador);
        genero = view.findViewById(R.id.rgGenero);
        rbMasculino = view.findViewById(R.id.rbMasculino);
        rbFemenino = view.findViewById(R.id.rbFemenino);
        bCrear = view.findViewById(R.id.bCrearJugador);
        recuperarAvatares();
        ivJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Collections.shuffle(avatares);
                imageId=avatares.get(0);
                ivJugador.setImageResource(imageId);
            }
        });
        bCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton buttonChecked = view.findViewById(genero.getCheckedRadioButtonId());
                boolean parametroGenero;
                if(buttonChecked.getText().toString().equals("Masculino")){
                    parametroGenero = false;
                }else{
                    parametroGenero = true;
                }
                if(etNombreJugador.getText()!=null&&etApellidoJugador.getText()!=null&&(rbMasculino.isChecked()||rbFemenino.isChecked())){
                    api = RestClient.getInstance();
                    if(imageId==null) {
                        imageId = R.drawable.avatar243;
                    }
                    Entrenador entrenador = new Entrenador(etNombreJugador.getText().toString(),etApellidoJugador.getText().toString(),parametroGenero,String.valueOf(imageId),150000f);
                    api.entrenadorAdd(entrenador).enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if(response.isSuccessful()){
                                if(response.body()){
                                    listener.onClick(1);
                                }
                            }else{
                                Toast.makeText(view.getContext(), "Error al crear el jugador", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (IOnClickListener) context;
    }

    private void recuperarAvatares() {
        avatares = new ArrayList<>();
        Resources res = getResources();
        Class<?> drawableClass = R.drawable.class;
        Field[] fields = drawableClass.getFields();
        for (Field field : fields) {
            try {
                String name = field.getName();
                if (name.startsWith("avatar")) {
                    int resourceId = field.getInt(null);
                    avatares.add(resourceId);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
