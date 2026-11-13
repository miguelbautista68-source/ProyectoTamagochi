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

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia){
        this.energia = energia;
    }

    public int getHambre(){
        return hambre;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public int getFelicidad() {
        return felicidad;
    }

    public void setFelicidad(int felicidad) {
        this.felicidad = felicidad;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String toString(){
        return "TU tamagochi de  nombre " + nombre + " su energia es de " + energia + " su hambre es de " + hambre +
                " y su felicidad de " + felicidad + " tiene salud de: " + salud;
    }
}
