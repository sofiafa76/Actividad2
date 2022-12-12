package com.actividad2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<Pais> pais;

    public Adapter(List<Pais> modelList) {
        pais=modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(pais.get(position));
    }

    @Override
    public int getItemCount() {
        return pais.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView paises;
        private  final TextView capital;


        ViewHolder(View v) {
            super(v);
            paises=v.findViewById(R.id.paises);
            capital=v.findViewById(R.id.capitales);
        }
        void bind(Pais pais){
            paises.setText(pais.getPais());
            capital.setText(pais.getCapital());
        }

    }


}
