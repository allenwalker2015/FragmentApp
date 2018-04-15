package com.example.rafaj.fragmentapp;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.io.Serializable;

public class Planeta implements Serializable {
    private String nombre,tamanio,distancia;
    private int imageID;
    public Planeta(String nombre,String tamanio,String distancia,int imageID){
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

    public int getImageID() {
        return imageID;
    }
}
