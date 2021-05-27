package com.example.app04_parties;

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
    int pokemonbulbasaur = 101;
    int pokemoncharmander = 102;
    int pokemonsquirtle = 103;
    int pokemonchikorita = 201;
    int pokemoncyndaquil = 202;
    int pokemontotodile = 203;

    TextView txtnamepkmn1;
    TextView txtnumpkmn1;
    TextView txtnamepkmn2;
    TextView txtnumpkmn2;
    TextView txtnamepkmn3;
    TextView txtnumpkmn3;

    ImageView imgpkmn1;
    ImageView imgpkmn2;
    ImageView imgpkmn3;

    Pokemon pokemon1a;
    Pokemon pokemon2a;
    Pokemon pokemon3a;
    Pokemon pokemon1b;
    Pokemon pokemon2b;
    Pokemon pokemon3b;

    RadioButton radio1;
    RadioButton radio2;
    RadioButton radio3;

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

        radio1 = findViewById(R.id.radio1);
        radio2 = findViewById(R.id.radio2);
        radio3 = findViewById(R.id.radio3);

        RadioButton btnbulbasaur = findViewById(R.id.radiobtnbulbasaur);
        RadioButton btncharmander = findViewById(R.id.radiobtncharmander);
        RadioButton btnsquirtle = findViewById(R.id.radiobtnsquirtle);
        RadioButton btnchikorita = findViewById(R.id.radiobtnchikorita);
        RadioButton btncyndaquil = findViewById(R.id.radiobtncyndaquil);
        RadioButton btntotodile = findViewById(R.id.radiobtntotodile);

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

        Button update = findViewById(R.id.btnupdate);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Party party1 = new Party();
                party1.setPartynumber(1);
                if (btnbulbasaur.isChecked()) {
                    party1.setPokemon1(pokemonbulbasaur);
                }
                else {
                    party1.setPokemon1(pokemonchikorita);
                }

                if (btncharmander.isChecked()) {
                    party1.setPokemon2(102);
                }
                else {
                    party1.setPokemon2(202);
                }

                if (btnsquirtle.isChecked()) {
                    party1.setPokemon3(103);
                }
                else {
                    party1.setPokemon3(203);
                }
                DBManager.saveObject(party1);
                update();
            }
        });

        Realm.init(this); // context, usually an Activity or Application
        RealmConfiguration config = new RealmConfiguration.Builder().name("pokemon.realm").build();
        Realm.setDefaultConfiguration(config);
        pokemon1a = DBManager.getPokemonByNumber(101);
        pokemon2a = DBManager.getPokemonByNumber(102);
        pokemon3a = DBManager.getPokemonByNumber(103);
        pokemon1b = DBManager.getPokemonByNumber(201);
        pokemon2b = DBManager.getPokemonByNumber(202);
        pokemon3b = DBManager.getPokemonByNumber(203);

        if (pokemon1a == null) {
            pokemon1a = new Pokemon("Bulbasaur", 101, 1);
            DBManager.saveObject(pokemon1a);
        }
        if (pokemon2a == null) {
            pokemon2a = new Pokemon("Charmander", 102, 1);
            DBManager.saveObject(pokemon2a);
        }
        if (pokemon3a == null) {
            pokemon3a = new Pokemon("Squirtle", 103, 1);
            DBManager.saveObject(pokemon3a);
        }
        if (pokemon1b == null) {
            pokemon1b = new Pokemon("Chikorita", 201, 1);
            DBManager.saveObject(pokemon1b);
        }
        if (pokemon2b == null) {
            pokemon2b = new Pokemon("Cyndaquil", 202, 1);
            DBManager.saveObject(pokemon2b);
        }
        if (pokemon3b == null) {
            pokemon3b = new Pokemon("Totodile", 203, 1);
            DBManager.saveObject(pokemon3b);
        }

        update();

        Button btnevolution = findViewById(R.id.btnevolution);

        btnevolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent evolutionactivity = new Intent(MainActivity.this, Evolutions.class);
                Party party = DBManager.getPartyByNumber(1);
                if (radio1.isChecked()) {
                    pokemonactivity = 101;
                    evolutionactivity.putExtra("Pokemon Number", party.getPokemon1());
                }
                else if (radio2.isChecked()) {
                    pokemonactivity = 102;
                    evolutionactivity.putExtra("Pokemon Number", party.getPokemon2());
                }
                else if (radio3.isChecked()) {
                    pokemonactivity = 103;
                    evolutionactivity.putExtra("Pokemon Number", party.getPokemon3());
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
        Party party = DBManager.getPartyByNumber(1);
        if (party != null) {
            if (party.getPokemon1() == pokemonbulbasaur) {
                pokemon1a = DBManager.getPokemonByNumber(101);
                txtnamepkmn1.setText(pokemon1a.getPokemonname());
                txtnumpkmn1.setText(pokemon1a.getPokemonnumber() + "-" + pokemon1a.getPokemonlevel());
                radio1.setText(pokemon1a.getPokemonname());
                if (pokemon1a.getPokemonlevel() == 1) {
                    imgpkmn1.setImageResource(R.mipmap.bulbasaur);
                }
                else if (pokemon1a.getPokemonlevel() == 2) {
                    imgpkmn1.setImageResource(R.mipmap.ivysaur);
                }
                else if (pokemon1a.getPokemonlevel() == 3) {
                    imgpkmn1.setImageResource(R.mipmap.venusaur);
                }
            }
            else if (party.getPokemon1() == pokemonchikorita) {
                pokemon1b = DBManager.getPokemonByNumber(201);
                txtnamepkmn1.setText(pokemon1b.getPokemonname());
                txtnumpkmn1.setText(pokemon1b.getPokemonnumber() + "-" + pokemon1b.getPokemonlevel());
                radio1.setText(pokemon1b.getPokemonname());
                if (pokemon1b.getPokemonlevel() == 1) {
                    imgpkmn1.setImageResource(R.mipmap.chikorita);
                }
                else if (pokemon1b.getPokemonlevel() == 2) {
                    imgpkmn1.setImageResource(R.mipmap.bayleef);
                }
                else if (pokemon1b.getPokemonlevel() == 3) {
                    imgpkmn1.setImageResource(R.mipmap.meganium);
                }
            }

            if (party.getPokemon2() == pokemoncharmander) {
                pokemon2a = DBManager.getPokemonByNumber(102);
                txtnamepkmn2.setText(pokemon2a.getPokemonname());
                txtnumpkmn2.setText(pokemon2a.getPokemonnumber() + "-" + pokemon2a.getPokemonlevel());
                radio2.setText(pokemon2a.getPokemonname());
                if (pokemon2a.getPokemonlevel() == 1) {
                    imgpkmn2.setImageResource(R.mipmap.charmander);
                }
                else if (pokemon2a.getPokemonlevel() == 2) {
                    imgpkmn2.setImageResource(R.mipmap.charmeleon);
                }
                else if (pokemon2a.getPokemonlevel() == 3) {
                    imgpkmn2.setImageResource(R.mipmap.charizard);
                }
            }
            else if (party.getPokemon2() == pokemoncyndaquil) {
                pokemon2b = DBManager.getPokemonByNumber(202);
                txtnamepkmn2.setText(pokemon2b.getPokemonname());
                txtnumpkmn2.setText(pokemon2b.getPokemonnumber() + "-" + pokemon2b.getPokemonlevel());
                radio2.setText(pokemon2b.getPokemonname());
                if (pokemon2b.getPokemonlevel() == 1) {
                    imgpkmn2.setImageResource(R.mipmap.cyndaquil);
                }
                else if (pokemon2b.getPokemonlevel() == 2) {
                    imgpkmn2.setImageResource(R.mipmap.quilava);
                }
                else if (pokemon2b.getPokemonlevel() == 3) {
                    imgpkmn2.setImageResource(R.mipmap.typhlosion);
                }
            }

           if (party.getPokemon3() == pokemonsquirtle) {
               pokemon3a = DBManager.getPokemonByNumber(103);
               txtnamepkmn3.setText(pokemon3a.getPokemonname());
               txtnumpkmn3.setText(pokemon3a.getPokemonnumber() + "-" + pokemon3a.getPokemonlevel());
               radio3.setText(pokemon3a.getPokemonname());
               if (pokemon3a.getPokemonlevel() == 1) {
                   imgpkmn3.setImageResource(R.mipmap.squirtle);
               }
               else if (pokemon3a.getPokemonlevel() == 2) {
                   imgpkmn3.setImageResource(R.mipmap.wartortle);
               }
               else if (pokemon3a.getPokemonlevel() == 3) {
                   imgpkmn3.setImageResource(R.mipmap.blastoise);
               }
           }
           else if (party.getPokemon3() == pokemontotodile) {
               pokemon3b = DBManager.getPokemonByNumber(203);
               txtnamepkmn3.setText(pokemon3b.getPokemonname());
               txtnumpkmn3.setText(pokemon3b.getPokemonnumber() + "-" + pokemon3b.getPokemonlevel());
               radio3.setText(pokemon3b.getPokemonname());
               if (pokemon3b.getPokemonlevel() == 1) {
                   imgpkmn3.setImageResource(R.mipmap.totodile);
               }
               else if (pokemon3b.getPokemonlevel() == 2) {
                   imgpkmn3.setImageResource(R.mipmap.croconaw);
               }
               else if (pokemon3b.getPokemonlevel() == 3) {
                   imgpkmn3.setImageResource(R.mipmap.feraligatr);
               }
           }
        }
    }

    public void reset() {
        pokemon1a = DBManager.getPokemonByNumber(101);
        pokemon1a.setPokemonname("Bulbasaur");
        pokemon1a.setPokemonlevel(1);
        DBManager.saveObject(pokemon1a);

        pokemon2a = DBManager.getPokemonByNumber(102);
        pokemon2a.setPokemonname("Charmander");
        pokemon2a.setPokemonlevel(1);
        DBManager.saveObject(pokemon2a);

        pokemon3a = DBManager.getPokemonByNumber(103);
        pokemon3a.setPokemonname("Squirtle");
        pokemon3a.setPokemonlevel(1);
        DBManager.saveObject(pokemon3a);

        pokemon1b = DBManager.getPokemonByNumber(201);
        pokemon1b.setPokemonname("Chikorita");
        pokemon1b.setPokemonlevel(1);
        DBManager.saveObject(pokemon1b);

        pokemon2b = DBManager.getPokemonByNumber(202);
        pokemon2b.setPokemonname("Cyndaquil");
        pokemon2b.setPokemonlevel(1);
        DBManager.saveObject(pokemon2b);

        pokemon3b = DBManager.getPokemonByNumber(203);
        pokemon3b.setPokemonname("Totodile");
        pokemon3b.setPokemonlevel(1);
        DBManager.saveObject(pokemon3b);

        update();
    }
}