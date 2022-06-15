package com.example.mies_dinapen.Entidades;

import kotlinx.coroutines.Job;

public class Audio {
    private int id_Audio;
    private Job audio;
    private int id_incidente;

    public int getId_Audio() {
        return id_Audio;
    }

    public void setId_Audio(int id_Audio) {
        this.id_Audio = id_Audio;
    }

    public Job getAudio() {
        return audio;
    }

    public void setAudio(Job audio) {
        this.audio = audio;
    }

    public int getId_incidente() {
        return id_incidente;
    }

    public void setId_incidente(int id_incidente) {
        this.id_incidente = id_incidente;
    }
}
