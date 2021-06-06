package com.example.app05_parties;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CreateParty extends AppCompatActivity {

    EditText inputpartyname;
    FloatingActionButton floatingactionbutton;
    RecyclerView recyclerview;
    PokemonAdapter pokemonadapter;
    int partynumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_party);
        setTitle("Create Party");
        inputpartyname = findViewById(R.id.inputpartyname);

        floatingactionbutton = findViewById(R.id.btnaddpokemon);
        floatingactionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateParty.this, PokemonMenu.class);

                List<PokemonDetail> pokemonsinparty = pokemonadapter.getPokemonlist();
                int[] pokemonsinpartyint = new int[pokemonsinparty.size()];

                for (int i = 0; i < pokemonsinparty.size(); i++) {
                    pokemonsinpartyint[i] = pokemonsinparty.get(i).getPokemonnumber();
                }

                intent.putExtra("PokemonsInParty", pokemonsinpartyint);

                startActivityForResult(intent, 1001);
            }
        });

        recyclerview = findViewById(R.id.recyclepokemon);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        pokemonadapter = new PokemonAdapter(new ArrayList<>(), false, new ArrayList<>(), this);
        recyclerview.setAdapter(pokemonadapter);

        partynumber = 0;

        if (getIntent().hasExtra("PartyNumber")) {
            partynumber = getIntent().getIntExtra("PartyNumber", 0 );
            Party party = DBManager.getPartyByNumber(partynumber);
            inputpartyname.setText(party.getPartyname());
            List<PartyPokemon> partypokemon = DBManager.getPokemonsInParty(partynumber);
            for (PartyPokemon pokemon:partypokemon) {
                PokemonDetail pokemondetail = DBManager.getPokemonDetail(pokemon.getPokemonnumber(), pokemon.getPokemonlevel());
                pokemonadapter.addPokemon(pokemondetail);
            }
        }
        pokemonadapter.setPartynumber(partynumber);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.create_party, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.save) {
            if (partynumber == 0) {
                Party party = new Party();
                party.setPartynumber(DBManager.getAllParties().size() + 1);
                party.setPartyname(inputpartyname.getText().toString());
                DBManager.saveObject(party);
                List<PokemonDetail> pokemonlist = pokemonadapter.getPokemonlist();
                for (PokemonDetail pokemon:pokemonlist) {
                    PartyPokemon partypokemon = new PartyPokemon();
                    partypokemon.setPartynumber(party.getPartynumber());
                    partypokemon.setPokemonnumber(pokemon.getPokemonnumber());
                    partypokemon.setPokemonlevel(1);
                    DBManager.saveObject(partypokemon);
                }
            }
            else {
                Party party = DBManager.getPartyByNumber(partynumber);
                party.setPartyname(inputpartyname.getText().toString());
                DBManager.saveObject(party);

                List<PartyPokemon> partypokemonlist = DBManager.getPokemonsInParty(partynumber);
                List<PokemonDetail> pokemonlist = pokemonadapter.getPokemonlist();

                for (PartyPokemon pokemon:partypokemonlist) {
                    boolean pokemonexist = false;
                    for (PokemonDetail pokemondetail:pokemonlist) {
                        if (pokemondetail.getPokemonnumber() == pokemon.getPokemonnumber()) {
                            pokemonexist = true;
                            break;
                        }
                    }
                    if (!pokemonexist) {
                        DBManager.deletePokemonInParty(pokemon);
                    }
                }


                for (PokemonDetail pokemon:pokemonlist) {
                    PartyPokemon partypokemon = DBManager.getPokemonByPartyAndNumber(partynumber, pokemon.getPokemonnumber());
                    if (partypokemon == null) {
                        partypokemon = new PartyPokemon();
                        partypokemon.setPokemonlevel(1);
                        partypokemon.setPartynumber(party.getPartynumber());
                        partypokemon.setPokemonnumber(pokemon.getPokemonnumber());
                        DBManager.saveObject(partypokemon);
                    }
                }
            }

            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1001) {
            int[] pokemonselected = data.getIntArrayExtra("PokemonSelected");
            pokemonadapter.resetPokemonList();
            for (int i = 0; i < pokemonselected.length; i++) {
                PartyPokemon partypokemon = DBManager.getPokemonByPartyAndNumber(partynumber, pokemonselected[i]);
                if (partypokemon == null) {
                    PokemonDetail pokemon = DBManager.getPokemonDetail(pokemonselected[i], 1);
                    pokemonadapter.addPokemon(pokemon);
                }
                else {
                    PokemonDetail pokemon = DBManager.getPokemonDetail(pokemonselected[i], partypokemon.getPokemonlevel());
                    pokemonadapter.addPokemon(pokemon);
                }
            }
        }
        else if (resultCode == RESULT_OK && requestCode == 2001) {
            pokemonadapter.resetPokemonList();
            List<PartyPokemon> partypokemon = DBManager.getPokemonsInParty(partynumber);
            for (PartyPokemon pokemon:partypokemon) {
                PokemonDetail pokemondetail = DBManager.getPokemonDetail(pokemon.getPokemonnumber(), pokemon.getPokemonlevel());
                pokemonadapter.addPokemon(pokemondetail);
            }
        }
    }
}