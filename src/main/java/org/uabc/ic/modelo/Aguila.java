package org.uabc.ic.modelo;

public class Aguila extends Tamagochi implements TamagochiActions{
    private int nivelFuerza;
    private boolean estaVolando;
    @Override
    public void comer(int alimento) {

    }

    @Override
    public int jugar() {
        return 0;
    }

    @Override
    public int dormir(int horasDeSueno) {
        return 0;
    }

    @Override
    public boolean morir() {
        return false;
    }

    @Override
    public int sanar() {
        return 0;
    }
}
