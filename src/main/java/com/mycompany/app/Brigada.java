package com.mycompany.app;

public abstract class Brigada {

    // Vida de la unidad
    protected double vida;

    // metodo abstracto: cada subclase define cómo recibe un disparo
    public abstract void recibirDisparo(double danio);

    // metodo abstracto: cada subclase define cómo saber si sigue vivo
    public abstract boolean estaVivo();

    // metodo abstracto: cada subclase define cómo devolver la vida actual
    public abstract double getVida();
}
