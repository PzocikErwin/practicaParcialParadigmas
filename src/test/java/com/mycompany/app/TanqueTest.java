package com.mycompany.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class TanqueTest {

    @Test
    public void tanqueInicialmenteVivo() {
        Tanque tanque = new Tanque();
        assertTrue(tanque.estaVivo());
        assertEquals(2.0, tanque.getVida(), 0.01); // vida como double
        assertEquals(10, tanque.getMuniciones());
    }

    @Test
    public void tanqueMuereConDosDisparos() {
        Infanteria soldado = new Infanteria();
        Tanque tanque = new Tanque();

        soldado.disparar(tanque); // primer disparo
        assertTrue(tanque.estaVivo());
        soldado.disparar(tanque); // segundo disparo
        assertFalse(tanque.estaVivo());
        assertEquals(0.0, tanque.getVida(), 0.01); // vida como double
    }

    @Test
    public void tanqueRecibeDanioConEscudo50() {
        Infanteria soldado = new Infanteria();
        Tanque tanque = new Tanque();
        Escudo escudo50 = new Escudo(50); // cubre 50%
        tanque.equiparEscudo(escudo50);

        // Primer disparo
        soldado.disparar(tanque); // daño 1 * 50% = 0.5
        assertEquals(0, tanque.getVida(), 0.01); // vida parcial

        // Segundo disparo
        soldado.disparar(tanque); // otro 0.5
        assertEquals(1.0, tanque.getVida(), 0.01); // acumulación daño parcial
    }

    @Test
    public void tanqueDisparaYReduceMunicion() {
        Infanteria soldado = new Infanteria();
        Tanque tanque = new Tanque();
        int municionesAntes = tanque.getMuniciones();
        tanque.disparar(soldado);
        assertEquals(municionesAntes - 1, tanque.getMuniciones());
    }

     @Test
    public void tanqueMuereContreDisparos() {
        Infanteria soldado = new Infanteria();
        Tanque tanque = new Tanque();

        soldado.disparar(tanque); // primer disparo
        assertTrue(tanque.estaVivo());
      
        assertEquals(2.0, tanque.getVida(), 0.01); // vida como double
    }
}
