package com.actividad2;

import android.app.Application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


    public class Actividad2Application extends Application {

        Map<String, List<Pais>> retornarMapa = new TreeMap<>();

        public Map<String, List<Pais>> RetornarMapa() {
            return retornarMapa;
        }

        @Override
        public void onCreate() {
            super.onCreate();
            try {
                InputStream stream = getResources().openRawResource(R.raw.capitales);
                BufferedReader in = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8));
                String linea;
                while ((linea = in.readLine()) != null) {
                    String[] items = linea.split(";");
                    Pais pais = new Pais(items[1], items[2], items[0]);
                    List<Pais> paises = retornarMapa.get(items[0]);
                    if (paises == null) {
                        paises = new ArrayList<>();
                        retornarMapa.put(items[0], paises);
                    }
                    paises.add(pais);

                }
            } catch (IOException e) {
                retornarMapa = null;
            }
        }

        public List<Pais> guardarMapa(String continente) {
            return Collections.unmodifiableList(retornarMapa.get(continente));
        }



    }
