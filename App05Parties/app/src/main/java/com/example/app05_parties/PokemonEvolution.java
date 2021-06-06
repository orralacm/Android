package com.example.app05_parties;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PokemonEvolution extends AppCompatActivity {

    ImageView pokemonevolution;
    TextView pokemonname;
    Button btnevolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_evolution);
        setTitle("Pokemon Evolution");

        pokemonevolution = findViewById(R.id.pokemonevolution);
        pokemonname = findViewById(R.id.pokemonevolutionname);

        int pokemonnumber = getIntent().getIntExtra("pokemonNumber", 0);
        int partynumber = getIntent().getIntExtra("partyNumber", 0);

        PartyPokemon partypokemon = DBManager.getPokemonByPartyAndNumber(partynumber, pokemonnumber);
        PokemonDetail pokemondetail = DBManager.getPokemonDetail(partypokemon.getPokemonnumber(), partypokemon.getPokemonlevel());
        setPokemonInfo(pokemondetail);


        btnevolution = findViewById(R.id.btnevolution);
        btnevolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (partypokemon.getPokemonlevel() < 3) {
                    partypokemon.setPokemonlevel(partypokemon.getPokemonlevel()+1);
                    PokemonDetail pokemondetail = DBManager.getPokemonDetail(partypokemon.getPokemonnumber(), partypokemon.getPokemonlevel());
                    setPokemonInfo(pokemondetail);
                    DBManager.saveObject(partypokemon);
                }
            }
        });

    }

    private void setPokemonInfo(PokemonDetail pokemon) {
        pokemonevolution.setImageResource(pokemon.getPokemonimage());
        pokemonname.setText(pokemon.getPokemonname());
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        setResult(RESULT_OK);
        finish();
    }
}