package org.uabc.ic.modelo;

public class PezDorado extends Tamagochi implements  TamagochiActions{
    private int calidadAgua;
    private int controlTemperatura;
    private int oxigenacion;

    public PezDorado(String nombre, int energia, int hambre, int felicidad, int salud, int calidadAgua,
                     int controlTemperatura, int oxigenacion) {
        super(nombre, energia, hambre, felicidad, salud);
        this.calidadAgua=calidadAgua;

    }

    @Override
    public void comer(int alimento) {

    }

    @Override
    public int jugar(int tipoDeJuego) {
        return 0;
    }


    @Override
    public int dormir(int horasDeSueno) {
        return 0;
    }

    @Override
    public void hacerSonido() {

    }

    @Override
    public void comportamientoEspecifico() {

    }

}
