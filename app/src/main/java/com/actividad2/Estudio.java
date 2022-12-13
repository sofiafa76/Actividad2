package com.actividad2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Estudio extends AppCompatActivity {
    Map<String, List<Pais>> datos = new TreeMap<>();
    ImageView fondomapas;
    RecyclerView rv;
    Actividad2Application context;
    List<Pais> listapaises;


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

                fondomapas =findViewById(R.id.fondomapa);


                Adapter adapter;
                switch (position) {

                    case 0:
                        fondomapas.setBackground((getResources().getDrawable(R.drawable.mapamundi)));

                        break;
                    case 1:
                        fondomapas.setBackground((getResources().getDrawable(R.drawable.africa)));

                        listapaises = ((Actividad2Application) getApplicationContext()).guardarMapa("ÁFRICA");
                        adapter=new Adapter(listapaises);
                        rv.setAdapter(adapter);
                        adapter.notifyDataSetChanged();

                        break;
                    case 2:
                        fondomapas.setBackground((getResources().getDrawable(R.drawable.america)));
                        listapaises = ((Actividad2Application) getApplicationContext()).guardarMapa("AMÉRICA");
                        adapter=new Adapter(listapaises);
                        rv.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        break;
                    case 3:
                        fondomapas.setBackground((getResources().getDrawable(R.drawable.asia)));
                        listapaises = ((Actividad2Application) getApplicationContext()).guardarMapa("ASIA");
                        adapter=new Adapter(listapaises);
                        rv.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        break;
                    case 4:
                        fondomapas.setBackground((getResources().getDrawable(R.drawable.europa)));
                        listapaises = ((Actividad2Application) getApplicationContext()).guardarMapa("EUROPA");
                        adapter=new Adapter(listapaises);
                        rv.setAdapter(adapter);
                        adapter.notifyDataSetChanged();
                        break;
                    case 5:
                        fondomapas.setBackground((getResources().getDrawable(R.drawable.oceania)));
                        listapaises = ((Actividad2Application) getApplicationContext()).guardarMapa("OCEANÍA");
                        adapter=new Adapter(listapaises);
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