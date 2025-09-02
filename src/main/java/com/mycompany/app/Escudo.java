package com.mycompany.app;

public class Escudo implements IItem {
    private double porcentaje; // 0 a 100

    public Escudo(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public double aplicarReduccion(double danio) {
        return danio * (1 - porcentaje / 100.0);
    }
}
