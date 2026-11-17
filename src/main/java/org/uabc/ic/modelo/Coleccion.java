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

}
