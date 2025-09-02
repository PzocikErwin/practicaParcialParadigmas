package com.mycompany.app;

public class Tanque extends Brigada {
    private double vida = 2.0;
    private IItem escudo = new EscudoNulo(); // escudo por defecto
    private Arma arma = new Arma(1);

    // Equipar un escudo real
    public void equiparEscudo(IItem escudo) {
        this.escudo = escudo;
    }

    @Override
    public void recibirDisparo(double danio) {
        double danioFinal = escudo.aplicarReduccion(danio);
        this.vida -= danioFinal;
    }

    @Override
    public boolean estaVivo() {
        return this.vida > 0;
    }

    @Override
    public double getVida() {
        return this.vida;
    }

    public void disparar(Brigada objetivo) {
        double danio = arma.disparar();
        objetivo.recibirDisparo(danio);
    }

    public void disparar() {
        arma.disparar(); // dispara al aire
    }

    public int getMuniciones() {
        return arma.getMuniciones();
    }
}
