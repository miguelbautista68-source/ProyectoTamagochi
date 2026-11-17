package org.uabc.ic.control;

import org.uabc.ic.VIsta.VistaConsola;
import org.uabc.ic.modelo.Coleccion;
import org.uabc.ic.modelo.Tamagochi;

import java.util.ArrayList;

public class Controlador {

    private VistaConsola vista;
    private Coleccion modelo;

    public Controlador(VistaConsola vista, Coleccion modelo) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar(){
        int op;
        int tp;
        do{
            op = vista.mostrarMenuPrincipal();

            switch (op){
                case 1:
                    IO.println("Leer la infomacion del tamagochi");
                    tp = vista.mostrarOpcionTamagochi();
                    //String nombre, int energia, int hambre, int felicidad, int salud, int agresividad, int imper
                    String nombre = vista.leerCadenas("Escribe el nombre de tu tamagochi");
                    int hambre = vista.leerNumeros("Escribe el nivel de hambre");


                    switch (tp){
                        case 1: //Sera perro
                            int agresivo = vista.leerNumeros("Esribe el nivel de agregsividad");
                            int hiper = vista.leerNumeros("Escribe el nivel de hiperactividad");

                            modelo.agregarPerro(nombre, hambre, 10, 40, 60, agresivo, hiper);
                            break;
                        case 2: // sera pez dorado
                            break;
                        case 3: // Sera aguila
                        break;
                    }
                    break;
                case 2 :
                    IO.println("Mostrar lista de tamagochi");
                    vista.mostrarDatos(modelo.listaJuguetes());
                    break;
            }
        } while (op != 6);
    }
}
