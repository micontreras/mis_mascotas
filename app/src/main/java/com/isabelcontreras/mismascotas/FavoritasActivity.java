package com.isabelcontreras.mismascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FavoritasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public  MascotaAdaptador adaptador;
    ArrayList<Mascota> mascotasFavoritas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView= findViewById(R.id.rvMascotas);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);

        obtenerMascotasFavoritas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador(){
        adaptador= new MascotaAdaptador(mascotasFavoritas, this);
        recyclerView.setAdapter(adaptador);
    }
    public void obtenerMascotasFavoritas(){
        mascotasFavoritas=new ArrayList<>();
        mascotasFavoritas.add(new Mascota("Pecita",7,R.mipmap.img_peces));
        mascotasFavoritas.add(new Mascota("MrCaballito",6,R.mipmap.img_caballito_mar));
        mascotasFavoritas.add(new Mascota("Perrito",5,R.mipmap.img_perrito));
        mascotasFavoritas.add(new Mascota("Gatito",5,R.mipmap.img_gatito));
        mascotasFavoritas.add(new Mascota("Patito",4,R.mipmap.img_patito));

    }
}
