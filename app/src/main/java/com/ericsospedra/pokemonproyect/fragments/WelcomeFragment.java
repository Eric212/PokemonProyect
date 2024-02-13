package com.ericsospedra.pokemonproyect.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ericsospedra.pokemonproyect.MainActivity;
import com.ericsospedra.pokemonproyect.R;

public class WelcomeFragment extends Fragment {
    private VideoView vvWelcome;
    private TextView tvWelcome;
    public WelcomeFragment() {
        super(R.layout.welcome_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vvWelcome = view.findViewById(R.id.vvStartMenu);
        tvWelcome = view.findViewById(R.id.tvWelcome);
        String username = MainActivity.token.split(":")[0];
        tvWelcome.setText("Bienvenido "+username);
        vvWelcome.setVideoPath("https://youtu.be/Tmt8JlwLzOU?si=ZYshJ6K5-DLUk0kp");
    }
}
