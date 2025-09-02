package com.mycompany.app;

public class Acorazado extends Brigada {
    private double vida = 3.0;
    private IItem escudo = new EscudoNulo(); // nunca es null
    private Arma arma = new Arma(1);

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
        arma.disparar();
    }

    public int getMuniciones() {
        return arma.getMuniciones();
    }
}
