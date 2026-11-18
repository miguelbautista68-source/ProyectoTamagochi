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
                            int oxigenacion = vista.leerNumeros("Escribe el nivel de oxigenacion");
                            int calidadAgua = vista.leerNumeros("Escribe el nivel de calidad de agua");
                            int controlTemperatura = vista.leerNumeros("Escribe nivel de temperatura");

                            modelo.agregarPerDorado(nombre, hambre, 50, 40, 60, oxigenacion, calidadAgua, controlTemperatura);
                            break;
                        case 3: // Sera aguila
                            int nivelFuerza = vista.leerNumeros("Escribe el nivel de fuerza");
                            int velocidad = vista.leerNumeros("Escribe el nivel de velocidad");

                            modelo.agregarAguila(nombre, hambre, 50, 60, 30, nivelFuerza, velocidad);
                        break;
                        case 4:
                            int tamaño = vista.leerNumeros("Escribe el tamaño de tu dragon");

                            modelo.agregarDragon(nombre, 50, hambre, 60, 80, tamaño, false, 0);
                            break;
                    }
                    break;
                case 2 :
                    IO.println("Mostrar lista de tamagochi");
                    vista.mostrarDatos(modelo.listaJuguetes());
                    break;
                case 3:
                    String tamagochi = vista.leerCadenas("Ingresa el nombre de tu tamagochi");
                    Tamagochi encontrado = modelo.buscarTamagochi(tamagochi);

                    if(encontrado != null){
                        IO.println("Se ha encontrado tu tamgochi, ingresa que quieres hacer");
                        int opTamagochi = vista.menuInteractuar();
                        switch(opTamagochi){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                    } else {
                        IO.println("No se ha encontrado el nombre de tu tamagochi");
                    }
                    break;

            }
        } while (op != 6);
    }
}
