package org.uabc.ic.modelo;

public class Perro extends Tamagochi implements  TamagochiActions{
    private int nivelImperactividad;
    private int nivelAgresividad;

    public Perro(String nombre, int energia, int hambre, int felicidad, int salud, int agresividad, int imper){
        super(nombre, energia, hambre, felicidad, salud);
        nivelAgresividad = agresividad;
        nivelImperactividad = imper;
    }

    public Perro(){
        super("Sansa", 10, 5, 6, 7);
    }
    @Override
    public void comer(int alimento) {
        IO.println("Estoy comiendo" + alimento);
        hambre--;
        energia--;
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
