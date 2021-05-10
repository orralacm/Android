package com.example.app02_evolve;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton radiobulbasaur = findViewById(R.id.radiobulbasaur);
        RadioButton radiocharmander = findViewById(R.id.radiocharmander);
        RadioButton radiosquirtle = findViewById(R.id.radiosquirtle);

        Button btnevolution = findViewById(R.id.btnevolution);

        btnevolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent evolutionactivity = new Intent(MainActivity.this, Evolutions.class);
                if (radiobulbasaur.isChecked()) {
                    evolutionactivity.putExtra("Pokemon Name", "Bulbasaur");
                    evolutionactivity.putExtra("Pokemon Number", 1);
                }
                if (radiocharmander.isChecked()) {
                    evolutionactivity.putExtra("Pokemon Name", "Charmander");
                    evolutionactivity.putExtra("Pokemon Number", 4);
                }
                if (radiosquirtle.isChecked()) {
                    evolutionactivity.putExtra("Pokemon Name", "Squirtle");
                    evolutionactivity.putExtra("Pokemon Number", 7);
                }
                MainActivity.this.startActivity(evolutionactivity);
            }
        });


    }
}