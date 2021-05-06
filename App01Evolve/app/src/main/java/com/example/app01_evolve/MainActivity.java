package com.example.app01_evolve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button evolve001 = findViewById(R.id.evolve001);
        Button evolve002 = findViewById(R.id.evolve002);
        Button evolve004 = findViewById(R.id.evolve004);
        Button evolve005 = findViewById(R.id.evolve005);
        Button evolve007 = findViewById(R.id.evolve007);
        Button evolve008 = findViewById(R.id.evolve008);
        ImageView bulbasaur = findViewById(R.id.bulbasaur);
        ImageView ivysaur = findViewById(R.id.ivysaur);
        ImageView venusaur = findViewById(R.id.venusaur);
        ImageView charmander = findViewById(R.id.charmander);
        ImageView charmeleon = findViewById(R.id.charmeleon);
        ImageView charizard = findViewById(R.id.charizard);
        ImageView squirtle = findViewById(R.id.squirtle);
        ImageView wartortle = findViewById(R.id.wartortle);
        ImageView blastoise = findViewById(R.id.blastoise);
        evolve001.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bulbasaur.setVisibility(View.INVISIBLE);
                ivysaur.setVisibility(View.VISIBLE);
                evolve001.setVisibility(View.INVISIBLE);
                evolve002.setVisibility(View.VISIBLE);
            }
        });
        evolve002.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ivysaur.setVisibility(View.INVISIBLE);
                venusaur.setVisibility(View.VISIBLE);
                evolve002.setVisibility(View.INVISIBLE);
            }
        });

        evolve004.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charmander.setVisibility(View.INVISIBLE);
                charmeleon.setVisibility(View.VISIBLE);
                evolve004.setVisibility(View.INVISIBLE);
                evolve005.setVisibility(View.VISIBLE);
            }
        });
        evolve005.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                charmeleon.setVisibility(View.INVISIBLE);
                charizard.setVisibility(View.VISIBLE);
                evolve005.setVisibility(View.INVISIBLE);
            }
        });

        evolve007.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                squirtle.setVisibility(View.INVISIBLE);
                wartortle.setVisibility(View.VISIBLE);
                evolve007.setVisibility(View.INVISIBLE);
                evolve008.setVisibility(View.VISIBLE);
            }
        });
        evolve008.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wartortle.setVisibility(View.INVISIBLE);
                blastoise.setVisibility(View.VISIBLE);
                evolve008.setVisibility(View.INVISIBLE);
            }
        });
    }
}