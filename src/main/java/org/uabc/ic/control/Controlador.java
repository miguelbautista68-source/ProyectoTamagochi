package org.uabc.ic.control;

import org.uabc.ic.VIsta.VistaConsola;
import org.uabc.ic.modelo.Coleccion;
import org.uabc.ic.modelo.Tamagochi;

import java.util.ArrayList;
import java.util.Random;

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
                    Random rdm = new Random();


                    switch (tp){
                        case 1: //Sera perro

                            int agresivo = rdm.nextInt(101);
                            int hiper = rdm.nextInt(101);

                            modelo.agregarPerro(nombre, 100, 0, 100, 100, agresivo, hiper);
                            //modelo.agregarPerro(nombre, 0, 100, 40, 0, agresivo, hiper);
                            break;
                        case 2: // sera pez dorado
                            int oxigenacion = rdm.nextInt(101);
                            int calidadAgua = rdm.nextInt(101);
                            int controlTemperatura = rdm.nextInt(101);

                            modelo.agregarPerDorado(nombre, 100, 0, 100, 100, calidadAgua, controlTemperatura, oxigenacion);
                            //modelo.agregarPerDorado(nombre, 40, 50, 40, 0, oxigenacion, calidadAgua, controlTemperatura);
                            break;
                        case 3: // Sera aguila
                            int nivelFuerza = rdm.nextInt(101);
                            int velocidad = rdm.nextInt(101);

                            modelo.agregarAguila(nombre, 100, 0, 100, 100, nivelFuerza, velocidad);
                            //modelo.agregarAguila(nombre, 10, 50, 60, 0, nivelFuerza, velocidad);
                        break;
                        case 4:
                            int tamano = rdm.nextInt(101);
                            int apetito = rdm.nextInt(101);

                            modelo.agregarDragon(nombre, 100, 0, 100, 100, tamano, false, apetito);
                            //modelo.agregarDragon(nombre, 50, 40, 60, 0, tamaño, false, 0);
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

                    if(encontrado != null) {
                        if (encontrado.morir() == true) {
                            IO.println("Tu mascota ha muerto");
                        } else {
                            IO.println("Se ha encontrado tu tamgochi, ingresa que quieres hacer");
                            int opTamagochi = vista.menuInteractuar();
                            switch (opTamagochi) {
                                case 1:
                                    int alimento = vista.leerNumeros(encontrado.getMenuComida());
                                    encontrado.comer(alimento);
                                    break;
                                case 2:
                                    int juego = vista.leerNumeros(encontrado.getMenuJuegos());
                                    encontrado.jugar(juego);
                                    break;
                                case 3:
                                    int opDormir = vista.menuDormirONo();
                                    switch (opDormir){
                                        case 1:
                                            encontrado.dormir();
                                            IO.println(encontrado.getNombre() + " esta durmiendo");
                                            break;
                                        case 2:
                                            encontrado.despertar();
                                            IO.println(encontrado.getNombre() + " esta despierto");
                                            break;
                                    }
                                    break;
                            }
                        }
                        } else{
                            IO.println("No se ha encontrado el nombre de tu tamagochi");
                        }
                    break;
                case 4:
                    vista.mostrarDatos(modelo.listaNombres());
                    String tamagochiBuscar = vista.leerCadenas("Ingresa el nombre de tu tamagochi");
                    Tamagochi encontrar = modelo.buscarTamagochi(tamagochiBuscar);

                    if(encontrar != null) {
                        if (encontrar.morir() == true) {
                            IO.println("Tu mascota ha muerto");
                        } else {
                            IO.println(encontrar.estadoDeAnimo());
                        }
                        } else{
                            IO.println("No se ha encotrado ningun tamagochi con ese nombre");
                        }
                    break;
                case 5:
                    vista.mostrarDatos(modelo.listaNombres());
                    String tamagochiValidar = vista.leerCadenas("Ingresa el nombre de tu tamgochi");
                    Tamagochi buscarTam = modelo.buscarTamagochi(tamagochiValidar);

                    if (buscarTam != null){
                        if (buscarTam.morir() == true) {
                            IO.println("Tu mascota ha muerto");
                        } else {
                            buscarTam.hacerSonido();
                        }
                    } else {
                        IO.println("No se ha encontrado ningun tamagochi con ese nombre");
                    }
                    break;
                case 6:
                    vista.mostrarDatos(modelo.listaNombres());
                    String tamagochiEstadisticas = vista.leerCadenas("Ingresa el nombre de tu tamagochi");
                    Tamagochi buscarEst = modelo.buscarTamagochi(tamagochiEstadisticas);

                    if (buscarEst != null) {
                        vista.mostrarDatos(buscarEst.mostrarEstadisticas());
                    } else {
                        IO.println("No se ha encontrado ningun tamagochi con ese nombre");
                    }
                    break;

                case 8:
                    // Crea de una vez un perro casi muerto (salud 5, hambre 90)
                    modelo.agregarPerro("Moribundo", 10, 90, 10, 5, 50, 50);
                    IO.println("Se creo perro moribundo ");
                    break;

            }

            if (op >= 1 && op <= 4) {
                modelo.pasarTiempoATodos();

                // Despues de que pasa el tiempo se eliminan los que murieron
                modelo.eliminarMuertos();
            }

        } while (op != 7);
    }
}
