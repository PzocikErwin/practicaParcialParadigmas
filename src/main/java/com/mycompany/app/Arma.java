package com.mycompany.app;

public class Arma {
    private int municiones;
    private double danio; 

    public Arma(double danio) {
        this.municiones = 10; // máximo 10 disparos
        this.danio = danio;
    }

    public double disparar() {
        if (municiones == 0) return 0.0; // si no hay municiones, no hace daño
        municiones--;
        return danio;
    }

    public int getMuniciones() {
        return municiones;
    }
}
