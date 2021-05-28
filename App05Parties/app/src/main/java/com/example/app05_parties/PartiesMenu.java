package com.example.app05_parties;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class PartiesMenu extends AppCompatActivity {

    RecyclerView recyclerview;
    PartyAdapter partyadapter;
    FloatingActionButton floatingactionbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parties_menu);
        setTitle("Parties Menu");

        Realm.init(this); // context, usually an Activity or Application
        RealmConfiguration config = new RealmConfiguration.Builder().name("pokemon.realm").build();
        Realm.setDefaultConfiguration(config);

        recyclerview = findViewById(R.id.recycle);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        partyadapter = new PartyAdapter(DBManager.getAllParties());

        recyclerview.setAdapter(partyadapter);

        floatingactionbutton = findViewById(R.id.btncreateparty);
        floatingactionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PartiesMenu.this, CreateParty.class);
                startActivity(intent);
            }
        });

        initPokemon();
    }

    @Override
    protected void onResume() {
        super.onResume();
        partyadapter.update(DBManager.getAllParties());
    }

    public void initPokemon() {

        PokemonDetail bulbasaur = DBManager.getPokemonDetail(101, 1);
        if (bulbasaur == null) {
            bulbasaur = new PokemonDetail();
            bulbasaur.setPokemonname("Bulbasaur");
            bulbasaur.setPokemonlevel(1);
            bulbasaur.setPokemonnumber(101);
            bulbasaur.setPokemonimage(R.mipmap.bulbasaur);
            DBManager.saveObject(bulbasaur);
        }
        PokemonDetail ivysaur = DBManager.getPokemonDetail(101, 2);
        if (ivysaur == null) {
            ivysaur = new PokemonDetail();
            ivysaur.setPokemonname("Ivysaur");
            ivysaur.setPokemonlevel(2);
            ivysaur.setPokemonnumber(101);
            ivysaur.setPokemonimage(R.mipmap.ivysaur);
            DBManager.saveObject(ivysaur);
        }
        PokemonDetail venusaur = DBManager.getPokemonDetail(101, 3);
        if (venusaur == null) {
            venusaur = new PokemonDetail();
            venusaur.setPokemonname("Venusaur");
            venusaur.setPokemonlevel(3);
            venusaur.setPokemonnumber(101);
            venusaur.setPokemonimage(R.mipmap.venusaur);
            DBManager.saveObject(venusaur);
        }
    }
}