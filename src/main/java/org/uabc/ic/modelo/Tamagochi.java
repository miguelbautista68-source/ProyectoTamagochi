package org.uabc.ic.modelo;

//Retirar tamagochiActions por el abstract que tiene

public abstract class Tamagochi implements TamagochiActions {

    protected String nombre;
    protected  int energia;
    protected  int hambre;  // El unico que 0 es satisfecho y 100 muerto de hambre
    protected  int felicidad;
    protected  int salud;
    protected  boolean durmiendo;
    protected boolean morir;

    //Establecer parametros de las condiciones que puede pasarle a cada cosa
    //sets y getters
    //Constructores
    public Tamagochi (String nombre, int energia, int hambre, int felicidad, int salud){
        this.nombre = nombre;
        this.energia = energia;
        this.hambre = hambre;
        this.felicidad = felicidad;
        this.salud = salud;
        this.durmiendo = false;
        this.morir = false;
        //this.tipoTamagochi = tipoTamagochi;
    }


    public Tamagochi(){
        this.nombre = "Solovino";
        this.hambre = 0;
        this.energia = 10;
        this.felicidad = 40;
        this.salud = 50;
        this.morir = false;
    }

    //Limites de las necesidades
    protected int limite(int valor){
        return Math.max(0, Math.min(100, valor));
    }

    //Sirve cuando se tenga cambios en los caracteristicas mediante el limite
    protected  void aplicarCambios(int conHambre, int conEnergia, int conFelicidad){
        hambre = limite(hambre + conHambre);
        energia = limite (energia + conEnergia);
        felicidad = limite (felicidad + conFelicidad);
    }

    public void pasoDelTiempo(){
        hambre = limite(hambre + 5);
        felicidad = limite( felicidad -3);
        if (!durmiendo){
            energia = limite(energia -3);
        }
        if (hambre >= 80){
            salud = limite(salud - 5);
        }
    }

    public void despertar(){
        durmiendo = false;
    }

    //Segun su estado de animo a sus necesidades
    public String estadoDeAnimo(){
        if (durmiendo){
            return "Esta durmiendo";
        }
        if (hambre >= 80 || energia <= 20 || felicidad <= 20 || salud <= 20){
            return "Esta mal";
        }

        if(hambre >= 50 || energia <= 50 || felicidad <= 50){
            return "Necesita atencion";
        }
        return "Todo bien";
    }

    // Cada especie define su sonido y su comportamiento propio
    public abstract void hacerSonido();

    public abstract void comportamientoEspecifico();

    public boolean morir() {
        if (salud <= 0){
            morir = true;
        }
        return morir;
    }

    public int sanar() {
        int antes = salud;
        salud = limite(salud + 20);
        return salud - antes;
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
