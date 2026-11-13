package org.uabc.ic.modelo;

public class PezDorado extends Tamagochi implements  TamagochiActions{
    private int calidadAgua;
    private int controlTemperatura;
    private int oxigenacion;
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
