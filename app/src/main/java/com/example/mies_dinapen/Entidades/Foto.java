package com.example.mies_dinapen.Entidades;

import kotlinx.coroutines.Job;

public class Foto {
    private int id_foto;
    private Job imag;
    private int id_incidente;

    public int getId_foto() {
        return id_foto;
    }

    public void setId_foto(int id_foto) {
        this.id_foto = id_foto;
    }

    public Job getImag() {
        return imag;
    }

    public void setImag(Job imag) {
        this.imag = imag;
    }

    public int getId_incidente() {
        return id_incidente;
    }

    public void setId_incidente(int id_incidente) {
        this.id_incidente = id_incidente;
    }
}
