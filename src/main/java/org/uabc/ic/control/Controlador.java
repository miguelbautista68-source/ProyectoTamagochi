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
                    int energia = vista.leerNumeros("Esribe el nivel de energia");
                    int hambre = vista.leerNumeros("Escribe el nivel de hambre");
                    int felicidad = vista.leerNumeros("Escribe el nivel de felicidad");
                    int salud = vista.leerNumeros("Escribe el nivel de salud");



                    switch (tp){
                        case 1: //Sera perro
                            int agresivo = vista.leerNumeros("Esribe el nivel de agresividad");
                            int hiper = vista.leerNumeros("Escribe el nivel de hiperactividad");

                            modelo.agregarPerro(nombre, energia, hambre, felicidad, salud, agresivo, hiper);
                            //modelo.agregarPerro(nombre, hambre, 10, 40, 60, agresivo, hiper);
                            break;
                        case 2: // sera pez dorado
                            int oxigenacion = vista.leerNumeros("Escribe el nivel de oxigenacion");
                            int calidadAgua = vista.leerNumeros("Escribe el nivel de calidad de agua");
                            int controlTemperatura = vista.leerNumeros("Escribe nivel de temperatura");

                            modelo.agregarPerDorado(nombre, energia, hambre, felicidad, salud, oxigenacion, calidadAgua, controlTemperatura);
                            //modelo.agregarPerDorado(nombre, hambre, 50, 40, 60, oxigenacion, calidadAgua, controlTemperatura);
                            break;
                        case 3: // Sera aguila
                            int nivelFuerza = vista.leerNumeros("Escribe el nivel de fuerza");
                            int velocidad = vista.leerNumeros("Escribe el nivel de velocidad");

                            modelo.agregarAguila(nombre, energia, hambre, felicidad, salud, nivelFuerza, velocidad);
                            //modelo.agregarAguila(nombre, hambre, 50, 60, 30, nivelFuerza, velocidad);
                        break;
                        case 4:
                            int tamano = vista.leerNumeros("Escribe el tamaño de tu dragon");

                            modelo.agregarDragon(nombre, energia, hambre, felicidad, salud, tamano, false, 0);
                            //modelo.agregarDragon(nombre, 50, hambre, 60, 80, tamaño, false, 0);
                            break;
                    }
                    break;
                case 2 :
                    IO.println("Mostrar lista de tamagochi");
                    vista.mostrarDatos(modelo.listaJuguetes());
                    break;
                case 3:
                    vista.mostrarDatos(modelo.listaNombres());
                    String tamagochi = vista.leerCadenas("Ingresa el nombre de tu tamagochi");
                    Tamagochi encontrado = modelo.buscarTamagochi(tamagochi);

                    if(encontrado != null){
                        IO.println("Se ha encontrado tu tamgochi, ingresa que quieres hacer");
                        int opTamagochi = vista.menuInteractuar();
                        switch(opTamagochi){
                            case 1:
                                int alimento = vista.leerNumeros(encontrado.getMenuComida());
                                encontrado.comer(alimento);
                                break;
                            case 2:
                                int juego = vista.leerNumeros(encontrado.getMenuJuegos());
                                encontrado.jugar(juego);
                                break;
                            case 3:
                                //encontrado.dormir();
                                break;
                        }
                    } else {
                        IO.println("No se ha encontrado el nombre de tu tamagochi");
                    }
                    break;
                case 4:
                    String tamagochiBuscar = vista.leerCadenas("Ingresa el nombre de tu tamagochi");
                    Tamagochi encontrar = modelo.buscarTamagochi(tamagochiBuscar);

                    if(encontrar != null){
                        IO.println(encontrar.estadoDeAnimo());
                    } else {
                        IO.println("No se ha encotrado ningun tamagochi con ese nombre");
                    }
                    break;
                case 5:
                    String tamagochiValidar = vista.leerCadenas("Ingresa el nombre de tu tamgochi");
                    Tamagochi buscarTam = modelo.buscarTamagochi(tamagochiValidar);

                    if (buscarTam != null){
                        buscarTam.hacerSonido();
                    } else {
                        IO.println("No se ha encontrado ningun tamagochi con ese nombre");
                    }
                    break;
            }
        } while (op != 6);
    }
}
