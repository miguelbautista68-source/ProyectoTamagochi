package org.uabc.ic.modelo;
import java.util.Random;

public class Aguila extends Tamagochi implements TamagochiActions{
    private int nivelFuerza;
    private boolean estaVolando;
    private int velocidad;
    private int chillido;


    public Aguila(String nombre, int energia, int hambre, int felicidad, int salud, boolean durmmiendo, int fuerza,boolean estaVolando,  int velocidad ) {
        super(nombre, energia, hambre, felicidad, salud);
        nivelFuerza=fuerza;
        chillido=0;
    }
    public void Volar(){
        estaVolando=true;
        System.out.println("Aguila volando");
    }



    @Override
    public void comer(int alimento) {
        if  (durmiendo) {
            System.out.println(this.nombre + " esta durmiendo, no puede comer.");
            return;
        }
    }

    @Override
    public int jugar(int tipoDeJuego) {
        return 0;
    }


    @Override
    public int dormir(int horasDeSueno) {
        int antes = energia;
        durmiendo = true;
        energia = limite(energia + horasDeSueno * 10);
        hambre = limite(hambre + horasDeSueno * 2);
        IO.println(nombre + " duerme " + horasDeSueno + " hora(s). Zzz...");
        return energia - antes;
    }
    public void chillido(){
        chillido++;
        System.out.println("AAAAHHHHHHHH");
    }

    @Override
    public void hacerSonido() {
    chillido();
    }

    @Override
    public void comportamientoEspecifico() {
        Volar();

    }
    //getters y setters

    public int getNivelFuerza() {
        return nivelFuerza;
    }
    public void setNivelFuerza(int nivelFuerza) {
        this.nivelFuerza = nivelFuerza;
    }
    public boolean getEstaVolando() {
        return estaVolando;
    }
    public void setEstaVolando(boolean estaVolando) {
        this.estaVolando = estaVolando;
    }
    public int getVelocidad() {
        return velocidad;
    }
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
    public int getChillido() {
        return chillido;
    }
    public String toString(){
        return "[Aguila] " + super.toString() + " nivelFuerza: " + nivelFuerza
                + " velocidad: " + velocidad + " chillido: " + chillido;

    }
}
