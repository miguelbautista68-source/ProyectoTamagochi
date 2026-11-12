package org.uabc.ic.modelo;

public interface TamagochiActions {
    public void comer(int alimento);
    public int  jugar();
    //Retornar un valor para que se quite la energia.
    public int dormir(int horasDeSueno);
    public boolean morir();
    public int sanar();


}
