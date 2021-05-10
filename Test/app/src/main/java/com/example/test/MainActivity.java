package com.example.test;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int pokemonactivity = 101;
    TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text2 = findViewById(R.id.text2);
        text2.setText("hoho");
        Button push = findViewById(R.id.push);
        Button bulbasaur = findViewById(R.id.bulbasaur);
        RadioButton radiobulbasaur = findViewById(R.id.radiobulbasaur);
        RadioButton radiocharmander = findViewById(R.id.radiocharmander);
        RadioButton radiosquirtle = findViewById(R.id.radiosquirtle);
        bulbasaur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radiobulbasaur.isChecked()) {
                    Intent bulbasauractivity = new Intent(MainActivity.this, Bulbasaur.class);
                    bulbasauractivity.putExtra("Pkmn Bulbasaur", "Bulbasaur");
                    bulbasauractivity.putExtra("int1", 1);
                    bulbasauractivity.putExtra("bool1", true);
                    MainActivity.this.startActivityForResult(bulbasauractivity, pokemonactivity);
                }
                else if (radiocharmander.isChecked()) {

                }
                else {

                }
            }
        });

        ImageView char1 = findViewById(R.id.char1);
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setText("hello from button");
                char1.setVisibility(View.VISIBLE);
            }
        });

        char1.setImageResource(R.mipmap.charmeleon);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pokemonactivity && resultCode == RESULT_OK) {
            String resultstring = data.getStringExtra("resultstring");
            text2.setText(resultstring);
        }
    }
}