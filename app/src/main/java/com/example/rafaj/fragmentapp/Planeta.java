package com.example.rafaj.fragmentapp;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.io.Serializable;

public class Planeta implements Serializable {
    private String nombre,tamanio,distancia;
    private Drawable imageID;
    public Planeta(String nombre,String tamanio,String distancia,Drawable imageID){
        this.nombre=nombre;
        this.tamanio=tamanio;
        this.distancia =distancia;
        this.imageID=imageID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTamanio() {
        return tamanio;
    }

    public String getDistancia() {
        return distancia;
    }

    public Drawable getImageID() {
        return imageID;
    }
}
