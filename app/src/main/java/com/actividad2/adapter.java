package com.actividad2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.accederDatos> {
    List<AlmacenarPaises> lista;

    public adapter(List lista) {
        this .lista = lista;
    }

    @NonNull
    @Override
    public accederDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new accederDatos(v);

    }

    @Override
    public void onBindViewHolder(@NonNull accederDatos holder, int position) {
        holder.bind(lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class accederDatos extends RecyclerView.ViewHolder {
        TextView paises;
        TextView capitales;

        public accederDatos(@NonNull View itemView) {
            super(itemView);
            paises=itemView.findViewById(R.id.paises);
            capitales=itemView.findViewById(R.id.capitales);
        }

        public void bind(AlmacenarPaises almacenarPaises) {
paises.setText(almacenarPaises.getPaises());
capitales.setText(almacenarPaises.getCapitales());
        }
    }
}
