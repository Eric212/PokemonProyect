package com.ericsospedra.pokemonproyect.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ericsospedra.pokemonproyect.R;
import com.ericsospedra.pokemonproyect.adapters.TrainerPokemonAdapter;
import com.ericsospedra.pokemonproyect.interfaces.IApiService;
import com.ericsospedra.pokemonproyect.interfaces.IOnClickListener;
import com.ericsospedra.pokemonproyect.interfaces.IOnLongClickListener;
import com.ericsospedra.pokemonproyect.models.Entrenador;
import com.ericsospedra.pokemonproyect.models.Pokemon;
import com.ericsospedra.pokemonproyect.models.RestClient;
import com.ericsospedra.pokemonproyect.models.Usuario;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrainerFragment extends Fragment implements IOnLongClickListener, View.OnClickListener {

    private ImageView ivEntrenador;
    private TextView tvDinero;
    private ImageView ivPokemon;
    private ImageView ivBackgroundDetail;
    private ProgressBar pbLife;
    private TextView tvNombreInfo;
    private TextView tvNombre;
    private TextView tvNivelInfo;
    private TextView tvNivel;
    private TextView tvAtaqueInfo;
    private TextView tvAtaque;
    private TextView tvDefensaInfo;
    private TextView tvDefensa;
    private TextView tvVelocidadInfo;
    private TextView tvVelocidad;
    private TextView tvTrainerName;
    private TextView tvTrainerSurname;
    private RecyclerView rvPokemonEntrenador;
    private IApiService api;
    private SharedPreferences preferences;
    private IOnLongClickListener onLongClickListener;
    private IOnClickListener onClickListener;
    private Button bCrearAlineacion;
    private View menuLayout;
    private ImageView ivTrainer;
    private ImageView ivPokedex;
    private ImageView ivBattle;
    private ImageView ivMarket;
    private ImageView ivHome;


    public TrainerFragment() {
        super(R.layout.trainer_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        api = RestClient.getInstance();
        onLongClickListener = this;
        ivEntrenador = view.findViewById(R.id.ivEntrenador);
        ivPokemon = view.findViewById(R.id.ivPokemonDetalle);
        ivBackgroundDetail = view.findViewById(R.id.ivBackgroundDetail);
        pbLife = view.findViewById(R.id.pbLifeDetail);
        tvNombre = view.findViewById(R.id.tvNombre);
        tvNivel = view.findViewById(R.id.tvNivel);
        tvAtaque = view.findViewById(R.id.tvAtaque);
        tvDefensa = view.findViewById(R.id.tvDefensa);
        tvVelocidad = view.findViewById(R.id.tvVelocidad);
        tvNombreInfo = view.findViewById(R.id.tvNombreInfo);
        tvNivelInfo = view.findViewById(R.id.tvNivelInfo);
        tvAtaqueInfo = view.findViewById(R.id.tvAtaqueInfo);
        tvDefensaInfo = view.findViewById(R.id.tvDefensaInfo);
        tvVelocidadInfo = view.findViewById(R.id.tvVelocidadInfo);
        bCrearAlineacion = view.findViewById(R.id.bCrearAliniacion);
        menuLayout = view.findViewById(R.id.iMenuTrainer);
        ivHome = menuLayout.findViewById(R.id.ivHome);
        ivTrainer = menuLayout.findViewById(R.id.ivTrainer);
        ivPokedex = menuLayout.findViewById(R.id.ivPokedex);
        ivBattle = menuLayout.findViewById(R.id.ivBattle);
        ivMarket = menuLayout.findViewById(R.id.ivMarket);
        ivHome.setOnClickListener(this);
        ivTrainer.setOnClickListener(this);
        ivPokedex.setOnClickListener(this);
        ivBattle.setOnClickListener(this);
        ivMarket.setOnClickListener(this);
        bCrearAlineacion.setOnClickListener(this);
        api.findUserByName(preferences.getString("username", "")).enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Log.d("INFO ", response.body().toString());
                    api.recuperarEntrenadorPorUsuario(response.body().getId()).enqueue(new Callback<Entrenador>() {
                        @Override
                        public void onResponse(Call<Entrenador> call, Response<Entrenador> response) {
                            Entrenador entrenador = response.body();
                            ivEntrenador.setImageResource(getContext().getResources().getIdentifier(entrenador.getIcono(), "drawable", getContext().getPackageName()));
                            tvTrainerName = view.findViewById(R.id.tvTrainerName);
                            tvTrainerSurname = view.findViewById(R.id.tvTrainerSurname);
                            tvDinero = view.findViewById(R.id.tvDinero);
                            rvPokemonEntrenador = view.findViewById(R.id.rvPokemonsEntrendor);
                            tvTrainerName.setText(entrenador.getNombre());
                            tvTrainerSurname.setText(entrenador.getApellido());
                            tvDinero.setText(String.valueOf(new DecimalFormat(entrenador.getDinero() == 0 ? "#" : "#.##").format(entrenador.getDinero())));
                            TrainerPokemonAdapter adapter = new TrainerPokemonAdapter(entrenador.getPokemons(), onLongClickListener);
                            rvPokemonEntrenador.setAdapter(adapter);
                            rvPokemonEntrenador.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false));
                        }

                        @Override
                        public void onFailure(Call<Entrenador> call, Throwable t) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {

            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        preferences = context.getSharedPreferences("login", 0);
        onClickListener = (IOnClickListener) context;
    }

    @Override
    public void onLongClick(Pokemon pokemon) {
        ivPokemon.setVisibility(View.VISIBLE);
        ivBackgroundDetail.setVisibility(View.VISIBLE);
        pbLife.setVisibility(View.VISIBLE);
        tvNombreInfo.setVisibility(View.VISIBLE);
        tvNombre.setVisibility(View.VISIBLE);
        tvNivelInfo.setVisibility(View.VISIBLE);
        tvNivel.setVisibility(View.VISIBLE);
        tvAtaqueInfo.setVisibility(View.VISIBLE);
        tvAtaque.setVisibility(View.VISIBLE);
        tvDefensaInfo.setVisibility(View.VISIBLE);
        tvDefensa.setVisibility(View.VISIBLE);
        tvVelocidadInfo.setVisibility(View.VISIBLE);
        tvVelocidad.setVisibility(View.VISIBLE);
        Picasso.get().load(pokemon.getHiresURL()).into(ivPokemon);
        pbLife.setProgress(pokemon.getHp());
        tvNombre.setText(String.valueOf(pokemon.getName()));
        tvNivel.setText(String.valueOf(pokemon.getLevel()));
        tvAtaque.setText(String.valueOf(pokemon.getAttack()));
        tvDefensa.setText(String.valueOf(pokemon.getDefence()));
        tvVelocidad.setText(String.valueOf(pokemon.getSpeed()));
    }

    @Override
    public void onClick(View v) {
        onClickListener.onClick(v.getId());
    }
}
