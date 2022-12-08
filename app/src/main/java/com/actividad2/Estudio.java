package com.actividad2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Estudio  extends AppCompatActivity {
    ImageView fondo;
    Spinner spinner;
    RecyclerView rv;
    Map<String, List<Pais>> RecogerDatos = new TreeMap<>();
    List<Pais> lista;

    Actividad2Application context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudio);
        RecogerDatos = context.retornarMapa();
        context = (Actividad2Application) getApplicationContext();
        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spinnercont,R.layout.item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint({"UseCompatLoadingForDrawables", "NotifyDataSetChanged"})
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                 fondo = findViewById(R.id.fondoEstudio);


                Adapter adaptador;
                switch (position) {

                    case 0:
                        fondo.setBackground((getResources().getDrawable(R.drawable.mapamundi)));

                        break;
                    case 1:
                        fondo.setBackground((getResources().getDrawable(R.drawable.africa)));

                        lista = ((Actividad2Application) getApplicationContext()).getPais("ÁFRICA");
                        adaptador= (Adapter) new adapter(lista);
                        rv.setAdapter((RecyclerView.Adapter) adaptador);
                        ((RecyclerView.Adapter<?>) adaptador).notifyDataSetChanged();

                        break;
                    case 2:
                        fondo.setBackground((getResources().getDrawable(R.drawable.america)));
                        lista = ((Actividad2Application) getApplicationContext()).getPais("AMÉRICA");
                        adaptador= (Adapter) new adapter(lista);
                        rv.setAdapter((RecyclerView.Adapter) adaptador);
                        ((RecyclerView.Adapter<?>) adaptador).notifyDataSetChanged();
                        break;
                    case 3:
                        fondo.setBackground((getResources().getDrawable(R.drawable.asia)));
                        lista = ((Actividad2Application) getApplicationContext()).getPais("ASIA");
                        adaptador= (Adapter) new adapter(lista);
                        rv.setAdapter((RecyclerView.Adapter) adaptador);
                        ((RecyclerView.Adapter<?>) adaptador).notifyDataSetChanged();
                        break;
                    case 4:
                        fondo.setBackground((getResources().getDrawable(R.drawable.europa)));
                        lista = ((Actividad2Application) getApplicationContext()).getPais("EUROPA");
                        adaptador= (Adapter) new adapter(lista);
                        rv.setAdapter((RecyclerView.Adapter) adaptador);
                        ((RecyclerView.Adapter<?>) adaptador).notifyDataSetChanged();
                        break;
                    case 5:
                        fondo.setBackground((getResources().getDrawable(R.drawable.oceania)));
                        lista = ((Actividad2Application) getApplicationContext()).getPais("OCEANÍA");
                        adaptador= (Adapter) new adapter(lista);
                        rv.setAdapter((RecyclerView.Adapter) adaptador);
                        ((RecyclerView.Adapter<?>) adaptador).notifyDataSetChanged();
                        break;


                    default:
                        throw new IllegalStateException("Unexpected value: " + position);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}