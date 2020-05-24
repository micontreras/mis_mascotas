package com.isabelcontreras.mismascotas;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.ContactoViewHolder>{

    ArrayList<Mascota> listadoMascotas;
    Activity activity;
    //Constructor que recibira nuestra lista de contactos
    public  MascotaAdaptador(ArrayList<Mascota> listadoMascotas, Activity activity){
        this.listadoMascotas=listadoMascotas;
        this.activity=activity;
    }

    //Este es el metodo que infla o maneja cada Card view que se usara
    //y se lo pasa al viewHolder para que el obtenga cada elemento view
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new ContactoViewHolder(v);
    }

    //Aqui pasaremos la lista de contactos a cada elemento que se tiene, seteamos los calores que tiene cada elemento
    //de mi lista de contactos, se va invocando 1 a 1 por cada elemento de la lista
    //asocia cada elemento de nuestra vista con cada view
    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Mascota mascota= listadoMascotas.get(position);
        contactoViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        contactoViewHolder.tvNombreCV.setText(mascota.getNombre());
        contactoViewHolder.tvTotalLikeCV.setText(""+mascota.getCantidadRaiting());
        contactoViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascota.setCantidadRaiting(mascota.getCantidadRaiting()+1);
                contactoViewHolder.tvTotalLikeCV.setText(""+mascota.getCantidadRaiting());
            }
        });
    }

    //Cantidad de elementos que contiene mi lista de contactos
    @Override
    public int getItemCount() {
        return listadoMascotas.size();
    }

    //Permite declarar los elementos del view
    public static class ContactoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFotoCV;
        private ImageButton btnLikeCV;
        private TextView tvNombreCV;
        private TextView tvTotalLikeCV;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoCV=(ImageView)itemView.findViewById(R.id.imgFotoCV);
            btnLikeCV=(ImageButton)itemView.findViewById(R.id.btnLikeCV);
            tvNombreCV=(TextView)itemView.findViewById(R.id.tvNombreCV);
            tvTotalLikeCV=(TextView)itemView.findViewById(R.id.tvTotalLikeCV);

        }
    }
}
