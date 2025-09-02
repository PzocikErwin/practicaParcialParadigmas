package com.mycompany.app;

public class EscudoNulo extends Escudo {
    public EscudoNulo() {
        super(0); // porcentaje 0, no reduce nada
    }

    @Override
    public double aplicarReduccion(double danio) {
        return danio; // no cambia el daño
    }
}
