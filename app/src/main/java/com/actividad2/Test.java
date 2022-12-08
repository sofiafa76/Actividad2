package com.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.TreeMap;

public class Test extends AppCompatActivity {
    ImageButton next;
    TextView textPais;
    RadioButton r1,r2,r3,r4;
    ImageView fondo;
    Actividad2Application context;
    Map<String, List<Pais>> Recogerdatos = new TreeMap<>();
    List<Pais>lista;
    int Correcta;
    String [] continentes = {"ÁFRICA","AMÉRICA","ASIA","EUROPA","OCEANÍA"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        next = findViewById(R.id.nextButton);
        textPais = findViewById(R.id.PaisText);
        fondo = findViewById(R.id.fondo);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);
        context=(Actividad2Application) getApplicationContext();
        Recogerdatos=context.retornarMapa();
        test();
        next.setOnClickListener(v->{
            test();
        });
        r1.setOnClickListener(v->{
            if (Correcta ==1){
                r1.setTextColor(Color.GREEN);
            } else {
                r1.setTextColor(Color.RED);
            }
        });
        r2.setOnClickListener(v->{
            if (Correcta ==2){
                r2.setTextColor(Color.GREEN);
            } else {
                r2.setTextColor(Color.RED);
            }
        });
        r3.setOnClickListener(v->{
            if (Correcta ==3){
                r3.setTextColor(Color.GREEN);
            } else {
                r3.setTextColor(Color.RED);
            }
        });
        r4.setOnClickListener(v->{
            if (Correcta ==4){
                r4.setTextColor(Color.GREEN);
            } else {
                r4.setTextColor(Color.RED);
            }
        });
    }

    public void test() {
        int contirandom = new Random().nextInt(continentes.length);
        String continente=continentes[contirandom];
        lista =((Actividad2Application) getApplicationContext()).getPais(continente);
        Random rng = new Random();
        Pais rpais= lista.get(rng.nextInt(lista.size()));
        switch (rpais.getContintente()){
            case "ÁFRICA":
                fondo.setImageResource(R.drawable.africa);
                break;
            case "AMÉRICA":
                fondo.setImageResource(R.drawable.america);
                break;
            case "ASIA":
                fondo.setImageResource(R.drawable.asia);
                break;
            case "EUROPA":
                fondo.setImageResource(R.drawable.europa);
                break;
            case "OCEANÍA":
                fondo.setImageResource(R.drawable.oceania);
                break;
        }
        int rngSwitch = (int)(Math.random()*4)+1;
        textPais.setText(rpais.getPais());
        switch (rngSwitch){
            case 1:
                r1.setText(rpais.getCapital());
                r2.setText(RIncorrectas());
                r3.setText(RIncorrectas());
                r4.setText(RIncorrectas());
                Correcta =1;
                break;
            case 2:
                r2.setText(rpais.getCapital());
                r1.setText(RIncorrectas());
                r3.setText(RIncorrectas());
                r4.setText(RIncorrectas());
                Correcta =2;
                break;
            case 3:
                r3.setText(rpais.getCapital());
                r2.setText(RIncorrectas());
                r1.setText(RIncorrectas());
                r4.setText(RIncorrectas());
                Correcta =3;
                break;
            case 4:
                r4.setText(rpais.getCapital());
                r2.setText(RIncorrectas());
                r3.setText(RIncorrectas());
                r1.setText(RIncorrectas());
                Correcta =4;
                break;
        }
        r1.setTextColor(Color.parseColor("#000000"));
        r2.setTextColor(Color.parseColor("#000000"));
        r3.setTextColor(Color.parseColor("#000000"));
        r4.setTextColor(Color.parseColor("#000000"));
        r1.setChecked(false);
        r2.setChecked(false);
        r3.setChecked(false);
        r4.setChecked(false);

    }
    private String RIncorrectas() {
        Random rWrong = new Random();
        Pais wrong = lista.get(rWrong.nextInt(lista.size()));
        return wrong.getCapital();
    }
}