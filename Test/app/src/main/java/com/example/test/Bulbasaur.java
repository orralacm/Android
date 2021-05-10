package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Bulbasaur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulbasaur);
        TextView text1 = findViewById(R.id.text1);
        String Pokemon = getIntent().getStringExtra("Pkmn Bulbasaur");
        int int1 = getIntent().getIntExtra("int1", 0);
        boolean bool1 = getIntent().getBooleanExtra("bool1", false);
        text1.setText(Pokemon + int1 + bool1);

        ImageView bulbasaur = findViewById(R.id.bulbasaur);
        ImageView charmander = findViewById(R.id.charmander);
        ImageView squirtle = findViewById(R.id.squirtle);

        RelativeLayout.LayoutParams bulbasaurparams = (RelativeLayout.LayoutParams) bulbasaur.getLayoutParams();
        bulbasaurparams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        bulbasaur.setLayoutParams(bulbasaurparams);

        RelativeLayout.LayoutParams charmanderparams = (RelativeLayout.LayoutParams) charmander.getLayoutParams();
        charmanderparams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        charmanderparams.addRule((RelativeLayout.CENTER_VERTICAL));
        charmander.setLayoutParams(charmanderparams);

        RelativeLayout.LayoutParams squirtleparams = (RelativeLayout.LayoutParams) squirtle.getLayoutParams();
        squirtleparams.setMargins(200, 200, 200, 200 );
        squirtle.setLayoutParams(squirtleparams);

        Button btnclose = findViewById(R.id.btnclose);

        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultintent = new Intent();
                resultintent.putExtra("resultstring", "Hello from bulbasaur");
                setResult(RESULT_OK, resultintent);
                finish();
            }
        });

    }
}