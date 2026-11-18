package org.uabc.ic.modelo;

import java.util.ArrayList;

public class Coleccion {
    private ArrayList<Tamagochi> misJueguetes;

    public Coleccion(){
        misJueguetes = new ArrayList<>();
    }

    public void agregar(Tamagochi t){
        misJueguetes.add(t);
    }

    public String listaJuguetes(){
        StringBuffer cadena = new StringBuffer();
        for(Tamagochi t : misJueguetes){
            cadena.append(t);
        }
        return cadena.toString();
    }

    public void agregarPerro(String nombre, int energia, int hambre, int felicidad, int salud, int agresividad, int imper){
        agregar (new Perro(nombre,energia ,hambre, felicidad, salud, agresividad, imper));
    }

    public void agregarPerDorado (String nombre, int energia, int hambre, int felicidad, int salud, int agua,
                                  int controlTemperatura, int oxigenacion){
        agregar(new PezDorado(nombre, energia, hambre, felicidad, salud, agua, controlTemperatura, oxigenacion));
    }

    public void agregarAguila(String nombre, int energia, int hambre, int felicidad, int salud, int fuerza,  int velocidad){
        agregar (new Aguila(nombre, energia, hambre, felicidad, salud, fuerza,  velocidad));
    }

    public void agregarDragon(String nombre, int energia, int hambre, int felicidad, int salud, int tamanio, boolean tirarFuego, int apetito){
        agregar(new Dragon(nombre, energia, hambre, felicidad, salud, tamanio, tirarFuego, apetito));
    }

}
