
package com.actividad2;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Test extends AppCompatActivity {
    Map<String, List<Pais>> Recogerdatos = new TreeMap<>();
    ImageButton siguiente;
    ImageView fondo;
    TextView paisText;
    Actividad2Application context;
    List<Pais>lista;
    int correcta;
    String [] continentes = {"ÁFRICA","AMÉRICA","ASIA","EUROPA","OCEANÍA"};
    RadioButton r1, r2, r3, r4;

    Pais PaisAlAzar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        siguiente =findViewById(R.id.siguiente);
        paisText =findViewById(R.id.paisText);
        r1 =findViewById(R.id.r1);
        r2 =findViewById(R.id.r2);
        r3 =findViewById(R.id.r3);
        r4 =findViewById(R.id.r4);
        fondo=findViewById(R.id.fondo);

        context=(Actividad2Application) getApplicationContext();
        Recogerdatos =context.RetornarMapa();
        examen((View) siguiente);
    }
    public void solucion(View v){
        String capitalCorrecta = PaisAlAzar.getCapital();
        switch (v.getId()){
            case R.id.r1:
                if (correcta ==1){
                    r1.setTextColor(Color.GREEN);
                    r2.setTextColor(Color.RED);
                    r3.setTextColor(Color.RED);
                    r4.setTextColor(Color.RED);

                } else {
                    r1.setTextColor(Color.RED);
                    Toast.makeText(this,"La respuesta correcta es "+capitalCorrecta,Toast.LENGTH_LONG).show();

                }
                break;
            case R.id.r2:

                if (correcta ==2){
                    r1.setTextColor(Color.RED);
                    r2.setTextColor(Color.GREEN);
                    r3.setTextColor(Color.RED);
                    r4.setTextColor(Color.RED);

                } else {
                    r2.setTextColor(Color.RED);
                    Toast.makeText(this,"La respuesta correcta es "+capitalCorrecta,Toast.LENGTH_LONG).show();

                }
                break;
            case R.id.r3:

                if (correcta ==3){
                    r1.setTextColor(Color.RED);
                    r2.setTextColor(Color.RED);
                    r3.setTextColor(Color.GREEN);
                    r4.setTextColor(Color.RED);

                } else {
                    r3.setTextColor(Color.RED);
                    Toast.makeText(this,"La respuesta correcta es "+capitalCorrecta,Toast.LENGTH_LONG).show();


                }
                break;
            case R.id.r4:

                if (correcta ==4){
                    r1.setTextColor(Color.RED);
                    r2.setTextColor(Color.RED);
                    r3.setTextColor(Color.RED);
                    r4.setTextColor(Color.GREEN);

                } else {
                    r4.setTextColor(Color.RED);
                    Toast.makeText(this,"La respuesta correcta es "+capitalCorrecta,Toast.LENGTH_LONG).show();


                }
                break;

        }

    }
    public void examen(View view){
        r1.setTextColor(Color.parseColor("#586949"));
        r2.setTextColor(Color.parseColor("#586949"));
        r3.setTextColor(Color.parseColor("#586949"));
        r4.setTextColor(Color.parseColor("#586949"));
        r1.setChecked(false);
        r2.setChecked(false);
        r3.setChecked(false);
        r4.setChecked(false);

        int conti = new Random().nextInt(continentes.length);
        String contador=continentes[conti];
        lista = ((Actividad2Application) getApplicationContext()).guardarMapa(contador);
        Random random = new Random();
        PaisAlAzar = lista.get(random.nextInt(lista.size()));

        String continente= PaisAlAzar.getContintente();

        if (continente.equals("ÁFRICA")){
            fondo.setBackground((getResources().getDrawable(R.drawable.africa)));
        }else{
            if (continente.equals("ASIA")){
                fondo.setBackground((getResources().getDrawable(R.drawable.asia)));
            }else{
                if(continente.equals("EUROPA")){
                    fondo.setBackground((getResources().getDrawable(R.drawable.europa)));
                }else{
                    if (continente.equals("AMÉRICA")){
                        fondo.setBackground((getResources().getDrawable(R.drawable.europa)));
                    }
                    else {
                        fondo.setBackground((getResources().getDrawable(R.drawable.oceania)));
                    }
                }
            }
        }
        int randoms = (int)(Math.random()*4)+1;
        paisText.setText("CAPITAL DE "+ PaisAlAzar.getPais());
        switch (randoms){
            case 1:
                r1.setText(PaisAlAzar.getCapital());
                r2.setText(mal());
                r3.setText(mal());
                r4.setText(mal());
                correcta =1;
                break;
            case 2:
                r2.setText(PaisAlAzar.getCapital());
                r1.setText(mal());
                r3.setText(mal());
                r4.setText(mal());
                correcta =2;
                break;
            case 3:
                r3.setText(PaisAlAzar.getCapital());
                r2.setText(mal());
                r1.setText(mal());
                r4.setText(mal());
                correcta =3;
                break;
            case 4:
                r4.setText(PaisAlAzar.getCapital());
                r2.setText(mal());
                r3.setText(mal());
                r1.setText(mal());
                correcta =4;
                break;
        }

    }
    private String mal() {
        Random mal = new Random();
        Pais resmal = lista.get(mal.nextInt(lista.size()));
        return resmal.getCapital();
    }

}