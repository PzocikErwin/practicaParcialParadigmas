package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class AcorazadoTest {

    @Test
    public void acorazadoInicialmenteVivo() {
        Acorazado barco = new Acorazado();
        assertTrue(barco.estaVivo());
        assertEquals(3.0, barco.getVida(), 0.01); 
        assertEquals(10, barco.getMuniciones());
    }

    @Test
    public void acorazadoMuereConTresDisparos() {
        Infanteria soldado = new Infanteria();
        Acorazado barco = new Acorazado();

        soldado.disparar(barco); // 1er disparo
        assertTrue(barco.estaVivo());
        soldado.disparar(barco); // 2do disparo
        assertTrue(barco.estaVivo());
        soldado.disparar(barco); // 3er disparo
        assertFalse(barco.estaVivo());
        assertEquals(0.0, barco.getVida(), 0.01); 
    }

    @Test
    public void acorazadoRecibeDanioConEscudo25() {
        Infanteria soldado = new Infanteria();
        Acorazado barco = new Acorazado();
        Escudo escudo25 = new Escudo(25); // cubre 25%
        barco.equiparEscudo(escudo25);

        // Primer disparo
        soldado.disparar(barco); // daño 1 * 75% = 0.75
        assertEquals(2.25, barco.getVida(), 0.01); // vida reducida parcialmente
    }

    @Test
    public void acorazadoDisparaYReduceMunicion() {
        Infanteria soldado = new Infanteria();
        Acorazado barco = new Acorazado();
        int municionesAntes = barco.getMuniciones();
        barco.disparar(soldado);
        assertEquals(municionesAntes - 1, barco.getMuniciones());
    }
}
