package org.uabc.ic.VIsta;

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
        IO.println("6. Salir");

        return leerNumeros.nextInt();
    }

    public int mostrarOpcionTamagochi(){
        IO.println("Salecciona la opcion de  tamagochi que deseas crear");
        IO.println("1. perro");
        IO.println("2. pez dorado");
        IO.println("3. Aguila");

        return leerNumeros.nextInt();
    }
}
