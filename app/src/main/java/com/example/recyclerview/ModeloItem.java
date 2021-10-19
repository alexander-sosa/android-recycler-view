package com.example.recyclerview;

import android.graphics.Color;
import android.widget.RelativeLayout;

public class ModeloItem {
    int foto;
    String titulo, detalle;
    //String color;
    int color; // se puede almacenar un color en un entero con Color.argb(alpha, r, g, b)
    boolean selected;

    // ahora se crea un adaptador propio

    public ModeloItem(int foto, String titulo, String detalle, int color, boolean selected) {
        this.foto = foto;
        this.titulo = titulo;
        this.detalle = detalle;
        this.color = color;
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
