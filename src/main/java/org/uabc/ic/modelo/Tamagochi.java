package org.uabc.ic.modelo;

public class Tamagochi {

    protected String nombre;
    protected  int energia;
    protected  int hambre;
    protected  int felicidad;
    protected  int salud;

    //Establecer parametros de las condiciones que puede pasarle a cada cosa
    //sets y getters
    //Constructores
    public Tamagochi (String nombre, int energia, int hambre, int felicidad, int salud){
        this.nombre = nombre;
        this.energia = energia;
        this.hambre = hambre;
        this.felicidad = felicidad;
        this.salud = salud;
    }


    public Tamagochi(){
        this.nombre = "Miguel";
        this.hambre = 0;
        this.energia = 10;
        this.felicidad = 40;
        this.salud = 50;
    }



}
