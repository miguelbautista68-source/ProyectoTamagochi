package org.uabc.ic.VIsta;

import org.uabc.ic.modelo.Tamagochi;

import java.util.ArrayList;
import java.util.Scanner;

public class VistaConsola {

    Scanner leerNumeros = new Scanner(System.in);
    Scanner leerCadenas = new Scanner(System.in);

    public void mostrarDatos(String cadena){
        IO.println(cadena);
    }

    public String leerCadenas (String cadena){
        IO.println(cadena);
        return leerCadenas.nextLine();
    }

    public int leerNumeros (String cadena){
        IO.println(cadena);
        return leerNumeros.nextInt();
    }

    public int mostrarMenuPrincipal(){
        IO.println("1. Registrar Tamagochi nuevo");
        IO.println("2. MOstrar todos los juguetes");
        IO.println("3. Interactuar con mi tamagochi");
        IO.println("4. Checar estado de animo");
        IO.println("5. Sonido de tu tamagochi");
        IO.println("6. Mostrar estadisticas");
        IO.println("7. Salir");
        IO.println("8. Crear tamagochi a punto de morir (prueba)");

        return leerNumeros.nextInt();
    }

    public int mostrarOpcionTamagochi(){
        IO.println("Salecciona la opcion de  tamagochi que deseas crear");
        IO.println("1. Perro");
        IO.println("2. Pez dorado");
        IO.println("3. Aguila");
        IO.println("4. Dragon");

        return leerNumeros.nextInt();
    }

    public int menuInteractuar(){
            IO.println("1. Darle de comer");
            IO.println("2. Jugar con el");
            IO.println("3. Dormir");

            return leerNumeros.nextInt();
    }

    public int menuDormirONo(){
        IO.println("1. Dormir");
        IO.println("2. Despertar");

        return leerNumeros.nextInt();
    }

}
