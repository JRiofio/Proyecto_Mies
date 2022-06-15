package com.example.mies_dinapen.Entidades;

public class Incidente {
    private int id_incidente;
    private String fecha ;
    private String longitud_latitud;
    private int id_Usuario;

    public int getId_incidente() {
        return id_incidente;
    }

    public void setId_incidente(int id_incidente) {
        this.id_incidente = id_incidente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLongitud_latitud() {
        return longitud_latitud;
    }

    public void setLongitud_latitud(String longitud_latitud) {
        this.longitud_latitud = longitud_latitud;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }
}
