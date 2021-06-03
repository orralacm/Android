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
        partyadapter = new PartyAdapter(DBManager.getAllParties(), this);

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

        PokemonDetail charmander = DBManager.getPokemonDetail(102, 1);
        if (charmander == null) {
            charmander = new PokemonDetail();
            charmander.setPokemonname("Charmander");
            charmander.setPokemonlevel(1);
            charmander.setPokemonnumber(102);
            charmander.setPokemonimage(R.mipmap.charmander);
            DBManager.saveObject(charmander);
        }
        PokemonDetail charmeleon = DBManager.getPokemonDetail(102, 2);
        if (charmeleon == null) {
            charmeleon = new PokemonDetail();
            charmeleon.setPokemonname("Charmeleon");
            charmeleon.setPokemonlevel(2);
            charmeleon.setPokemonnumber(102);
            charmeleon.setPokemonimage(R.mipmap.charmeleon);
            DBManager.saveObject(charmeleon);
        }
        PokemonDetail charizard = DBManager.getPokemonDetail(102, 3);
        if (charizard == null) {
            charizard = new PokemonDetail();
            charizard.setPokemonname("Charizard");
            charizard.setPokemonlevel(3);
            charizard.setPokemonnumber(102);
            charizard.setPokemonimage(R.mipmap.charizard);
            DBManager.saveObject(charizard);
        }

        PokemonDetail squirtle = DBManager.getPokemonDetail(103, 1);
        if (squirtle == null) {
            squirtle = new PokemonDetail();
            squirtle.setPokemonname("Squirtle");
            squirtle.setPokemonlevel(1);
            squirtle.setPokemonnumber(103);
            squirtle.setPokemonimage(R.mipmap.squirtle);
            DBManager.saveObject(squirtle);
        }
        PokemonDetail wartortle = DBManager.getPokemonDetail(103, 2);
        if (wartortle == null) {
            wartortle = new PokemonDetail();
            wartortle.setPokemonname("Wartortle");
            wartortle.setPokemonlevel(2);
            wartortle.setPokemonnumber(103);
            wartortle.setPokemonimage(R.mipmap.wartortle);
            DBManager.saveObject(wartortle);
        }
        PokemonDetail blastoise = DBManager.getPokemonDetail(103, 3);
        if (blastoise == null) {
            blastoise = new PokemonDetail();
            blastoise.setPokemonname("Blastoise");
            blastoise.setPokemonlevel(3);
            blastoise.setPokemonnumber(103);
            blastoise.setPokemonimage(R.mipmap.blastoise);
            DBManager.saveObject(blastoise);
        }

        PokemonDetail chikorita = DBManager.getPokemonDetail(201, 1);
        if (chikorita == null) {
            chikorita = new PokemonDetail();
            chikorita.setPokemonname("Chikorita");
            chikorita.setPokemonlevel(1);
            chikorita.setPokemonnumber(201);
            chikorita.setPokemonimage(R.mipmap.chikorita);
            DBManager.saveObject(chikorita);
        }
        PokemonDetail bayleef = DBManager.getPokemonDetail(201, 2);
        if (bayleef == null) {
            bayleef = new PokemonDetail();
            bayleef.setPokemonname("Bayleef");
            bayleef.setPokemonlevel(2);
            bayleef.setPokemonnumber(201);
            bayleef.setPokemonimage(R.mipmap.bayleef);
            DBManager.saveObject(bayleef);
        }
        PokemonDetail meganium = DBManager.getPokemonDetail(201, 3);
        if (meganium == null) {
            meganium = new PokemonDetail();
            meganium.setPokemonname("Meganium");
            meganium.setPokemonlevel(3);
            meganium.setPokemonnumber(201);
            meganium.setPokemonimage(R.mipmap.meganium);
            DBManager.saveObject(meganium);
        }

        PokemonDetail cyndaquil = DBManager.getPokemonDetail(202, 1);
        if (cyndaquil == null) {
            cyndaquil = new PokemonDetail();
            cyndaquil.setPokemonname("Cyndaquil");
            cyndaquil.setPokemonlevel(1);
            cyndaquil.setPokemonnumber(202);
            cyndaquil.setPokemonimage(R.mipmap.cyndaquil);
            DBManager.saveObject(cyndaquil);
        }
        PokemonDetail quilava = DBManager.getPokemonDetail(202, 2);
        if (quilava == null) {
            quilava = new PokemonDetail();
            quilava.setPokemonname("Quilava");
            quilava.setPokemonlevel(2);
            quilava.setPokemonnumber(202);
            quilava.setPokemonimage(R.mipmap.quilava);
            DBManager.saveObject(quilava);
        }
        PokemonDetail typhlosion = DBManager.getPokemonDetail(202, 3);
        if (typhlosion == null) {
            typhlosion = new PokemonDetail();
            typhlosion.setPokemonname("Typhlosion");
            typhlosion.setPokemonlevel(3);
            typhlosion.setPokemonnumber(202);
            typhlosion.setPokemonimage(R.mipmap.typhlosion);
            DBManager.saveObject(typhlosion);
        }

        PokemonDetail totodile = DBManager.getPokemonDetail(203, 1);
        if (totodile == null) {
            totodile = new PokemonDetail();
            totodile.setPokemonname("Totodile");
            totodile.setPokemonlevel(1);
            totodile.setPokemonnumber(203);
            totodile.setPokemonimage(R.mipmap.totodile);
            DBManager.saveObject(totodile);
        }
        PokemonDetail croconaw = DBManager.getPokemonDetail(203, 2);
        if (croconaw == null) {
            croconaw = new PokemonDetail();
            croconaw.setPokemonname("Croconaw");
            croconaw.setPokemonlevel(2);
            croconaw.setPokemonnumber(203);
            croconaw.setPokemonimage(R.mipmap.croconaw);
            DBManager.saveObject(croconaw);
        }
        PokemonDetail feraligatr = DBManager.getPokemonDetail(203, 3);
        if (feraligatr == null) {
            feraligatr = new PokemonDetail();
            feraligatr.setPokemonname("Feraligatr");
            feraligatr.setPokemonlevel(3);
            feraligatr.setPokemonnumber(203);
            feraligatr.setPokemonimage(R.mipmap.feraligatr);
            DBManager.saveObject(feraligatr);
        }
    }
}