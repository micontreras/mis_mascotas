package com.isabelcontreras.mismascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> listadoMascotas;
    private RecyclerView recyclerView;
    public  MascotaAdaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.rvMascotas);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);
        obtenerListadoMascotas();
        inicializarAdaptador();
    }
    //PAra agregar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    //Control del menu que se agrega
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFavoritos:
                Intent intentConfig= new Intent(this, FavoritasActivity.class);
                startActivity(intentConfig);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Separando un poco, este hara las configuraciones
    public void inicializarAdaptador(){
        adaptador= new MascotaAdaptador(listadoMascotas, this);
        recyclerView.setAdapter(adaptador);
    }
    public void obtenerListadoMascotas(){
        listadoMascotas=new ArrayList<>();
        listadoMascotas.add(new Mascota("Perrito",7,R.mipmap.img_perrito));
        listadoMascotas.add(new Mascota("Caballito",1,R.mipmap.img_caballito));
        listadoMascotas.add(new Mascota("MrCaballito",6,R.mipmap.img_caballito_mar));
        listadoMascotas.add(new Mascota("Gatito",5,R.mipmap.img_gatito));
        listadoMascotas.add(new Mascota("Ham",2,R.mipmap.img_hamster));
        listadoMascotas.add(new Mascota("Pajarito",3,R.mipmap.img_pajarito));
        listadoMascotas.add(new Mascota("Patito",4,R.mipmap.img_patito));
        listadoMascotas.add(new Mascota("Pecita",8,R.mipmap.img_peces));
    }
}
