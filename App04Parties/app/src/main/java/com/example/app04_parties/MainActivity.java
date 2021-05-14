package com.example.app03_evolve;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    int pokemonactivity;
    TextView txtnamepkmn1;
    TextView txtnumpkmn1;

    TextView txtnamepkmn2;
    TextView txtnumpkmn2;
    TextView txtnamepkmn3;
    TextView txtnumpkmn3;

    ImageView imgpkmn1;
    ImageView imgpkmn2;
    ImageView imgpkmn3;

    Pokemon pokemon1;
    Pokemon pokemon2;
    Pokemon pokemon3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnamepkmn1 = findViewById(R.id.txtnamepkmn1);
        txtnumpkmn1 = findViewById(R.id.txtnumpkmn1);
        txtnamepkmn2 = findViewById(R.id.txtnamepkmn2);
        txtnumpkmn2 = findViewById(R.id.txtnumpkmn2);
        txtnamepkmn3 = findViewById(R.id.txtnamepkmn3);
        txtnumpkmn3 = findViewById(R.id.txtnumpkmn3);

        imgpkmn1 = findViewById(R.id.imgpkmn1);
        imgpkmn2 = findViewById(R.id.imgpkmn2);
        imgpkmn3 = findViewById(R.id.imgpkmn3);

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        Realm.init(this); // context, usually an Activity or Application
        RealmConfiguration config = new RealmConfiguration.Builder().name("pokemon.realm").build();
        Realm.setDefaultConfiguration(config);
        pokemon1 = DBManager.getPokemonByNumber(1);
        pokemon2 = DBManager.getPokemonByNumber(2);
        pokemon3 = DBManager.getPokemonByNumber(3);

        if (pokemon1 == null) {
            pokemon1 = new Pokemon("Bulbasaur", 1, 1);
            DBManager.saveObject(pokemon1);
        }
        if (pokemon2 == null) {
            pokemon2 = new Pokemon("Charmander", 2, 1);
            DBManager.saveObject(pokemon2);
        }
        if (pokemon3 == null) {
            pokemon3 = new Pokemon("Squirtle", 3, 1);
            DBManager.saveObject(pokemon3);
        }

        update();

        RadioButton radiobulbasaur = findViewById(R.id.radiobulbasaur);
        RadioButton radiocharmander = findViewById(R.id.radiocharmander);
        RadioButton radiosquirtle = findViewById(R.id.radiosquirtle);

        Button btnevolution = findViewById(R.id.btnevolution);

        btnevolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent evolutionactivity = new Intent(MainActivity.this, Evolutions.class);
                if (radiobulbasaur.isChecked()) {
                    pokemonactivity = 101;
                    evolutionactivity.putExtra("Pokemon Number", pokemon1.getPokemonnumber());
                }
                else if (radiocharmander.isChecked()) {
                    pokemonactivity = 102;
                    evolutionactivity.putExtra("Pokemon Number", pokemon2.getPokemonnumber());
                }
                else if (radiosquirtle.isChecked()) {
                    pokemonactivity = 103;
                    evolutionactivity.putExtra("Pokemon Number", pokemon3.getPokemonnumber());
                }
                MainActivity.this.startActivityForResult(evolutionactivity, pokemonactivity);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == pokemonactivity && resultCode == RESULT_OK) {
            update();
        }

    }
    public void update() {
        pokemon1 = DBManager.getPokemonByNumber(1);
        txtnamepkmn1.setText(pokemon1.getPokemonname());
        txtnumpkmn1.setText(pokemon1.getPokemonnumber() + "-" + pokemon1.getPokemonlevel());
        if (pokemon1.getPokemonlevel() == 1) {
            imgpkmn1.setImageResource(R.mipmap.bulbasaur);
        }
        else if (pokemon1.getPokemonlevel() == 2) {
            imgpkmn1.setImageResource(R.mipmap.ivysaur);
        }
        else if (pokemon1.getPokemonlevel() == 3) {
            imgpkmn1.setImageResource(R.mipmap.venusaur);
        }

        pokemon2 = DBManager.getPokemonByNumber(2);
        txtnamepkmn2.setText(pokemon2.getPokemonname());
        txtnumpkmn2.setText(pokemon2.getPokemonnumber() + "-" + pokemon2.getPokemonlevel());
        if (pokemon2.getPokemonlevel() == 1) {
            imgpkmn2.setImageResource(R.mipmap.charmander);
        }
        else if (pokemon2.getPokemonlevel() == 2) {
            imgpkmn2.setImageResource(R.mipmap.charmeleon);
        }
        else if (pokemon2.getPokemonlevel() == 3) {
            imgpkmn2.setImageResource(R.mipmap.charizard);
        }

        pokemon3 = DBManager.getPokemonByNumber(3);
        txtnamepkmn3.setText(pokemon3.getPokemonname());
        txtnumpkmn3.setText(pokemon3.getPokemonnumber() + "-" + pokemon3.getPokemonlevel());
        if (pokemon3.getPokemonlevel() == 1) {
            imgpkmn3.setImageResource(R.mipmap.squirtle);
        }
        else if (pokemon3.getPokemonlevel() == 2) {
            imgpkmn3.setImageResource(R.mipmap.wartortle);
        }
        else if (pokemon3.getPokemonlevel() == 3) {
            imgpkmn3.setImageResource(R.mipmap.blastoise);
        }
    }

    public void reset() {
        pokemon1 = DBManager.getPokemonByNumber(1);
        pokemon1.setPokemonname("Bulbasaur");
        pokemon1.setPokemonlevel(1);
        DBManager.saveObject(pokemon1);

        pokemon2 = DBManager.getPokemonByNumber(2);
        pokemon2.setPokemonname("Charmander");
        pokemon2.setPokemonlevel(1);
        DBManager.saveObject(pokemon2);

        pokemon3 = DBManager.getPokemonByNumber(3);
        pokemon3.setPokemonname("Squirtle");
        pokemon3.setPokemonlevel(1);
        DBManager.saveObject(pokemon3);

        update();
    }
}