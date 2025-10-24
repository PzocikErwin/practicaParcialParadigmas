package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class EscudoTest {

    @Test
    public void infanteriaDisparaATanqueConEscudo() {
        Infanteria soldado = new Infanteria();
        Tanque tanque = new Tanque();
        Escudo escudo50 = new Escudo(50.0); // reduce daño 50%
        tanque.equiparEscudo(escudo50);

        // Infantería dispara
        soldado.disparar(tanque); 
        // daño 1 * 50% = 0.5
        assertEquals(1.5, tanque.getVida(), 0.01); // vida reducida parcialmente

        // Infantería dispara otra vez
        soldado.disparar(tanque);
        assertEquals(1.0, tanque.getVida(), 0.01); // daño acumulado
    }

    @Test
    public void acorazadoRecibeDanioConEscudo() {
        Acorazado barco = new Acorazado();
        Escudo escudo25 = new Escudo(25.0); // reduce daño 25%
        barco.equiparEscudo(escudo25);

        // simulamos daño de 1
        barco.recibirDisparo(1.0); 
        // daño final = 1 * 0.75 = 0.75
        assertEquals(2.25, barco.getVida(), 0.01); // vida reducida parcialmente
    }
}
