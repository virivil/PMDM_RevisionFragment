package com.example.vince.pmdm_proyecto;

import android.graphics.drawable.Drawable;

/**
 * Created by vince on 5/11/15.
 */
public class elemento {

    public Drawable imagen;
    public String texto;
    public String color;
    public long Id;

    //CONSTRUCTOR
    public elemento(Drawable img,String text,String color) {
        super();
        this.texto =text;
        this.imagen=img;
        this.color=color;
    }




    public Drawable getImagen() {
        return imagen;
    }

    public String getTexto() {
        return texto;
    }

    public String getColor() {
        return color;
    }

    public long getId(){return Id;}





}