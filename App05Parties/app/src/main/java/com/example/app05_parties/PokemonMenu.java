package com.example.app05_parties;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class PokemonMenu extends AppCompatActivity {

    RecyclerView recyclerview;
    PokemonAdapter pokemonadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_menu);
        setTitle("Pokemon Menu");

        recyclerview = findViewById(R.id.recyclepokemon);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        List<Integer> pokemonsselected = new ArrayList<>();
        if (getIntent().hasExtra("PokemonsInParty")) {
            int[] pokemonsinparty = getIntent().getIntArrayExtra("PokemonsInParty");
            for (int i = 0; i < pokemonsinparty.length; i++) {
                pokemonsselected.add(pokemonsinparty[i]);
            }
        }
        pokemonadapter = new PokemonAdapter(DBManager.getAllPokemons(), true, pokemonsselected, this);

        recyclerview.setAdapter(pokemonadapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pokemon_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            List<Integer> pokemonselected = pokemonadapter.getPokemonSelected();
            int[] arraypokemon = new int[pokemonselected.size()];
            for (int i = 0; i < pokemonselected.size(); i++) {
                arraypokemon[i] = pokemonselected.get(i);
            }
            Intent result = new Intent();
            result.putExtra("PokemonSelected", arraypokemon);
            setResult(RESULT_OK, result);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}