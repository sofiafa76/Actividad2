package com.actividad2;

import static android.widget.Toast.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Estudio extends AppCompatActivity {
    Map<String, List<Pais>> datos = new TreeMap<>();
    ImageView fondo;
    RecyclerView rv;
    Actividad2Application context;
    List<Pais> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudio);
        context=(Actividad2Application) getApplicationContext();
        datos=context.RetornarMapa();

        rv=findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));


        Spinner spinnerContinentes =  findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnercont, R.layout.item);
        adapter.setDropDownViewResource(R.layout.item);
        spinnerContinentes.setAdapter(adapter);

        spinnerContinentes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                fondo=findViewById(R.id.fondomapa);


                Adapter adapter;
                switch (position) {

                    case 0:
                        fondo.setBackground((getResources().getDrawable(R.drawable.mapamundi)));

                        break;
                    case 1:
                        fondo.setBackground((getResources().getDrawable(R.drawable.africa)));

                        lista = ((Actividad2Application) getApplicationContext()).guardarMapa("ÁFRICA");
                        adapter=new Adapter(lista);
                        rv.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                        break;
                    case 2:
                        fondo.setBackground((getResources().getDrawable(R.drawable.america)));
                        lista = ((Actividad2Application) getApplicationContext()).guardarMapa("AMÉRICA");
                        adapter=new Adapter(lista);
                        rv.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        break;
                    case 3:
                        fondo.setBackground((getResources().getDrawable(R.drawable.asia)));
                        lista = ((Actividad2Application) getApplicationContext()).guardarMapa("ASIA");
                        adapter=new Adapter(lista);
                        rv.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        break;
                    case 4:
                        fondo.setBackground((getResources().getDrawable(R.drawable.europa)));
                        lista = ((Actividad2Application) getApplicationContext()).guardarMapa("EUROPA");
                        adapter=new Adapter(lista);
                        rv.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        break;
                    case 5:
                        fondo.setBackground((getResources().getDrawable(R.drawable.oceania)));
                        lista = ((Actividad2Application) getApplicationContext()).guardarMapa("OCEANÍA");
                        adapter=new Adapter(lista);
                        rv.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
}