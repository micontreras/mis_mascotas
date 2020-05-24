package com.isabelcontreras.mismascotas;

public class Mascota {
    private String nombre;
    private int cantidadRaiting;
    private int foto;

    public Mascota(String nombre, int cantidadRaiting, int foto) {
        this.nombre = nombre;
        this.cantidadRaiting = cantidadRaiting;
        this.foto = foto;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadRaiting() {
        return cantidadRaiting;
    }

    public void setCantidadRaiting(int cantidadRaiting) {
        this.cantidadRaiting = cantidadRaiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
