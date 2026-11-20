package org.uabc.ic.modelo;

public class Dragon extends Tamagochi{
    private int tamanio;
    private boolean tirarFuego;
    private int apetito;

    public Dragon(String nombre, int energia, int hambre, int felicidad, int salud, int tamanio, boolean tirarFuego, int apetito) {
        super(nombre, energia, hambre, felicidad, salud);
        this.tamanio = tamanio;
        this.tirarFuego = tirarFuego;
        this.apetito = apetito;
    }
    public void rugir(){
        System.out.println(nombre + "dice RRAAAAAAAAAAAUGGGHHGHGHGH");

    }
    public void tiraFuego(){
        tirarFuego = true;
        System.out.println(nombre + "tira fuego");
    }
    @Override
    public void hacerSonido() {
    rugir();
    }

    @Override
    public void comportamientoEspecifico() {
    tiraFuego();
    }

    @Override
    public void comer(int alimento) {
        if (durmiendo) {
            IO.println(nombre + " esta durmiendo, no puede comer.");
            return;
        }
        switch (alimento) {
            case 1 -> {
                IO.println(nombre + " come ovejas");
                aplicarCambios(-30, 10, 3);
            }
            case 2 -> {
                IO.println(nombre + " come una vaca");
                aplicarCambios(-15, 5, 10);
            }
            case 3 -> {
                IO.println(nombre + " devora un humano");
                aplicarCambios(-40, 20, 20);
            }
            default -> IO.println("Alimentos no validos para un dragon");
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
                IO.println(nombre + " sale a cazar.");
                gasto = 10;
                aplicarCambios(5, -gasto, 15);
            }
            case 2 -> {
                gasto = 5;
                aplicarCambios(3, -gasto, 10);
                tiraFuego();
            }
            case 3 -> {
                IO.println(nombre + " sale a volar.");
                gasto = 20;
                aplicarCambios(10, -gasto, 20);
            }
            default -> {
                IO.println("Esos juegos no estan para el dragon).");
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
        return "Selecciona el tipo de comida" +
                " 1. Oveja " +
                " 2. Vaca " +
                " 3. Humano ";
    }

    @Override
    public String getMenuJuegos() {
        return "Seleciona un tipo de juego" +
                "1. Salir a cazar " +
                "2. Tirar bolas de fuego " +
                "3. Salir a volar ";
    }

    //getters y setters
    public int getTamanio() {

        return tamanio;
    }
    public void setTamanio(int tamanio) {

        this.tamanio = tamanio;
    }
    public boolean getTirarFuego() {

        return tirarFuego;
    }
    public void setTirarFuego(boolean tirarFuego) {

        this.tirarFuego = tirarFuego;
    }
    public int getApetito() {

        return apetito;
    }
    public void setApetito(int apetito) {

        this.apetito = apetito;
    }

    // Cada paso del tiempo afecta distinto segun su tamanio y apetito
    @Override
    public void pasoDelTiempo() {
        super.pasoDelTiempo(); // lo normal: +5 hambre, -3 felicidad, -3 energia

        // Dragon mas grande = le da hambre mas rapido
        hambre = limite(hambre + tamanio / 20);

        // Mas apetito = todavia mas hambre

        hambre = limite(hambre + apetito / 34);
    }

    public String toString() {
        return "[Dragon] " + super.toString() + " tamanio: " + tamanio
                + " apetito: " + apetito;
    }

    // Agrega a las estadisticas generales los atributos propios
    @Override
    public String mostrarEstadisticas() {
        return super.mostrarEstadisticas() +
                "\nTamanio: " + tamanio +
                "\nApetito: " + apetito;
    }
}
