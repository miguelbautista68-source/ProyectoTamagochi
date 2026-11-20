package org.uabc.ic.modelo;


public class Perro extends Tamagochi implements  TamagochiActions {
    private int nivelImperactividad;
    private int nivelAgresividad;

    public Perro(String nombre, int energia, int hambre, int felicidad, int salud, int agresividad, int imper) {
        super(nombre, energia, hambre, felicidad, salud);
        nivelAgresividad = agresividad;
        nivelImperactividad = imper;
    }

    public Perro() {
        super("Sansa", 10, 5, 6, 7);
        this.nivelAgresividad = 30;
        this.nivelImperactividad = 60;
    }

    @Override
    public void comer(int tipoAlimento) {
        if (durmiendo) {
            IO.println(nombre + " esta durmiendo, no puede comer.");
            return;
        }
        switch (tipoAlimento) {
            case 1 -> {
                IO.println(nombre + " come croquetas");
                aplicarCambios(-30, 10, 3);
            }
            case 2 -> {
                IO.println(nombre + " roe un hueso");
                aplicarCambios(-15, 5, 10);
            }
            case 3 -> {
                IO.println(nombre + " devora un trozo de carne");
                aplicarCambios(-40, 20, 20);
            }
            default -> IO.println("Alimentos no validos para un perro tiene que ser 1 croquetas, 2 hueso, 3 carne");
        }
    }

    @Override
    public int jugar(int tipoJuego) {
        if (durmiendo) {
            IO.println(nombre + " esta durmiendo, no puede jugar.");
            return 0;
        }
        if (energia < 10) {
            IO.println(nombre + " esta muy cansado para jugar.");
            return 0;
        }
        int gasto;
        switch (tipoJuego) {
            case 1 -> {
                IO.println(nombre + " juega con la pelota.");
                gasto = 10;
                aplicarCambios(5, -gasto, 15);
            }
            case 2 -> {
                gasto = 5;
                aplicarCambios(3, -gasto, 10);
                perseguirCola();
            }
            case 3 -> {
                IO.println(nombre + " sale a correr.");
                gasto = 20;
                aplicarCambios(10, -gasto, 20);
            }
            default -> {
                IO.println("Esos juegos no estan solo esta 1 pelota, 2 perseguir cola, 3 correr).");
                gasto = 0;
            }
        }
        return gasto;
    }



    @Override
    public int dormir(int horasDeSueno) {
        int antes = energia;
        durmiendo = true;
        energia = limite(energia + horasDeSueno * 10);
        hambre = limite(hambre + horasDeSueno * 2);
        IO.println(nombre + " duerme " + horasDeSueno);
        return energia - antes;
    }

    @Override
    public String getMenuComida() {
        return "Selecciona un tipo de comida " +
                "1. Croquetas " +
                "2. Hueso " +
                "3. Carne ";
    }

    @Override
    public String getMenuJuegos() {
        return "Seleciona un tipo de juego " +
                "1. Jugar con la pelota " +
                "2. Perseguir cola " +
                "3. Salir a correr ";
    }

    @Override
    // Comportamientos especificos
    public void hacerSonido() {
        IO.println(nombre + " dice guau guau");
    }

    public void perseguirCola() {
        IO.println(nombre + " persigue su cola dando vueltas");
    }

    @Override
    public void comportamientoEspecifico() {
        perseguirCola();
    }

    // Getters y setters
    public int getNivelImperactividad() {
        return nivelImperactividad;
    }

    public void setNivelImperactividad(int nivelImperactividad) {
        this.nivelImperactividad = limite(nivelImperactividad);
    }

    public int getNivelAgresividad() {
        return nivelAgresividad;
    }

    public void setNivelAgresividad(int nivelAgresividad) {
        this.nivelAgresividad = limite(nivelAgresividad);
    }


    public String toString() {
        return "[Perro] " + super.toString() + " agresividad: " + nivelAgresividad
                + " imperactividad: " + nivelImperactividad;
    }
}