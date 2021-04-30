package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text2 = findViewById(R.id.text2);
        text2.setText("hoho");
        Button push = findViewById(R.id.push);
        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setText("hello from button");
            }
        });
        ImageView char1 = findViewById(R.id.char1);
        char1.setImageResource(R.mipmap.charmeleon);
    }
}