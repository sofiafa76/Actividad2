package com.actividad2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Estudio extends AppCompatActivity {
    Spinner spinner;
    RecyclerView rv;
    List<Pais> RecogerDatos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudio);
        rv = findViewById(R.id.rv);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spinnercont, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        String[] almacenarContinentes = getResources().getStringArray(R.array.spinnercont);
        RecyclerView.Adapter adapter=new adapter(almacenarContinentes);
        rv.setAdapter(adapter);

        RecogerDatos = ((Actividad2Application) getApplicationContext()).getPais(almacenarContinentes[1]);

    }
}