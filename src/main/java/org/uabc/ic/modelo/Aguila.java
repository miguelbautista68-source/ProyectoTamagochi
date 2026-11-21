package org.uabc.ic.modelo;
import java.util.Random;

public class Aguila extends Tamagochi implements TamagochiActions {
    private int nivelFuerza;
    private int velocidad;
    private boolean estaVolando;


    public Aguila(String nombre, int energia, int hambre, int felicidad, int salud, int fuerza, int velocidad) {
        super(nombre, energia, hambre, felicidad, salud);
        nivelFuerza = fuerza;
        this.velocidad = velocidad;
        this.estaVolando = false;
    }

    public void Volar() {
        estaVolando = true;
        System.out.println("Aguila volando");
    }


    @Override
    public void comer(int alimento) {
        if (durmiendo) {
            System.out.println(this.nombre + " esta durmiendo, no puede comer.");
            return;
        }
        switch (alimento) {
            case 1 -> {
                IO.println(nombre + " come gusanos");
                aplicarCambios(-30, 10, 3);
            }
            case 2 -> {
                IO.println(nombre + " come un raton");
                aplicarCambios(-15, 5, 10);
            }
            case 3 -> {
                IO.println(nombre + " devora una serpiente");
                aplicarCambios(-40, 20, 20);
            }
            default -> IO.println("Alimentos no validos para un aguila");
        }
    }

    @Override
    public int jugar(int tipoDeJuego) {
        if (durmiendo) {
            IO.println(nombre + " esta durmiendo, no puede jugar.");
            return 0;
        }
        if (energia < 10) {
            IO.println(nombre + " esta muy cansado para jugar.");
            return 0;
        }
        int gasto;
        switch (tipoDeJuego) {
            case 1 -> {
                IO.println(nombre + " juega con su munieco.");
                gasto = 10;
                aplicarCambios(5, -gasto, 15);
            }
            case 2 -> {
                gasto = 5;
                aplicarCambios(3, -gasto, 10);
                Volar();
            }
            case 3 -> {
                IO.println(nombre + " juega con su amigo.");
                gasto = 20;
                aplicarCambios(10, -gasto, 20);
            }
            default -> {
                IO.println("Esos juegos no estan para el aguila).");
                gasto = 0;
            }
        }
        return 0;
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
        return "Selecciona el tipo de comida" +
                "1. Gusanos " +
                "2. Raton " +
                "3. Serpiente ";
    }

    @Override
    public String getMenuJuegos() {
        return "Seleciona un tipo de juego" +
                "1. Jugar con su munñeco " +
                "2. Salir a volar " +
                "3. Jugar con su amigo ";
    }

    public void chillido() {
        System.out.println("AAAAHHHHHHHH");
    }

    @Override
    public void hacerSonido() {
        chillido();
    }

    @Override
    public void comportamientoEspecifico() {
        Volar();

    }
    //getters y setters

    public int getNivelFuerza() {
        return nivelFuerza;
    }

    public void setNivelFuerza(int nivelFuerza) {
        this.nivelFuerza = nivelFuerza;
    }

    public boolean getEstaVolando() {
        return estaVolando;
    }

    public void setEstaVolando(boolean estaVolando) {
        this.estaVolando = estaVolando;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String toString() {
        return "[Aguila] " + super.toString() + " nivelFuerza: " + nivelFuerza
                + " velocidad: " + velocidad;

    }

    // Cada paso del tiempo afecta distinto segun su fuerza y velocidad
    @Override
    public void pasoDelTiempo() {
        super.pasoDelTiempo();

        // Mas velocidad = gasta mas energia
        if (!durmiendo) {
            if (velocidad > 66) {
                energia = limite(energia - 3);
            } else if (velocidad > 33) {
                energia = limite(energia - 1);
            }
        }

        // Mas fuerza = necesita comer mas
        if (nivelFuerza > 66) {
            hambre = limite(hambre + 3);
        } else if (nivelFuerza > 33) {
            hambre = limite(hambre + 1);
        }
    }

    // Agrega a las estadisticas generales los atributos propios
    @Override
    public String mostrarEstadisticas() {
        return super.mostrarEstadisticas() +
                "\nFuerza: " + nivelFuerza +
                "\nVelocidad: " + velocidad +
                "\nEsta volando: " + (estaVolando ? "Si" : "No");
    }
}
