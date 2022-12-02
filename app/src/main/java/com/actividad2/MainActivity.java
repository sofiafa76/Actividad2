package com.actividad2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    ImageView estudio;
    ImageView test;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        estudio = findViewById(R.id.estudio);
        test = findViewById(R.id.test);
        test.setOnClickListener(view -> {
            Intent gotoTest=new Intent(getApplicationContext(),Estudio.class);
            startActivity(gotoTest);
        });
        estudio.setOnClickListener(view -> {
            Intent gotoEstudio = new Intent(getApplicationContext(), Estudio.class);
            startActivity(gotoEstudio);
        });


    }
}