package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class InfanteriaTest {

    @Test
    public void infanteriaInicialmenteViva() {
        Infanteria soldado = new Infanteria();
        assertTrue(soldado.estaVivo());
        assertEquals(1.0, soldado.getVida(), 0.01); 
        assertEquals(10, soldado.getMuniciones());
    }

    @Test
    public void infanteriaMuereConUnDisparo() {
        Tanque tanque = new Tanque();
        Infanteria soldado = new Infanteria();
        tanque.disparar(soldado);
        assertFalse(soldado.estaVivo());
        assertEquals(0.0, soldado.getVida(), 0.01); 
    }

    @Test
    public void disparoReduceMunicion() {
        Infanteria soldado = new Infanteria();
        Tanque tanque = new Tanque();
        int municionesAntes = soldado.getMuniciones();
        soldado.disparar(tanque);
        assertEquals(municionesAntes - 1, soldado.getMuniciones());
    }

    @Test
    public void infanteriaRecibeDanioConEscudo50() {
        Infanteria soldado = new Infanteria();
        Escudo escudo50 = new Escudo(50); // cubre 50%
        soldado.equiparEscudo(escudo50);

        Tanque tanque = new Tanque();
        tanque.disparar(soldado); // daño 1 * 50% = 0.5

        assertEquals(0.5, soldado.getVida(), 0.01); // vida reducida parcialmente
    }
}

