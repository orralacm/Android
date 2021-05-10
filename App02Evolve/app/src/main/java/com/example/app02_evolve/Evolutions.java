package com.example.app02_evolve;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Evolutions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evolutions);

        TextView text1 = findViewById(R.id.text1);

        String Name = getIntent().getStringExtra("Pokemon Name");
        int Number = getIntent().getIntExtra("Pokemon Number", 0);
        text1.setText("The Pokemon Name is: " + Name + " and it's Pokedex number is: " + Number);

        if (Number == 1) {
            Button evolve001 = findViewById(R.id.evolve001);
            Button evolve002 = findViewById(R.id.evolve002);
            ImageView bulbasaur = findViewById(R.id.bulbasaur);
            ImageView ivysaur = findViewById(R.id.ivysaur);
            ImageView venusaur = findViewById(R.id.venusaur);
            bulbasaur.setVisibility(View.VISIBLE);
            evolve001.setVisibility(View.VISIBLE);
            evolve001.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bulbasaur.setVisibility(View.INVISIBLE);
                    ivysaur.setVisibility(View.VISIBLE);
                    evolve001.setVisibility(View.INVISIBLE);
                    evolve002.setVisibility(View.VISIBLE);
                    String Name = "Ivysaur";
                    int Number = 2;
                    text1.setText("The Pokemon Name is: " + Name + " and it's Pokedex number is: " + Number);
                }
            });
            evolve002.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ivysaur.setVisibility(View.INVISIBLE);
                    venusaur.setVisibility(View.VISIBLE);
                    evolve002.setVisibility(View.INVISIBLE);
                    String Name = "Venusaur";
                    int Number = 3;
                    text1.setText("The Pokemon Name is: " + Name + " and it's Pokedex number is: " + Number);
                }
            });

        }

        if (Number == 4) {
            Button evolve004 = findViewById(R.id.evolve004);
            Button evolve005 = findViewById(R.id.evolve005);
            ImageView charmander = findViewById(R.id.charmander);
            ImageView charmeleon = findViewById(R.id.charmeleon);
            ImageView charizard = findViewById(R.id.charizard);
            charmander.setVisibility(View.VISIBLE);
            evolve004.setVisibility(View.VISIBLE);
            evolve004.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    charmander.setVisibility(View.INVISIBLE);
                    charmeleon.setVisibility(View.VISIBLE);
                    evolve004.setVisibility(View.INVISIBLE);
                    evolve005.setVisibility(View.VISIBLE);
                    String Name = "Charmeleon";
                    int Number = 5;
                    text1.setText("The Pokemon Name is: " + Name + " and it's Pokedex number is: " + Number);
                }
            });
            evolve005.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    charmeleon.setVisibility(View.INVISIBLE);
                    charizard.setVisibility(View.VISIBLE);
                    evolve005.setVisibility(View.INVISIBLE);
                    String Name = "Charizard";
                    int Number = 6;
                    text1.setText("The Pokemon Name is: " + Name + " and it's Pokedex number is: " + Number);
                }
            });

        }

        if (Number == 7) {
            Button evolve007 = findViewById(R.id.evolve007);
            Button evolve008 = findViewById(R.id.evolve008);
            ImageView squirtle = findViewById(R.id.squirtle);
            ImageView wartortle = findViewById(R.id.wartortle);
            ImageView blastoise = findViewById(R.id.blastoise);
            squirtle.setVisibility(View.VISIBLE);
            evolve007.setVisibility(View.VISIBLE);
            evolve007.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    squirtle.setVisibility(View.INVISIBLE);
                    wartortle.setVisibility(View.VISIBLE);
                    evolve007.setVisibility(View.INVISIBLE);
                    evolve008.setVisibility(View.VISIBLE);
                    String Name = "Wartortle";
                    int Number = 8;
                    text1.setText("The Pokemon Name is: " + Name + " and it's Pokedex number is: " + Number);
                }
            });
            evolve008.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    wartortle.setVisibility(View.INVISIBLE);
                    blastoise.setVisibility(View.VISIBLE);
                    evolve008.setVisibility(View.INVISIBLE);
                    String Name = "Blastoise";
                    int Number = 9;
                    text1.setText("The Pokemon Name is: " + Name + " and it's Pokedex number is: " + Number);
                }
            });
        }
    }
}